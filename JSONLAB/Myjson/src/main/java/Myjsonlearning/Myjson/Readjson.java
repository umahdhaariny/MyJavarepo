package Myjsonlearning.Myjson;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import Myjsonlearning.Myjson.Entity.CArs;

public class Readjson {	

	public static void main(String args[]) throws StreamReadException, DatabindException, IOException {
		ObjectMapper obj1 = new ObjectMapper();
	
		CArs car = obj1.readValue(new URL("file:\\dsa java\\JSONLAB\\Myjson\\target\\car1.json"), CArs.class);
		System.out.println("vallue of car "+" color is" + car.getColor() + " type is"+car.getType());
		JsonNode value = obj1.readTree(new URL("file:\\dsa java\\JSONLAB\\Myjson\\target\\car1.json"));
		String color =value.get("color").asText();
		
		System.out.println("the color is"+color);
		String jsonString 
		  = "{ \"color\" : \"Black\", \"type\" : \"Fiat\", \"year\" : \"1970\" }";
		value = obj1.readTree(jsonString);
		String type = value.get("type").asText();
		System.out.println(type +"type");
	
	}
	
}
