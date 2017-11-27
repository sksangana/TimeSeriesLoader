/**
 * 
 */
package com.ibm.diamondoffshore.edgeservice.mq;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.ibm.diamondoffshore.edgeservice.util.*;
import com.ibm.mq.MQException;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;
import com.ibm.mq.constants.MQConstants;

/**
 * @author sanganas
 *
 */
public class MQConnectionManager {

	private static final Logger logger = Logger.getLogger(MQConnectionManager.class.getName());
	
	private String QueueManagerName;
	
	private String QueueName;
	
	private String QueueOpenOptions;
	
	private MQQueue AccessQueue;
	/**
	 * 
	 */
	public MQConnectionManager() {
		// TODO Auto-generated constructor stub
		
		try {
			PropertiesManager propManager = PropertiesManager.getPropertiesManager();
			
			this.setQueueManagerName( propManager.getMQ_QUEUE_MANAGER());
			this.setQueueName(propManager.getMQ_QUEUE_NAME());
			this.setQueueOpenOptions(propManager.getMQ_OPEN_OPTIONS());
			
			logger.log(Level.INFO, "Successfully got the MQ connection attributes ...");
			
			this.OpenAccessQueue();
			
			logger.log(Level.INFO, "Successfully Opened th Queue for Access ..");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.log(Level.SEVERE, "Cannot get connection", e);
		}
	}

	/**
	 * @return the queueManager
	 */
	public String getQueueManagerName() {
		return QueueManagerName;
	}

	/**
	 * @param queueManager the queueManager to set
	 */
	public void setQueueManagerName(String queueManager) {
		QueueManagerName = queueManager;
	}

	/**
	 * @return the queueName
	 */
	public String getQueueName() {
		return QueueName;
	}

	/**
	 * @param queueName the queueName to set
	 */
	public void setQueueName(String queueName) {
		QueueName = queueName;
	}

	/**
	 * @return the queueOpenOptions
	 */
	public String getQueueOpenOptions() {
		return QueueOpenOptions;
	}

	/**
	 * @param queueOpenOptions the queueOpenOptions to set
	 */
	public void setQueueOpenOptions(String queueOpenOptions) {
		QueueOpenOptions = queueOpenOptions;
	}
	
	@SuppressWarnings("unused")
	private void OpenAccessQueue() {
		
		MQQueueManager qMgr = null;
		MQQueue queue = null;
	      // Create a connection to the QueueManager
	      System.out.println("Connecting to queue manager: " + this.getQueueManagerName());
	      try {
			qMgr = new MQQueueManager(this.getQueueManagerName());
		} catch (MQException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	   // Now specify the queue that we wish to open and the open options
	      System.out.println("Accessing queue: " + this.getQueueName());
	      System.out.println("MQ Open Options is ... " + this.getQueueOpenOptions());
	      //int options = Integer.par  //Integer.getInteger(getQueueOpenOptions());
	      int qOpenOptions = MQConstants.MQOO_INPUT_AS_Q_DEF | MQConstants.MQOO_OUTPUT | MQConstants.MQOO_INQUIRE;
	      //int QOpenOptions = Integer.parseInt();
	      try {
			queue = qMgr.accessQueue(this.getQueueName(), qOpenOptions);
		} catch (MQException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     this.setAccessQueue(queue); 
	}

	/**
	 * @return the accessQueue
	 */
	public MQQueue getAccessQueue() {
		

		return AccessQueue;
	}

	/**
	 * @param accessQueue the accessQueue to set
	 */
	public void setAccessQueue(MQQueue accessQueue) {
		AccessQueue = accessQueue;
	}

}
