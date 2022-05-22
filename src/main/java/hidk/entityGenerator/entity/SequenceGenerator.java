package hidk.entityGenerator.entity;

public class SequenceGenerator
{
    private  String schema;
    private  String name;
    private  String sequenceName;
    private  String catalog;
    private  int initialValue;
    private  int allocationSize;

    public SequenceGenerator(String schema, String name, String sequenceName, String catalog, int initialValue, int allocationSize)
    {
        this.schema = schema;
        this.name = name;
        this.sequenceName = sequenceName;
        this.catalog = catalog;
        this.initialValue = initialValue;
        this.allocationSize = allocationSize;
    }

    public SequenceGenerator(){};

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

    public String getSequenceName()
    {
        return sequenceName;
    }

    public void setSequenceName(String sequenceName)
    {
        this.sequenceName = sequenceName;
    }

    public String getCatalog()
    {
        return catalog;
    }

    public void setCatalog(String catalog)
    {
        this.catalog = catalog;
    }

    public int getInitialValue()
    {
        return initialValue;
    }

    public void setInitialValue(int initialValue)
    {
        this.initialValue = initialValue;
    }

    public int getAllocationSize()
    {
        return allocationSize;
    }

    public void setAllocationSize(int allocationSize)
    {
        this.allocationSize = allocationSize;
    }

    @Override
    public String toString()
    {
        return "SequenceGenerator{" +
                "schema='" + schema + '\'' +
                ", name='" + name + '\'' +
                ", sequenceName='" + sequenceName + '\'' +
                ", catalog='" + catalog + '\'' +
                ", initialValue=" + initialValue +
                ", allocationSize=" + allocationSize +
                '}';
    }
}
