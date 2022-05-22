package hidk;

public class GeneratorConfig
{
    String language;

    String entityPackage;
    String dtoPackage;

    public GeneratorConfig(String language, String entityPackage, String dtoPackage)
    {
        this.language = language;
        this.entityPackage = entityPackage;
        this.dtoPackage = dtoPackage;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public String getEntityPackage()
    {
        return entityPackage;
    }

    public void setEntityPackage(String entityPackage)
    {
        this.entityPackage = entityPackage;
    }

    public String getDtoPackage()
    {
        return dtoPackage;
    }

    public void setDtoPackage(String dtoPackage)
    {
        this.dtoPackage = dtoPackage;
    }
}
