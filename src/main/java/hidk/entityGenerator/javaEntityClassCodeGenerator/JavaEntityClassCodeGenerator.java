package hidk.entityGenerator.javaEntityClassCodeGenerator;

import hidk.GeneratorConfig;
import hidk.entityGenerator.EntityCodeClassGenerator;
import hidk.entityGenerator.entity.Entity;
import hidk.entityGenerator.entity.Field;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;



public class JavaEntityClassCodeGenerator implements EntityCodeClassGenerator
{
    List<Entity> entityList;
    GeneratorConfig generatorConfig;

    public JavaEntityClassCodeGenerator(List<Entity> entityList)
    {
        this.entityList = entityList;
        this.generatorConfig = generatorConfig;
    }

    public List<EntityClass> generateEntityClassesCode()
    {
        List<EntityClass> result = new LinkedList<>();

        Iterator<Entity> iter = entityList.iterator();

        while ( iter.hasNext() )
        {
            Entity currentEntity = iter.next();
            result.add( new EntityClass( currentEntity.getName(), generateEntityClassCode( currentEntity ) ) );
        }

        return result;
    }

    public String generateEntityClassCode( Entity entity )
    {
        StringBuilder result = new StringBuilder();

        result.append( "@Entity\npublic class " + entity.getName() + "\n{\n" );

         Iterator<Field> iter = entity.getFields().iterator();

         while ( iter.hasNext() )
         {
             result.append( generateCodeForField( iter.next() ) + "\n\n" );
         }

         result.append("}");

        return result.toString();
    }

    private String generateCodeForField( Field field )
    {
        StringBuilder result = new StringBuilder();

        if( field.getProperty().getIsId() )
        {
            result.append("@Id\n");
        }

        if( field.getProperty().getGeneratedValueProperty() != null )
        {
            result.append( "@GeneratedValue( generator = " +
                                field.getProperty().getGeneratedValueProperty().getGenerator() +
                    ", strategy = " + field.getProperty().getGeneratedValueProperty().getStrategy() + ")\n");
        }

        if( field.getProperty().getSequenceGeneratorProperty() != null )
        {
            result.append( "@SequenceGenerator( schema = " + field.getProperty().getSequenceGeneratorProperty().getSchema() +
                                               ", name = " + field.getProperty().getSequenceGeneratorProperty().getName() +
                                               ", allocationSize = " + field.getProperty().getSequenceGeneratorProperty().getAllocationSize() + ")\n");
        }

        if( field.getProperty().getColumnProperty() != null )
        {
            result.append( "@Column( name = " + field.getProperty().getColumnProperty().getName() +
                           ", length = " + field.getProperty().getColumnProperty().getLength() + ")\n");
        }

        if( field.getProperty().getSize() != null )
        {
            result.append( "@Size( max = " + field.getProperty().getSize() + " )\n" );
        }

        result.append( field.getType() + " " + field.getName() + ";" );

        return result.toString();
    }
}
