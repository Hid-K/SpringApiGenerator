package hidk.entityGenerator.entity;

import java.util.Iterator;
import java.util.List;

public class Entity
{
    private String name;
    private EntityDBProperty dBProperty;

    private List<Field> fields;

    public Entity(String name, EntityDBProperty dBProperty, List<Field> fields)
    {
        this.name = name;
        this.dBProperty = dBProperty;
        this.fields = fields;
    }

    public Entity()
    {

    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public EntityDBProperty getdBProperty()
    {
        return dBProperty;
    }

    public void setdBProperty(EntityDBProperty dBProperty)
    {
        this.dBProperty = dBProperty;
    }

    public List<Field> getFields()
    {
        return fields;
    }

    public void setFields(List<Field> fields)
    {
        this.fields = fields;
    }

    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[");

        Iterator iter = fields.iterator();

        while( iter.hasNext() )
        {
            stringBuilder.append( iter.next().toString() );
        }

        stringBuilder.append("]");

        return "Entity{" +
                "name='" + name + '\'' +
                ", dBProperty=" + dBProperty +
                ", fields=" + stringBuilder.toString() +
                '}';
    }
}
