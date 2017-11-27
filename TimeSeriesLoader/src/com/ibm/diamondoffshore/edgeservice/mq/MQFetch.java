/**
 * 
 */
package com.ibm.diamondoffshore.edgeservice.mq;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ibm.mq.MQException;
import com.ibm.mq.MQGetMessageOptions;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQQueue;

/**
 * @author sanganas
 *
 */
public class MQFetch {

	private static final Logger logger = Logger.getLogger(MQFetch.class.getName());
	
	private int Queue_Depth;
	
	
	/**
	 * 
	 */
	public MQFetch() {
		// TODO Auto-generated constructor stub
	}
	
	public String getMessage() {
		
		String msgText = null;
		
		MQConnectionManager qManager = new MQConnectionManager();
		MQQueue queue = qManager.getAccessQueue();
		
		
		
		try {
			setQueue_Depth(queue.getCurrentDepth());
			System.out.println("Queue Depth is .." + this.getQueue_Depth());
		} catch (MQException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      //while(queue.getCurrentDepth() > 15) {
	    	  MQMessage rcvMessage = new MQMessage();
	    	  
	    	// Specify default get message options
	          MQGetMessageOptions gmo = new MQGetMessageOptions();
	          
		      // Get the message off the queue.
		      System.out.println("...and getting the message back again");
		      try {
				queue.get(rcvMessage, gmo);
				logger.log(Level.INFO, "Successfully getting the message ..");
			} catch (MQException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		    
			try {
				msgText = rcvMessage.readUTF();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      System.out.println("The message is: " + msgText);
		
		return msgText;
	}

	/**
	 * @return the queue_Depth
	 */
	public int getQueue_Depth() {
		MQConnectionManager qManager = new MQConnectionManager();
		MQQueue queue = qManager.getAccessQueue();
		try {
			Queue_Depth =  queue.getCurrentDepth();
		} catch (MQException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Queue_Depth;
	}

	/**
	 * @param queue_Depth the queue_Depth to set
	 */
	public void setQueue_Depth(int queue_Depth) {
		Queue_Depth = queue_Depth;
	}

}
