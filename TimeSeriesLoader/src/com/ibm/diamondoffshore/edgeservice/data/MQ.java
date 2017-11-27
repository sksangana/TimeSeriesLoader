package com.ibm.diamondoffshore.edgeservice.data;

public class MQ {

	private String queueDepth;
	private String deadletterDepth;
	private String listenerProcess;
	private String qMgrStatus;

	public String getQueueDepth() {
		return queueDepth;
	}

	public void setQueueDepth(String queueDepth) {
		this.queueDepth = queueDepth;
	}

	public String getDeadletterDepth() {
		return deadletterDepth;
	}

	public void setDeadletterDepth(String deadletterDepth) {
		this.deadletterDepth = deadletterDepth;
	}

	public String getListenerProcess() {
		return listenerProcess;
	}

	public void setListenerProcess(String listenerProcess) {
		this.listenerProcess = listenerProcess;
	}

	public String getQMgrStatus() {
		return qMgrStatus;
	}

	public void setQMgrStatus(String qMgrStatus) {
		this.qMgrStatus = qMgrStatus;
	}

}
