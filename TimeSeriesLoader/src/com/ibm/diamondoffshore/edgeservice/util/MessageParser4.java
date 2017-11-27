package com.ibm.diamondoffshore.edgeservice.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.ibm.diamondoffshore.edgeservice.data.Box;

public class MessageParser4 {

	public MessageParser4() {
		super();
		// TODO Auto-generated constructor stub
	}

public static void main(final String[] args) {

	String str = 
	        "{"
	            + "'title': 'Computing and Information systems',"
	            + "'id' : 1,"
	            + "'children' : 'true',"
	            + "'groups' : [{"
	                + "'title' : 'Level one CIS',"
	                + "'id' : 2,"
	                + "'children' : 'true',"
	                + "'groups' : [{"
	                    + "'title' : 'Intro To Computing and Internet',"
	                    + "'id' : 3,"
	                    + "'children': 'false',"
	                    + "'groups':[]"
	                + "}]" 
	            + "}]"
	        + "}";


	JSONParser parser = new JSONParser();
	JSONObject obj = null;
	try {
		obj = (JSONObject)parser.parse(str);
		//obj = (JSONObject)parser.parse(new FileReader("C:\\eclipse\\springbootlearning3\\TimeSeriesLoader\\DrillOpsMsg.json"));
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	

        Set<Object> set = obj.keySet();
        Iterator<Object> iterator = set.iterator();
        
	    System.out.println("Fields:");
	    while (iterator.hasNext() ){
	       System.out.println(String.format("public String %s;", iterator.next()));
	    }

	    System.out.println("public void Parse (String str){");
	    System.out.println("JSONObject json = new JSONObject(str);");

//	    iterator  = json.keys();
//	    while (iterator.hasNext() ){
//	       String key = iterator.next();
//	       System.out.println(String.format("this.%s = json.getString(\"%s\");",key,key ));
//
//	    System.out.println("}");

}
}