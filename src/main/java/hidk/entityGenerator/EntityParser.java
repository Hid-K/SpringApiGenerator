package hidk.entityGenerator;

import hidk.entityGenerator.entity.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class EntityParser
{
    private JSONArray entityData;

    public EntityParser(JSONArray entityData)
    {
        this.entityData = entityData;
    }

    public List<Entity> getEntities() throws JSONException
    {
        List<Entity> result = new LinkedList<>();

        for (int i = 0; i < this.entityData.length(); ++i)
        {
            result.add(this.processJSONEncodedEntity((JSONObject) this.entityData.get(i)));
        }

        return result;
    }

    private Entity processJSONEncodedEntity(JSONObject jSONEncodedEntity) throws JSONException
    {
        Entity result = new Entity();

        try
        {
            result.setName((String) jSONEncodedEntity.get("name"));
        } catch (JSONException e)
        {
            throw new JSONException("CRITICAL: No \"name\" field provided in JSON property define!");
        }

        JSONObject jsonEncodedDBProperty = this.extractJSONEncodedData(jSONEncodedEntity, "DBProperty");

        JSONObject jsonEncodedTable = this.extractJSONEncodedData(jsonEncodedDBProperty, "Table");

        Table tableProperty = new Table();

        tableProperty.setName( (String) this.extractDataFromJSON(jsonEncodedTable, "name") );
        tableProperty.setSchema( (String) this.extractDataFromJSON(jsonEncodedTable, "schema") );

        EntityDBProperty dbProperty = new EntityDBProperty(tableProperty);

        List<Field> fields = extractFieldsFromJSONEncodedEntity( jSONEncodedEntity );

        result.setFields( fields );
        result.setdBProperty( dbProperty );

        return result;
    }

    private List<Field> extractFieldsFromJSONEncodedEntity( JSONObject jsonEncoded ) throws JSONException
    {
        JSONArray jsonEncodedFields = this.extractJSONArray( jsonEncoded, "fields" );

        List<Field> result = new LinkedList<>();

        for( int i = 0; i < jsonEncodedFields.length(); ++i )
        {
            Field field = new Field();
            FieldDBProperty dbProperty = this.extractDBPropertyFromJSONEncoded( ((JSONObject) jsonEncodedFields.get(i)).getJSONObject("FieldDBProperty") );

            field.setName( (String) this.extractDataFromJSON( (JSONObject) jsonEncodedFields.get(i), "name" ) );
            field.setType( (String) this.extractDataFromJSON( (JSONObject) jsonEncodedFields.get(i), "type" ) );

            field.setProperty(dbProperty);

            result.add(field);
        }
        
        return result;
    }

    private FieldDBProperty extractDBPropertyFromJSONEncoded( JSONObject jsonEncoded ) throws JSONException
    {
        FieldDBProperty result = new FieldDBProperty();

        try
        {
            result.setGeneratedValueProperty(this.extractGeneratedValueFromJSONEncoded(jsonEncoded.getJSONObject("GeneratedValue")));
        } catch ( JSONException e )
        {
            result.setGeneratedValueProperty(null);
        }

        try
        {
            result.setSequenceGeneratorProperty( this.extractSequenceGeneratorFromJSONEcoded( jsonEncoded.getJSONObject( "SequenceGenerator" ) ) );
        } catch ( JSONException e )
        {
            result.setSequenceGeneratorProperty(null);
        }

        try
        {
            result.getIsId( (Boolean) this.extractDataFromJSON( jsonEncoded, "isId" ) );
        } catch ( Exception e )
        {
            result.getIsId( false );
        }


        try
        {
            result.setSize((Integer) this.extractDataFromJSON(jsonEncoded, "Size"));
        } catch ( Exception e )
        {
            result.setSize( null );
        }

        Column columnData;

        try
        {
            columnData = this.extractColumnDataFromJSONEncoded(jsonEncoded.getJSONObject("Column"));
        } catch ( JSONException e )
        {
            columnData = null;
        }

        result.setColumnProperty( columnData );

        return result;
    }

    private Column extractColumnDataFromJSONEncoded( JSONObject jsonEncoded ) throws JSONException
    {
        Column result = new Column();

        result.setName( jsonEncoded.getString( "name" ) );
        result.setLength( jsonEncoded.getLong( "length" ) );

        return result;
    }

    private SequenceGenerator extractSequenceGeneratorFromJSONEcoded( JSONObject jsonEncoded ) throws JSONException
    {
        SequenceGenerator result = new SequenceGenerator();

        result.setName(           jsonEncoded.getString("name" ) );
        result.setCatalog(        jsonEncoded.getString("catalog" ) );
        result.setSequenceName(   jsonEncoded.getString("sequenceName" ) );
        result.setSchema(         jsonEncoded.getString("schema" ) );
        result.setInitialValue(   jsonEncoded.getInt("initialValue" ) );
        result.setAllocationSize( jsonEncoded.getInt("allocationSize" ) );

        return result;
    }

    private GeneratedValue extractGeneratedValueFromJSONEncoded(JSONObject jsonEncoded ) throws JSONException
    {
        GeneratedValue result = new GeneratedValue();
        
        result.setGenerator( jsonEncoded.getString( "generator" ) );
        result.setStrategy( jsonEncoded.getInt( "strategy" ) );
        
        return result;
    }    
    private JSONObject extractJSONEncodedData(JSONObject jsonEncoded, String name) throws JSONException
    {
        try
        {
            return (JSONObject) jsonEncoded.get(name);
        } catch (JSONException e)
        {
            throw new JSONException("CRITICAL: No \"" + name + "\" field provided in JSON property define!");
        }
    }

    private Object extractDataFromJSON( JSONObject jsonEncoded, String name ) throws JSONException
    {
        try
        {
            return jsonEncoded.get(name);
        } catch (JSONException e)
        {
            throw new JSONException("CRITICAL: No \"" + name + "\" field provided in JSON property define!");
        }
    }

    private JSONArray extractJSONArray( JSONObject jsonEncoded, String name ) throws JSONException
    {
        try
        {
            return (JSONArray) jsonEncoded.get(name);
        } catch (JSONException e)
        {
            throw new JSONException("CRITICAL: No \"" + name + "\" field provided in JSON property define!");
        }
    }
}
