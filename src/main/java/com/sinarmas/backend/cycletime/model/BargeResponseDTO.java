package com.sinarmas.backend.cycletime.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: hendraw
 * Description:
 * @Date: 20/07/25
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BargeResponseDTO {
	private String date;
	private String shift;
	private String port;
	private String type;
	private String jetty;
	private String tug;
	private String barge;
	private String loadingActivity;
	private Double totalLoadingHours;
	private Double totalDelayHours;
	private Double netLoadingHours;
	private Double draftSurvey;
	private Double jettyProductivityTph;
	private Double jettyProductionRateTph;
	private Double totalLoading;
	private Double returnCargo;
	private String remark;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getJetty() {
		return jetty;
	}

	public void setJetty(String jetty) {
		this.jetty = jetty;
	}

	public String getTug() {
		return tug;
	}

	public void setTug(String tug) {
		this.tug = tug;
	}

	public String getBarge() {
		return barge;
	}

	public void setBarge(String barge) {
		this.barge = barge;
	}

	public String getLoadingActivity() {
		return loadingActivity;
	}

	public void setLoadingActivity(String loadingActivity) {
		this.loadingActivity = loadingActivity;
	}

	public Double getTotalLoadingHours() {
		return totalLoadingHours;
	}

	public void setTotalLoadingHours(Double totalLoadingHours) {
		this.totalLoadingHours = totalLoadingHours;
	}

	public Double getTotalDelayHours() {
		return totalDelayHours;
	}

	public void setTotalDelayHours(Double totalDelayHours) {
		this.totalDelayHours = totalDelayHours;
	}

	public Double getNetLoadingHours() {
		return netLoadingHours;
	}

	public void setNetLoadingHours(Double netLoadingHours) {
		this.netLoadingHours = netLoadingHours;
	}

	public Double getDraftSurvey() {
		return draftSurvey;
	}

	public void setDraftSurvey(Double draftSurvey) {
		this.draftSurvey = draftSurvey;
	}

	public Double getJettyProductivityTph() {
		return jettyProductivityTph;
	}

	public void setJettyProductivityTph(Double jettyProductivityTph) {
		this.jettyProductivityTph = jettyProductivityTph;
	}

	public Double getJettyProductionRateTph() {
		return jettyProductionRateTph;
	}

	public void setJettyProductionRateTph(Double jettyProductionRateTph) {
		this.jettyProductionRateTph = jettyProductionRateTph;
	}

	public Double getTotalLoading() {
		return totalLoading;
	}

	public void setTotalLoading(Double totalLoading) {
		this.totalLoading = totalLoading;
	}

	public Double getReturnCargo() {
		return returnCargo;
	}

	public void setReturnCargo(Double returnCargo) {
		this.returnCargo = returnCargo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
