package com.revature.logs;

import org.apache.log4j.Logger;

public class LogHere {

	private static LogHere instance;
	private static Logger logger = Logger.getLogger(LogHere.class);

	
	private LogHere() {
		 logger = Logger.getLogger(LogHere.class);
	}
	
	public static LogHere getInstance() {
		if(instance == null) {
			instance = new LogHere();
		}
		return instance;
	}
	
	public static void info(Object msg) {
		logger.info(msg);
	}
	
	public static void warn(Object object) {
		logger.warn(object);
	}

	public static void warn(String msg, Exception e) {
		logger.warn(msg, e);
	}
	
}
