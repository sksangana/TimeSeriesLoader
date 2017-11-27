package com.ibm.diamondoffshore.edgeservice.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.diamondoffshore.edgeservice.data.DrillOperations;

public class MessageParser2 {

	public MessageParser2() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            File jsonInputFile = new File("C:\\eclipse\\springbootlearning3\\TimeSeriesLoader\\DrillOpsMsg.json");
            FileInputStream fis = new FileInputStream(jsonInputFile);

    		int oneByte;
    		while ((oneByte = fis.read()) != -1) {
    			System.out.write(oneByte);
    			 //System.out.print((char)oneByte); // could also do this
    		}
    		System.out.flush();
    		System.out.println();
            DrillOperations drillOps = mapper.readValue(jsonInputFile, DrillOperations.class);
            mapper.writeValue(jsonInputFile, drillOps);
            //		mapper.readValue(jsonInputFile, DrillOperations.class);
            System.out.println("The Drill Operations Object...");
            System.out.println(drillOps);
             
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    
	}

}
