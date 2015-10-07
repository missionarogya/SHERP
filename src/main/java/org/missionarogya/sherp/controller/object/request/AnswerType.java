package org.missionarogya.sherp.controller.object.request;

import java.util.List;

public class AnswerType extends RequestType {
	String qaset_id;
	String interviewer_id;
	String interviewee_id;
	Location interview_dttm;
	String venue;
	List<Answer> answer;
	public String getQaset_id() {
		return qaset_id;
	}
	public void setQaset_id(String qaset_id) {
		this.qaset_id = qaset_id;
	}
	public String getInterviewer_id() {
		return interviewer_id;
	}
	public void setInterviewer_id(String interviewer_id) {
		this.interviewer_id = interviewer_id;
	}
	public String getInterviewee_id() {
		return interviewee_id;
	}
	public void setInterviewee_id(String interviewee_id) {
		this.interviewee_id = interviewee_id;
	}
	public Location getInterview_dttm() {
		return interview_dttm;
	}
	public void setInterview_dttm(Location interview_dttm) {
		this.interview_dttm = interview_dttm;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public List<Answer> getAnswer() {
		return answer;
	}
	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}
	
}
