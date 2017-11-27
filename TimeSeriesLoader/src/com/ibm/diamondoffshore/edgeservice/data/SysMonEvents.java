package com.ibm.diamondoffshore.edgeservice.data;

public class SysMonEvents {

	private String eventType;
	private OpSys opSys;
	private MQ mQ;
	private IIB iIB;
	private INFORMIX iNFORMIX;

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public OpSys getOpSys() {
		return opSys;
	}

	public void setOpSys(OpSys opSys) {
		this.opSys = opSys;
	}

	public MQ getMQ() {
		return mQ;
	}

	public void setMQ(MQ mQ) {
		this.mQ = mQ;
	}

	public IIB getIIB() {
		return iIB;
	}

	public void setIIB(IIB iIB) {
		this.iIB = iIB;
	}

	public INFORMIX getINFORMIX() {
		return iNFORMIX;
	}

	public void setINFORMIX(INFORMIX iNFORMIX) {
		this.iNFORMIX = iNFORMIX;
	}

}
