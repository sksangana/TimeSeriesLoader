/**
 * 
 */
package com.ibm.diamondoffshore.edgeservice;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.ibm.diamondoffshore.edgeservice.mq.MQFetch;
import com.ibm.diamondoffshore.edgeservice.util.MessageParser;

/**
 * @author sanganas
 *
 */
public class TimeSeriesLoader {

	private static final Logger logger = Logger.getLogger(TimeSeriesLoader.class.getName());

	private static List<JSONObject> DrillOpsList  = new ArrayList<JSONObject>();

	private static List<JSONObject> RimmDrillList = new ArrayList<JSONObject>();;

	private static List<JSONObject> SysMonList = new ArrayList<JSONObject>();;

	/**
	 * @return the drillOpsList
	 */

	/**
	 * 
	 */
	public TimeSeriesLoader() {
		// TODO Auto-generated constructor stub
	}

	public static void addToDrillOpsList(JSONObject obj) {

		DrillOpsList.add(obj);
	}

	public static void addToRimmDrillList(JSONObject obj) {

		RimmDrillList.add(obj);
	}

	public static void addToSysMonList(JSONObject obj) {

		SysMonList.add(obj);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MQFetch mqReader = new MQFetch();

		int queueDepth = mqReader.getQueue_Depth();

		while (queueDepth > 1) {
			
			queueDepth = mqReader.getQueue_Depth();

			String msgText = mqReader.getMessage();

			logger.log(Level.INFO, "Message Fetched is .." + msgText);

			JSONParser parser = new JSONParser();

			JSONObject obj = null;
			try {
				obj = (JSONObject) parser.parse(msgText);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			MessageParser msgParser = new MessageParser();
			String eventType = msgParser.getMessageType(msgText);
			System.out.println("Event Type is ..." + eventType);
			if (eventType.equalsIgnoreCase("DrillOps")) {
				addToDrillOpsList(obj);
			}
			if (eventType.equalsIgnoreCase("RimDrill")) {
				addToRimmDrillList(obj);
			}
			if (eventType.equalsIgnoreCase("MQ")) {
				addToSysMonList(obj);
			}

		}
		System.out.println("The Total Objects in Drill Ops List are ... " + DrillOpsList.size());
		System.out.println("The Total Objects in RimmDrill List are ... " + RimmDrillList.size());
		System.out.println("The Total Objects in SysMon List are ... " + SysMonList.size());

	}
}
