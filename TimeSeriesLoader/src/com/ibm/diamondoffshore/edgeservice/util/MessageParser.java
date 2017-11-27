/**
 * 
 */
package com.ibm.diamondoffshore.edgeservice.util;

/**
 * @author sanganas
 *
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

//import com.fasterxml.jackson.core.JsonGenerationException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.ibm.diamondoffshore.edgeservice.TimeSeriesLoader;

public class MessageParser {
	
	private static final Logger logger = Logger.getLogger(MessageParser.class.getName());

	/**
	 * 
	 */
	public MessageParser() {
		// TODO Auto-generated constructor stub
	}

	
	public String getMessageType(String msg) {
		
		String msgType = null;
		
		JSONParser parser = new JSONParser();
        JSONArray jsonarray = null;
        JSONObject 
        obj = null;
        
		try {
			obj = (JSONObject)parser.parse(msg);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			msgType = getEventType(obj);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MyEventException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			msgType = e.getMessage();
		}
		System.out.println("Event Type Parsed is .." + msgType);
		return msgType;
		
	}
	
	@SuppressWarnings("unused")
	private String getEventType(JSONObject jsonObj) throws ParseException, MyEventException {
		String eventType = null;
		
		@SuppressWarnings("unchecked")
		Set<Object> set = jsonObj.keySet();
        Iterator<Object> iterator = set.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if (jsonObj.get(obj) instanceof JSONArray) {
                // Skip
            	} else {
                if (jsonObj.get(obj) instanceof JSONObject) {
                	getEventType((JSONObject) jsonObj.get(obj));
                } else {
                	if(obj.toString().equalsIgnoreCase("EventType")) {
                		System.out.println("Event Type Found is... " + jsonObj.get(obj));
                		eventType = (String) jsonObj.get(obj);
                		throw new MyEventException(eventType);
                	}
                   
                }
            }
        }
		
		return eventType;
	}
	
	public void ParseJSON(String jsonString) {
		
		
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
	
	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		
		
		

        //Write JSON file
//        try (FileWriter file = new FileWriter("employees.json")) {
// 
//            file.write(employeeList.toJSONString());
//            file.flush();
// 
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
	}
	
	class MyEventException extends Exception {
		
		public MyEventException() {
			
		}
		
		public MyEventException(String msg) {
			super(msg);
		}
	}

}
	
