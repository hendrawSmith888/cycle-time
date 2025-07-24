package com.sinarmas.backend.cycletime.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: hendraw
 * Description:
 * @Date: 20/07/25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BargeRequestDTO {
	private String startDate;
	private String endDate;

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
