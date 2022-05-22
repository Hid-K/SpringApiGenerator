package hidk.entityGenerator.entity;

public class GeneratedValue
{
    private  int strategy;
    private  String generator;

    public GeneratedValue(int strategy, String generator)
    {
        this.strategy = strategy;
        this.generator = generator;
    }

    public GeneratedValue(){};

    public int getStrategy()
    {
        return strategy;
    }

    public void setStrategy(int strategy)
    {
        this.strategy = strategy;
    }

    public String getGenerator()
    {
        return generator;
    }

    public void setGenerator(String generator)
    {
        this.generator = generator;
    }
}
