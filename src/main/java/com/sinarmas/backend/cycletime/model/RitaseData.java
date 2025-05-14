package com.sinarmas.backend.cycletime.model;

import jakarta.persistence.*;

/**
 * @Author: hendraw
 * Description:
 * @Date: 09/04/25
 */
@Entity
@Table(name = "ritase_data")
public class RitaseData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String hullCode;
	private String romGeofence;
	private String portGeofence;
	private int deviceId;
	private String taskDate;
	private int ritase;
	private int shift;
	private String romEnterTime;
	private String romExitTime;
	private String wimCreated;
	private String haulingEnterTime;
	private String haulingExitTime;
	private String portEnterTime;
	private String portExitTime;
	private Integer noSk;
	private String payloadTon;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHullCode() {
		return hullCode;
	}

	public void setHullCode(String hullCode) {
		this.hullCode = hullCode;
	}

	public String getRomGeofence() {
		return romGeofence;
	}

	public void setRomGeofence(String romGeofence) {
		this.romGeofence = romGeofence;
	}

	public String getPortGeofence() {
		return portGeofence;
	}

	public void setPortGeofence(String portGeofence) {
		this.portGeofence = portGeofence;
	}

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public String getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(String taskDate) {
		this.taskDate = taskDate;
	}

	public int getRitase() {
		return ritase;
	}

	public void setRitase(int ritase) {
		this.ritase = ritase;
	}

	public int getShift() {
		return shift;
	}

	public void setShift(int shift) {
		this.shift = shift;
	}

	public String getRomEnterTime() {
		return romEnterTime;
	}

	public void setRomEnterTime(String romEnterTime) {
		this.romEnterTime = romEnterTime;
	}

	public String getRomExitTime() {
		return romExitTime;
	}

	public void setRomExitTime(String romExitTime) {
		this.romExitTime = romExitTime;
	}

	public String getWimCreated() {
		return wimCreated;
	}

	public void setWimCreated(String wimCreated) {
		this.wimCreated = wimCreated;
	}

	public String getHaulingEnterTime() {
		return haulingEnterTime;
	}

	public void setHaulingEnterTime(String haulingEnterTime) {
		this.haulingEnterTime = haulingEnterTime;
	}

	public String getHaulingExitTime() {
		return haulingExitTime;
	}

	public void setHaulingExitTime(String haulingExitTime) {
		this.haulingExitTime = haulingExitTime;
	}

	public String getPortEnterTime() {
		return portEnterTime;
	}

	public void setPortEnterTime(String portEnterTime) {
		this.portEnterTime = portEnterTime;
	}

	public String getPortExitTime() {
		return portExitTime;
	}

	public void setPortExitTime(String portExitTime) {
		this.portExitTime = portExitTime;
	}

	public Integer getNoSk() {
		return noSk;
	}

	public void setNoSk(Integer noSk) {
		this.noSk = noSk;
	}

	public String getPayloadTon() {
		return payloadTon;
	}

	public void setPayloadTon(String payloadTon) {
		this.payloadTon = payloadTon;
	}
}
