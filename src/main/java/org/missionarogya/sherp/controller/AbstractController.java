package org.missionarogya.sherp.controller;
import org.missionarogya.sherp.configuration.Hibernate.HibernateConfiguration;
import org.missionarogya.sherp.controller.object.request.CreateProfileRequestType;
import org.missionarogya.sherp.controller.object.response.ResponseType;
import org.missionarogya.sherp.model.service.AuthService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public abstract class AbstractController {
  
	private AbstractApplicationContext context;
	private int auth;

	protected AbstractApplicationContext getContext() {
		context = new AnnotationConfigApplicationContext(
				HibernateConfiguration.class);
		return context;
	}

	protected void closeContext() {
		context.close();
	}

	protected int checkAuthorization(CreateProfileRequestType request,
			String action) throws RuntimeException{
		AuthService authService = (AuthService) getContext().getBean(
				"AuthenticationService");
		 auth = authService.checkAuthorization(request, action);
		 if(auth!=200){
			 throw new RuntimeException();
		 }
		return auth;
	}
	@ExceptionHandler
	public @ResponseBody ResponseEntity<Object> handleException(Exception ex) {
		ResponseType response = new ResponseType();
		System.out.println("hi88");
		
		if(auth ==401){
			response.setMessage("Service Unavailable");
			return new ResponseEntity<Object>(response, HttpStatus.FORBIDDEN);
		}
		else if(auth ==403){
			response.setMessage("Unauthorized Access");
			return new ResponseEntity<Object>(response, HttpStatus.UNAUTHORIZED);
		}
		else if(auth ==404){
			response.setMessage("User Not Found");
			return new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
		}
		else{
			response.setMessage("Invalid Request");
			return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
		}
		
	  }
}
