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

public class RegularIntervalScheduleValidator {
		
	/**
	 * default constructor
	 */
	protected RegularIntervalScheduleValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public RegularIntervalScheduleValidator getInstance() {
		return new RegularIntervalScheduleValidator();
	}
		
	/**
	 * handles creation validation for a RegularIntervalSchedule
	 */
	public void validate( CreateRegularIntervalScheduleCommand regularIntervalSchedule )throws Exception {
		Assert.notNull( regularIntervalSchedule, "CreateRegularIntervalScheduleCommand should not be null" );
//		Assert.isNull( regularIntervalSchedule.getRegularIntervalScheduleId(), "CreateRegularIntervalScheduleCommand identifier should be null" );
	}

	/**
	 * handles update validation for a RegularIntervalSchedule
	 */
	public void validate( UpdateRegularIntervalScheduleCommand regularIntervalSchedule ) throws Exception {
		Assert.notNull( regularIntervalSchedule, "UpdateRegularIntervalScheduleCommand should not be null" );
		Assert.notNull( regularIntervalSchedule.getRegularIntervalScheduleId(), "UpdateRegularIntervalScheduleCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a RegularIntervalSchedule
	 */
    public void validate( DeleteRegularIntervalScheduleCommand regularIntervalSchedule ) throws Exception {
		Assert.notNull( regularIntervalSchedule, "{commandAlias} should not be null" );
		Assert.notNull( regularIntervalSchedule.getRegularIntervalScheduleId(), "DeleteRegularIntervalScheduleCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a RegularIntervalSchedule
	 */
	public void validate( RegularIntervalScheduleFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "RegularIntervalScheduleFetchOneSummary should not be null" );
		Assert.notNull( summary.getRegularIntervalScheduleId(), "RegularIntervalScheduleFetchOneSummary identifier should not be null" );
	}



}
