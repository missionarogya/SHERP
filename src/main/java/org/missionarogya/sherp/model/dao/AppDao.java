package org.missionarogya.sherp.model.dao;

import org.missionarogya.sherp.model.dao.object.InterviewAnswers;
import org.missionarogya.sherp.model.dao.object.InterviewDetails;

public interface AppDao {
	public void saveAnswer(InterviewAnswers answer);
	public void saveInterview(InterviewDetails interview);
}
