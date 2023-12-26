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

public class SeasonDayTypeScheduleValidator {
		
	/**
	 * default constructor
	 */
	protected SeasonDayTypeScheduleValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public SeasonDayTypeScheduleValidator getInstance() {
		return new SeasonDayTypeScheduleValidator();
	}
		
	/**
	 * handles creation validation for a SeasonDayTypeSchedule
	 */
	public void validate( CreateSeasonDayTypeScheduleCommand seasonDayTypeSchedule )throws Exception {
		Assert.notNull( seasonDayTypeSchedule, "CreateSeasonDayTypeScheduleCommand should not be null" );
//		Assert.isNull( seasonDayTypeSchedule.getSeasonDayTypeScheduleId(), "CreateSeasonDayTypeScheduleCommand identifier should be null" );
	}

	/**
	 * handles update validation for a SeasonDayTypeSchedule
	 */
	public void validate( UpdateSeasonDayTypeScheduleCommand seasonDayTypeSchedule ) throws Exception {
		Assert.notNull( seasonDayTypeSchedule, "UpdateSeasonDayTypeScheduleCommand should not be null" );
		Assert.notNull( seasonDayTypeSchedule.getSeasonDayTypeScheduleId(), "UpdateSeasonDayTypeScheduleCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a SeasonDayTypeSchedule
	 */
    public void validate( DeleteSeasonDayTypeScheduleCommand seasonDayTypeSchedule ) throws Exception {
		Assert.notNull( seasonDayTypeSchedule, "{commandAlias} should not be null" );
		Assert.notNull( seasonDayTypeSchedule.getSeasonDayTypeScheduleId(), "DeleteSeasonDayTypeScheduleCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a SeasonDayTypeSchedule
	 */
	public void validate( SeasonDayTypeScheduleFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "SeasonDayTypeScheduleFetchOneSummary should not be null" );
		Assert.notNull( summary.getSeasonDayTypeScheduleId(), "SeasonDayTypeScheduleFetchOneSummary identifier should not be null" );
	}



}
