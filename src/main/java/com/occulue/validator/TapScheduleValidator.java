/*******************************************************************************
  Turnstone Biologics Confidential
  
  2018 Turnstone Biologics
  All Rights Reserved.
  
  This file is subject to the terms and conditions defined in
  file 'license.txt', which is part of this source code package.
   
  Contributors :
        Turnstone Biologics - General Release
 ******************************************************************************/
package com.occulue.validator;

import org.springframework.util.Assert;

import com.occulue.api.*;

public class TapScheduleValidator {
		
	/**
	 * default constructor
	 */
	protected TapScheduleValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public TapScheduleValidator getInstance() {
		return new TapScheduleValidator();
	}
		
	/**
	 * handles creation validation for a TapSchedule
	 */
	public void validate( CreateTapScheduleCommand tapSchedule )throws Exception {
		Assert.notNull( tapSchedule, "CreateTapScheduleCommand should not be null" );
//		Assert.isNull( tapSchedule.getTapScheduleId(), "CreateTapScheduleCommand identifier should be null" );
	}

	/**
	 * handles update validation for a TapSchedule
	 */
	public void validate( UpdateTapScheduleCommand tapSchedule ) throws Exception {
		Assert.notNull( tapSchedule, "UpdateTapScheduleCommand should not be null" );
		Assert.notNull( tapSchedule.getTapScheduleId(), "UpdateTapScheduleCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a TapSchedule
	 */
    public void validate( DeleteTapScheduleCommand tapSchedule ) throws Exception {
		Assert.notNull( tapSchedule, "{commandAlias} should not be null" );
		Assert.notNull( tapSchedule.getTapScheduleId(), "DeleteTapScheduleCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a TapSchedule
	 */
	public void validate( TapScheduleFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "TapScheduleFetchOneSummary should not be null" );
		Assert.notNull( summary.getTapScheduleId(), "TapScheduleFetchOneSummary identifier should not be null" );
	}



}
