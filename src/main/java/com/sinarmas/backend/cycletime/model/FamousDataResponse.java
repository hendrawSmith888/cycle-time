package com.sinarmas.backend.cycletime.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: hendraw
 * Description:
 * @Date: 09/04/25
 */
public class FamousDataResponse {
		private String message;
		private List<RitaseData> data;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<RitaseData> getData() {
		return data;
	}

	public void setData(List<RitaseData> data) {
		this.data = data;
	}

	public static class RitaseData {
		@JsonProperty("hull_code")
		private String hullCode;

		@JsonProperty("rom_geofence")
		private String romGeofence;

		@JsonProperty("port_geofence")
		private String portGeofence;

		@JsonProperty("device_id")
		private int deviceId;

		@JsonProperty("task_date")
		private String taskDate;

		private int ritase;
		private int shift;

		@JsonProperty("rom_enter_time")
		private String romEnterTime;

		@JsonProperty("rom_exit_time")
		private String romExitTime;

		@JsonProperty("wim_created")
		private String wimCreated;

		@JsonProperty("hauling_enter_time")
		private String haulingEnterTime;

		@JsonProperty("hauling_exit_time")
		private String haulingExitTime;

		@JsonProperty("port_enter_time")
		private String portEnterTime;

		@JsonProperty("port_exit_time")
		private String portExitTime;

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
	}
}
