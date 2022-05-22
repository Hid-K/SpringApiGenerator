package hidk.entityGenerator.javaEntityClassCodeGenerator;

public class EntityClass
{
    private String name;
    private String code;

    public EntityClass(String name, String code)
    {
        this.name = name;
        this.code = code;
    }

    public EntityClass(){};

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }
}
