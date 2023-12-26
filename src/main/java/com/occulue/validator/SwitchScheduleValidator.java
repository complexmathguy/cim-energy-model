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

public class SwitchScheduleValidator {
		
	/**
	 * default constructor
	 */
	protected SwitchScheduleValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public SwitchScheduleValidator getInstance() {
		return new SwitchScheduleValidator();
	}
		
	/**
	 * handles creation validation for a SwitchSchedule
	 */
	public void validate( CreateSwitchScheduleCommand switchSchedule )throws Exception {
		Assert.notNull( switchSchedule, "CreateSwitchScheduleCommand should not be null" );
//		Assert.isNull( switchSchedule.getSwitchScheduleId(), "CreateSwitchScheduleCommand identifier should be null" );
	}

	/**
	 * handles update validation for a SwitchSchedule
	 */
	public void validate( UpdateSwitchScheduleCommand switchSchedule ) throws Exception {
		Assert.notNull( switchSchedule, "UpdateSwitchScheduleCommand should not be null" );
		Assert.notNull( switchSchedule.getSwitchScheduleId(), "UpdateSwitchScheduleCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a SwitchSchedule
	 */
    public void validate( DeleteSwitchScheduleCommand switchSchedule ) throws Exception {
		Assert.notNull( switchSchedule, "{commandAlias} should not be null" );
		Assert.notNull( switchSchedule.getSwitchScheduleId(), "DeleteSwitchScheduleCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a SwitchSchedule
	 */
	public void validate( SwitchScheduleFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "SwitchScheduleFetchOneSummary should not be null" );
		Assert.notNull( summary.getSwitchScheduleId(), "SwitchScheduleFetchOneSummary identifier should not be null" );
	}



}
