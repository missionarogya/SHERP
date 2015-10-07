package org.missionarogya.sherp.model.dao.object;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
@Entity
@Table(name="tbl_InterviewAnswers")

public class InterviewAnswers implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3791553219063460048L;
	@Id
	@Column(name = "interviewId", nullable = false)
	int interviewId;
	
	@Column(name = "questionId", nullable = false)
	String questionId;
	@Column(name = "answer", nullable = false)
	String answer;
	
	public int getInterviewId() {
		return interviewId;
	}
	public void setInterviewId(int interviewId) {
		this.interviewId = interviewId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	
	
}
