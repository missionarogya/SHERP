package org.missionarogya.sherp.model.service;

import org.missionarogya.sherp.controller.object.request.CreateProfileRequestType;

public interface ProfileService {
	public int createProfile(CreateProfileRequestType request);
	public boolean checkProfileAvailability(String mailId);
	public String getErrorMessage();
}
