package Myjsonlearning.Myjson;
import java.io.File;
import java.io.IOException;


import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import Myjsonlearning.Myjson.Entity.CArs;


/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws StreamWriteException, DatabindException, IOException
    
    {
    	ObjectMapper obj1 = new ObjectMapper();
    	CArs car1 = new CArs("yellow","maruthi");
    	CArs car = new CArs("blue","maruthi");
    	//obj1.writeValueAsString(new File("D:\\dsa java\\JSONLAB\\Myjson\\target\\carstring.json"));
    	obj1.writeValue(new File("D:\\dsa java\\JSONLAB\\Myjson\\target\\car1.json"), car1);
    	obj1.writeValueAsString(new File("D:\\dsa java\\JSONLAB\\Myjson\\target\\car.json"));
    	
        System.out.println( "Hello World!" );
    }
}
