package com.sinarmas.backend.cycletime.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: hendraw
 * Description:
 * @Date: 09/04/25
 */
public class FamousDataRequest {
		private List<String> hullCode;
		private String startDate;
		private String endDate;

	public List<String> getHullCode() {
		return hullCode;
	}

	public void setHullCode(List<String> hullCode) {
		this.hullCode = hullCode;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
