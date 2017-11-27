package com.ibm.diamondoffshore.edgeservice.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.ibm.diamondoffshore.edgeservice.data.DrillOperations;

public class MessageParser3 {

    public static void main(String[] args) {

    	final GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();
        JSONObject j;
        
        JSONParser parser = new JSONParser();
        JSONArray jsonarray = null;
        JSONObject obj = null;
		try {
			obj = (JSONObject)parser.parse(new FileReader("C:\\eclipse\\springbootlearning3\\TimeSeriesLoader\\RimmDrillMsg.json"));
			//obj = (JSONObject)parser.parse(new FileReader("C:\\eclipse\\springbootlearning3\\TimeSeriesLoader\\DrillOpsMsg.json"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("Json String .." + obj.toString());
		
		System.out.println(obj.toJSONString());

			    
		    String name =  (String) obj.get("EventType");
		    System.out.println("Event is .." + name);
		    
		    
	        try {
				parseJson((JSONObject) obj);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
//        try (Reader reader = new FileReader("C:\\eclipse\\springbootlearning3\\TimeSeriesLoader\\DrillOpsMsg.json")) {
//
//        	 j = new JSONObject();
//        	 
//        	
//			// Convert JSON to Java Object
//        	DrillOperations drillops = gson.fromJson(reader, DrillOperations.class);
//        	System.out.println("Drilling Operations Object is ...");
//            System.out.println(drillops);
//            System.out.println("Event Type is .." + drillops.getEventType());
//
//			// Convert JSON to JsonElement, and later to String
//            /*JsonElement json = gson.fromJson(reader, JsonElement.class);
//           // String jsonInString = gson.toJson(json);
//            //System.out.println(jsonInString);*/
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
    
    
    @SuppressWarnings("unchecked")
	public static void parseJson(JSONObject jsonObject) throws ParseException {

        Set<Object> set = jsonObject.keySet();
        Iterator<Object> iterator = set.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if (jsonObject.get(obj) instanceof JSONArray) {
                System.out.println(obj.toString());
                getArray(jsonObject.get(obj));
            } else {
                if (jsonObject.get(obj) instanceof JSONObject) {
                    parseJson((JSONObject) jsonObject.get(obj));
                } else {
                	if(obj.toString().equalsIgnoreCase("EventType")) {
                		System.out.println("Event Type Found is... " + jsonObject.get(obj));
                	}
                    System.out.println(obj.toString() + "\t"
                            + jsonObject.get(obj));
                }
            }
        }
    }

    
    public static void getArray(Object object2) throws ParseException {

        JSONArray jsonArr = (JSONArray) object2;

        for (int k = 0; k < jsonArr.size(); k++) {

            if (jsonArr.get(k) instanceof JSONObject) {
                parseJson((JSONObject) jsonArr.get(k));
            } else {
                System.out.println(jsonArr.get(k));
            }

        }
    }

}
