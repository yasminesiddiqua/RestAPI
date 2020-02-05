package sample;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsnReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readJsonFile();
	}
	
	public static List<String> readJsonFile()
    {
    	 //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        
        List<String> services = null;
         
        try 
        {
		    FileReader reader = new FileReader("C:\\Users\\Dell1\\Downloads\\10testcases.postman_collection.json");
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONObject collectionList = (JSONObject) obj;
            //System.out.println(collectionList);
			
			JSONArray itemList = (JSONArray)collectionList.get("item");
			//System.out.println(itemList);
			System.out.println(itemList.size());
			services = new ArrayList<String>();
			
			for(int i = 0 ; i < itemList.size(); i++) {
			
			JSONObject caseList=(JSONObject)itemList.get(i);
			//System.out.println(caseList);
			
			JSONObject requestList=(JSONObject)caseList.get("request");
			//System.out.println(requestList);
			
			JSONObject url=(JSONObject)requestList.get("url");
			//System.out.println(url);
			
			Object raw=url.get("raw");
			//System.out.println(raw);
			
			String link=(String)raw;
			if(!link.isEmpty())
				services.add(link);
			
			}
			
		}
        catch (Exception e) {
			
        	e.printStackTrace();
		}
        
        for(String i : services)
        	System.out.println(i);
		return services;
    }
 

}
