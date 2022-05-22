package hidk.entityGenerator.entity;

public class Table
{
    private String schema;
    private String name;

    public Table(String schema, String name)
    {
        this.schema = schema;
        this.name = name;
    }

    public Table(){};

    public String getSchema()
    {
        return schema;
    }

    public void setSchema(String schema)
    {
        this.schema = schema;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Table{" +
                "schema='" + schema + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
