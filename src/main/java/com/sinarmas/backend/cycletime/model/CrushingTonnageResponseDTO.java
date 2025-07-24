package com.sinarmas.backend.cycletime.model;

import lombok.Data;

/**
 * @Author: hendraw
 * Description:
 * @Date: 19/07/25
 */
@Data
public class CrushingTonnageResponseDTO {
	private String crushingPlant;
	private String shift;
	private String date;
	private Double totalActualTon;
	private Double productivity;
	private Double withinCargo;

	public String getCrushingPlant() {
		return crushingPlant;
	}

	public void setCrushingPlant(String crushingPlant) {
		this.crushingPlant = crushingPlant;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getTotalActualTon() {
		return totalActualTon;
	}

	public void setTotalActualTon(Double totalActualTon) {
		this.totalActualTon = totalActualTon;
	}

	public Double getProductivity() {
		return productivity;
	}

	public void setProductivity(Double productivity) {
		this.productivity = productivity;
	}

	public Double getWithinCargo() {
		return withinCargo;
	}

	public void setWithinCargo(Double withinCargo) {
		this.withinCargo = withinCargo;
	}
}
