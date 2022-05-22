package entityGenerator;

import hidk.entityGenerator.EntityParser;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

class EntityParserTest
{
    @Test
    void processJSONEncodedEntityTest() throws JSONException, IOException, InterruptedException
    {
        StringBuilder jsonFileData = new StringBuilder();
        try {
            File myObj = new File("src/test/resources/apiConfig.json");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                jsonFileData.append( data );
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        JSONObject jsonEncoded = new JSONObject( jsonFileData.toString() );
        EntityParser testable = new EntityParser( jsonEncoded.getJSONArray( "entity" ) );

        System.out.println( testable.getEntities() );
    }
}