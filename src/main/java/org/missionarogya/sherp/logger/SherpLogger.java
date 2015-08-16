package org.missionarogya.sherp.logger;

import org.apache.log4j.Logger;



public class SherpLogger {
	public static void debug(Logger logger,int sessionId,String message){
		String user =  new Integer(sessionId).toString();
		logger.debug(user.concat(" - ").concat(message));
	}
	public static void start(Logger logger,int sessionId,String methodName){
		String user =  new Integer(sessionId).toString();
		logger.debug(user.concat(" - Method : ").concat(methodName).concat(" - Enter"));
	}
	public static void exit(Logger logger,int sessionId,String methodName){
		String user =  new Integer(sessionId).toString();
		logger.debug(user.concat(" - Method : ").concat(methodName).concat(" - Exit"));
	}
}
