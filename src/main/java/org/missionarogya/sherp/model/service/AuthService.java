package org.missionarogya.sherp.model.service;

import org.missionarogya.sherp.controller.object.request.RequestType;

public interface AuthService {
	public int checkAuthorization(RequestType request,String action);
}
