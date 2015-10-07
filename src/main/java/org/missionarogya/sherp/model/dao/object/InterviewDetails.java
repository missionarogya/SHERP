package org.missionarogya.sherp.model.dao.object;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_InterviewDetails")
public class InterviewDetails {
	@Id
	@Column(name = "interviewId", nullable = false)
	int interviewId;
	@Column(name = "interviewerId", nullable = false)
	String interviewerId;
	@Column(name = "intervieweeId", nullable = false)
	String intervieweeId;
	@Column(name = "venue", nullable = false)
	String venue;
	@Column(name = "latitude", nullable = false)
	double latitude;
	@Column(name = "longitude", nullable = false)
	double longitude;
	
	
	
	public int getInterviewId() {
		return interviewId;
	}
	public void setInterviewId(int interviewId) {
		this.interviewId = interviewId;
	}
	public String getInterviewerId() {
		return interviewerId;
	}
	public void setInterviewerId(String interviewerId) {
		this.interviewerId = interviewerId;
	}
	public String getIntervieweeId() {
		return intervieweeId;
	}
	public void setIntervieweeId(String intervieweeId) {
		this.intervieweeId = intervieweeId;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
}
