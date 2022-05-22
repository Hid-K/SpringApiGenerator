package hidk.entityGenerator.entity;

public class FieldDBProperty
{
    private Boolean isId;
    private Integer Size;

    private Column columnProperty;
    private GeneratedValue generatedValueProperty;
    private SequenceGenerator sequenceGeneratorProperty;

    public FieldDBProperty(Boolean isId, int size, Column columnProperty, GeneratedValue generatedValueProperty, SequenceGenerator sequenceGeneratorProperty)
    {
        this.isId = isId;
        Size = size;
        this.columnProperty = columnProperty;
        this.generatedValueProperty = generatedValueProperty;
        this.sequenceGeneratorProperty = sequenceGeneratorProperty;
    }

    public FieldDBProperty(){};

    public Boolean getIsId()
    {
        return isId;
    }

    public void getIsId(Boolean id)
    {
        isId = id;
    }

    public Integer getSize()
    {
        return Size;
    }

    public void setSize(Integer size)
    {
        Size = size;
    }

    public Column getColumnProperty()
    {
        return columnProperty;
    }

    public void setColumnProperty(Column columnProperty)
    {
        this.columnProperty = columnProperty;
    }

    public GeneratedValue getGeneratedValueProperty()
    {
        return generatedValueProperty;
    }

    public void setGeneratedValueProperty(GeneratedValue generatedValueProperty)
    {
        this.generatedValueProperty = generatedValueProperty;
    }

    public SequenceGenerator getSequenceGeneratorProperty()
    {
        return sequenceGeneratorProperty;
    }

    public void setSequenceGeneratorProperty(SequenceGenerator sequenceGeneratorProperty)
    {
        this.sequenceGeneratorProperty = sequenceGeneratorProperty;
    }

    @Override
    public String toString()
    {
        return "FieldDBProperty{" +
                "isId=" + isId +
                ", Size=" + Size +
                ", columnProperty=" + columnProperty +
                ", generatedValueProperty=" + generatedValueProperty +
                ", sequenceGeneratorProperty=" + sequenceGeneratorProperty +
                '}';
    }
}
