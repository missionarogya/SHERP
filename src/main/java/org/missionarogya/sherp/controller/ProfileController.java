package org.missionarogya.sherp.controller;

import org.missionarogya.sherp.controller.object.request.CreateProfileRequestType;
import org.missionarogya.sherp.controller.object.response.CreateProfileResponseType;
import org.missionarogya.sherp.controller.object.response.ResponseType;
import org.missionarogya.sherp.model.service.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
	private int errorCode= 200;
	@ApiOperation(value = "/admin/create", notes = "Profile Creation", response = CreateProfileResponseType.class)
	@ApiResponses(value = {
  		@ApiResponse(code = 400, message = "Invalid request supplied"),
  		@ApiResponse(code = 403, message = "Authentication Failure") 
	})
    @RequestMapping( value="/admin/create",method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	
    public CreateProfileResponseType createProfile (@RequestBody CreateProfileRequestType request) throws RuntimeException{
		String action = "CreateAdminRO";
		checkAuthorization(request, action);
		System.out.println("hi9");
		
		ProfileService profileService = (ProfileService) getContext().getBean(
				"ProfileService");
		int memberId = profileService.createProfile(request);
		if(memberId==0){
			errorCode = 405;
			throw new RuntimeException();
		}
		CreateProfileResponseType response = new CreateProfileResponseType();
		response.setTokenValue(memberId);
		return response;
    }
	
	public @ResponseBody ResponseEntity<Object> handleException(Exception ex) {
		
		ResponseType response = new ResponseType();
		if(errorCode ==405){
			response.setMessage("User is already available");
			return new ResponseEntity<Object>(response, HttpStatus.TOO_MANY_REQUESTS);
		}
		else{
			return super.handleException(ex);
		}
		
	}
}
