package org.missionarogya.sherp.controller;

import org.apache.log4j.Logger;
import org.missionarogya.sherp.controller.object.request.AnswerType;
import org.missionarogya.sherp.controller.object.request.CreateProfileRequestType;
import org.missionarogya.sherp.controller.object.response.CreateProfileResponseType;
import org.missionarogya.sherp.controller.object.response.ResponseType;
import org.missionarogya.sherp.logger.SherpLogger;
import org.missionarogya.sherp.model.service.AppService;
import org.missionarogya.sherp.model.service.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Api(value = "/profile", description = "sherp profile swagger api") // Swagger annotation
@RequestMapping("/profile")
@RestController
public class ProfileController extends AbstractController {
	private static final Logger logger = Logger.getLogger(ProfileController.class);
	private int errorCode= 200;
	@ApiOperation(value = "/admin/create", notes = "Profile Creation", response = CreateProfileResponseType.class)
	@ApiResponses(value = {
  		@ApiResponse(code = 400, message = "Invalid request supplied"),
  		@ApiResponse(code = 403, message = "Authentication Failure") 
	})
    @RequestMapping( value="/admin/create",method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
    public CreateProfileResponseType createProfile (@RequestBody CreateProfileRequestType request) throws RuntimeException{
		String methodName = "createProfile";
		if (logger.isDebugEnabled()) {
			SherpLogger.start(logger,request.getSessionId(),methodName);
		}

		String action = "CreateAdminRO";
		checkAuthorization(request, action);
		ProfileService profileService = (ProfileService) getContext().getBean(
				"ProfileService");
		int memberId = profileService.createProfile(request);
		if(memberId==0){
			errorCode = 405;
			SherpLogger.debug(logger, request.getSessionId(), messageSource.getMessage("userunavailable",null, getLocale()));
			throw new RuntimeException();
		}
		CreateProfileResponseType response = new CreateProfileResponseType();
		response.setTokenValue(memberId);
		if (logger.isDebugEnabled()) {
			SherpLogger.exit(logger,request.getSessionId(),methodName);
		}
		return response;
    }
	@ApiOperation(value = "/answer", notes = "Answer Creation", response = CreateProfileResponseType.class)
	@ApiResponses(value = {
  		@ApiResponse(code = 400, message = "Invalid request supplied"),
  		@ApiResponse(code = 403, message = "Authentication Failure") 
	})
    @RequestMapping( value="/answer",method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
    public void createAnswer (@RequestBody AnswerType request) throws RuntimeException{
		String methodName = "createProfile";
		if (logger.isDebugEnabled()) {
			SherpLogger.start(logger,request.getSessionId(),methodName);
		}
		
		AppService appService = (AppService) getContext().getBean(
				"AppService");
		appService.insertAnswer(request);
		if (logger.isDebugEnabled()) {
			SherpLogger.exit(logger,request.getSessionId(),methodName);
		}
		
    }
	public @ResponseBody ResponseEntity<Object> handleException(Exception ex) {
		ResponseType response = new ResponseType();
		if(errorCode ==405){
			String message = messageSource.getMessage("userunavailable",null, getLocale());
			response.setMessage(message);
			
			return new ResponseEntity<Object>(response, HttpStatus.TOO_MANY_REQUESTS);
		}
		else{
			return super.handleException(ex);
		}
		
	}
}
