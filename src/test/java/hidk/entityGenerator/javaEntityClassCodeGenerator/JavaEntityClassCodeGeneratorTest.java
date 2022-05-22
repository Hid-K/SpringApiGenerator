package hidk.entityGenerator.javaEntityClassCodeGenerator;

import hidk.entityGenerator.EntityParser;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class JavaEntityClassCodeGeneratorTest
{
    @Test
    void generateEntityClassCodeTest() throws JSONException
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

        JavaEntityClassCodeGenerator javaEntityClassCodeGenerator = new JavaEntityClassCodeGenerator( testable.getEntities() );

        System.out.println( javaEntityClassCodeGenerator.generateEntityClassesCode().get(0).getCode() );
    }
}