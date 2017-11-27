
package com.ibm.diamondoffshore.edgeservice.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//import org.apache.commons.lang.builder.ToStringBuilder;

public class DrillOperations {

	@SerializedName("EventType")
	@Expose
	private String eventType;
	@SerializedName("Timestamp")
	@Expose
	private String timestamp;
	@SerializedName("MP1Speed")
	@Expose
	private int mP1Speed;
	@SerializedName("MP2Speed")
	@Expose
	private int mP2Speed;
	@SerializedName("MP3Speed")
	@Expose
	private int mP3Speed;
	@SerializedName("MP4Speed")
	@Expose
	private int mP4Speed;
	@SerializedName("MP5Speed")
	@Expose
	private int mP5Speed;
	@SerializedName("STP1")
	@Expose
	private int sTP1;
	@SerializedName("BoostPress")
	@Expose
	private int boostPress;
	@SerializedName("TDSpeed")
	@Expose
	private int tDSpeed;
	@SerializedName("TDTorque")
	@Expose
	private int tDTorque;
	@SerializedName("MudFlowReturn")
	@Expose
	private int mudFlowReturn;
	@SerializedName("MP1Press")
	@Expose
	private int mP1Press;
	@SerializedName("MP2Press")
	@Expose
	private int mP2Press;
	@SerializedName("MP3Press")
	@Expose
	private int mP3Press;
	@SerializedName("MP4Press")
	@Expose
	private int mP4Press;
	@SerializedName("MP5Pressure")
	@Expose
	private int mP5Pressure;
	@SerializedName("ElevatorPos")
	@Expose
	private int elevatorPos;
	@SerializedName("HookSpeed")
	@Expose
	private double hookSpeed;
	@SerializedName("BitDepth")
	@Expose
	private int bitDepth;
	@SerializedName("TotalDepth")
	@Expose
	private int totalDepth;
	@SerializedName("HookLoad")
	@Expose
	private int hookLoad;
	@SerializedName("WOB")
	@Expose
	private int wOB;

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public int getMP1Speed() {
		return mP1Speed;
	}

	public void setMP1Speed(int mP1Speed) {
		this.mP1Speed = mP1Speed;
	}

	public int getMP2Speed() {
		return mP2Speed;
	}

	public void setMP2Speed(int mP2Speed) {
		this.mP2Speed = mP2Speed;
	}

	public int getMP3Speed() {
		return mP3Speed;
	}

	public void setMP3Speed(int mP3Speed) {
		this.mP3Speed = mP3Speed;
	}

	public int getMP4Speed() {
		return mP4Speed;
	}

	public void setMP4Speed(int mP4Speed) {
		this.mP4Speed = mP4Speed;
	}

	public int getMP5Speed() {
		return mP5Speed;
	}

	public void setMP5Speed(int mP5Speed) {
		this.mP5Speed = mP5Speed;
	}

	public int getSTP1() {
		return sTP1;
	}

	public void setSTP1(int sTP1) {
		this.sTP1 = sTP1;
	}

	public int getBoostPress() {
		return boostPress;
	}

	public void setBoostPress(int boostPress) {
		this.boostPress = boostPress;
	}

	public int getTDSpeed() {
		return tDSpeed;
	}

	public void setTDSpeed(int tDSpeed) {
		this.tDSpeed = tDSpeed;
	}

	public int getTDTorque() {
		return tDTorque;
	}

	public void setTDTorque(int tDTorque) {
		this.tDTorque = tDTorque;
	}

	public int getMudFlowReturn() {
		return mudFlowReturn;
	}

	public void setMudFlowReturn(int mudFlowReturn) {
		this.mudFlowReturn = mudFlowReturn;
	}

	public int getMP1Press() {
		return mP1Press;
	}

	public void setMP1Press(int mP1Press) {
		this.mP1Press = mP1Press;
	}

	public int getMP2Press() {
		return mP2Press;
	}

	public void setMP2Press(int mP2Press) {
		this.mP2Press = mP2Press;
	}

	public int getMP3Press() {
		return mP3Press;
	}

	public void setMP3Press(int mP3Press) {
		this.mP3Press = mP3Press;
	}

	public int getMP4Press() {
		return mP4Press;
	}

	public void setMP4Press(int mP4Press) {
		this.mP4Press = mP4Press;
	}

	public int getMP5Pressure() {
		return mP5Pressure;
	}

	public void setMP5Pressure(int mP5Pressure) {
		this.mP5Pressure = mP5Pressure;
	}

	public int getElevatorPos() {
		return elevatorPos;
	}

	public void setElevatorPos(int elevatorPos) {
		this.elevatorPos = elevatorPos;
	}

	public double getHookSpeed() {
		return hookSpeed;
	}

	public void setHookSpeed(double hookSpeed) {
		this.hookSpeed = hookSpeed;
	}

	public int getBitDepth() {
		return bitDepth;
	}

	public void setBitDepth(int bitDepth) {
		this.bitDepth = bitDepth;
	}

	public int getTotalDepth() {
		return totalDepth;
	}

	public void setTotalDepth(int totalDepth) {
		this.totalDepth = totalDepth;
	}

	public int getHookLoad() {
		return hookLoad;
	}

	public void setHookLoad(int hookLoad) {
		this.hookLoad = hookLoad;
	}

	public int getWOB() {
		return wOB;
	}

	public void setWOB(int wOB) {
		this.wOB = wOB;
	}

//	@Override
//	public String toString() {
//		return (String) new ToStringSerializer().append("eventType", eventType).append("timestamp", timestamp)
//				.append("mP1Speed", mP1Speed).append("mP2Speed", mP2Speed).append("mP3Speed", mP3Speed)
//				.append("mP4Speed", mP4Speed).append("mP5Speed", mP5Speed).append("sTP1", sTP1)
//				.append("boostPress", boostPress).append("tDSpeed", tDSpeed).append("tDTorque", tDTorque)
//				.append("mudFlowReturn", mudFlowReturn).append("mP1Press", mP1Press).append("mP2Press", mP2Press)
//				.append("mP3Press", mP3Press).append("mP4Press", mP4Press).append("mP5Pressure", mP5Pressure)
//				.append("elevatorPos", elevatorPos).append("hookSpeed", hookSpeed).append("bitDepth", bitDepth)
//				.append("totalDepth", totalDepth).append("hookLoad", hookLoad).append("wOB", wOB).toString();
//	}

}