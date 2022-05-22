package hidk.entityGenerator.entity;

public class EntityDBProperty
{
    private Table tableProperty;

    public EntityDBProperty(Table tableProperty)
    {
        this.tableProperty = tableProperty;
    }

    public EntityDBProperty()
    {

    }

    public Table getTableProperty()
    {
        return tableProperty;
    }

    public void setTableProperty(Table tableProperty)
    {
        this.tableProperty = tableProperty;
    }

    @Override
    public String toString()
    {
        return "EntityDBProperty{" +
                "tableProperty=" + tableProperty +
                '}';
    }
}
