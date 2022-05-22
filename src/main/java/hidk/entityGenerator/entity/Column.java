package hidk.entityGenerator.entity;

public class Column
{
    private  String name;
    private  Long length;

    public Column(String name, Long length)
    {
        this.name = name;
        this.length = length;
    }

    public Column(){};

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Long getLength()
    {
        return length;
    }

    public void setLength(Long length)
    {
        this.length = length;
    }
}
