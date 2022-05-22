package hidk.entityGenerator.entity;

public class Field
{
    private  String name;
    private  String type;

    private FieldDBProperty property;

    public Field(String name, String type, FieldDBProperty property)
    {
        this.name = name;
        this.type = type;
        this.property = property;
    }
    public Field(){};

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public FieldDBProperty getProperty()
    {
        return property;
    }

    public void setProperty(FieldDBProperty property)
    {
        this.property = property;
    }

    @Override
    public String toString()
    {
        return "Field{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", property=" + property +
                '}';
    }
}
