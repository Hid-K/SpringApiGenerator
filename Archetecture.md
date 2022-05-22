# Spring API Generator

* Define entityes
* Define services
* Define managers
* Define endpoints
* 

## Entity define

```json
{
  "entity":
          [
            {
              "name": "User",
              "DBProperty":
              {
                "Table":
                {
                  "schema": "entityGenerationTest",
                  "name": "user"
                }
              },
              "fields":
                      [
                        {
                          "name": "id",
                          "type": "Long",
                          "DBProperty":
                          {
                            "isId": true,
                            "Size": 50,
                            "Column":
                            {
                              "length": 50,
                              "name": "id"
                            },
                            "GeneratedValue":
                            {
                              "strategy": "GenerationType.SEQUENCE",
                              "generator": "USER_SEQ"
                            },
                            "SequenceGenerator":
                            {
                              "schema": "entityGenerationTest",
                              "name" : "USER_SEQ",
                              "sequenceName": "",
                              "catalog": "",
                              "initialValue": 0,
                              "allocationSize": 1
                            }
                          }
                        }
                      ]
            }
          ]
}
```

```mermaid
classDiagram
class Entity{
	String name;
	EntityDBProperty dBProperty;
	
	Field[] fields;
}

class EntityDBProperty{
	Table tableProperty;
}

class Table{
	String schema;
	String name;
}

Table --> EntityDBProperty : table 

class Field{
	String name;
	String type;
	
	DBProperty property;
}

FieldDBProperty --> Field : property

class FieldDBProperty{
	Boolean isId;
	Long Size;
	
	Column columnProperty;
	GeneratedValue generatedValueProperty;
	SequenceGenerator sequenceGeneratorProperty;
	
}

Column --> FieldDBProperty : columnProperty

class Column{
	String name;
	Long length;
}

GeneratedValue --> FieldDBProperty : generatedValueProperty

class GeneratedValue{
	int strategy;
	String generator;
	
}

SequenceGenerator --> FieldDBProperty : sequenceGeneratorProperty

class SequenceGenerator{
	String schema;
  String name;
  String sequenceName;
  String catalog;
  int initialValue;
  int allocationSize;
}
```

