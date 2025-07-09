package com.demo.spring.observabilty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micrometer.observation.Observation;
import io.micrometer.observation.Observation.Context;
import io.micrometer.observation.ObservationHandler;

public class MethodCallTrackerHandler implements ObservationHandler<Observation.Context> {

	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean supportsContext(Context context) {
		
		return true;
	}

	@Override
	public void onStart(Context context) {
		logger.info("start of metho {}",context.getName());
		context.put("time", System.currentTimeMillis());
	}
	
	@Override
	public void onStop(Context context) {
		logger.info("stopped executing  {} and total time taken {}",
				context.getName(),System.currentTimeMillis()-context.getOrDefault("time", 0L));
	
	}
	
	@Override
	public void onError(Context context) {
		ObservationHandler.super.onError(context);
	}
	
}
