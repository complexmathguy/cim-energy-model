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

public class NonConformLoadScheduleValidator {
		
	/**
	 * default constructor
	 */
	protected NonConformLoadScheduleValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public NonConformLoadScheduleValidator getInstance() {
		return new NonConformLoadScheduleValidator();
	}
		
	/**
	 * handles creation validation for a NonConformLoadSchedule
	 */
	public void validate( CreateNonConformLoadScheduleCommand nonConformLoadSchedule )throws Exception {
		Assert.notNull( nonConformLoadSchedule, "CreateNonConformLoadScheduleCommand should not be null" );
//		Assert.isNull( nonConformLoadSchedule.getNonConformLoadScheduleId(), "CreateNonConformLoadScheduleCommand identifier should be null" );
	}

	/**
	 * handles update validation for a NonConformLoadSchedule
	 */
	public void validate( UpdateNonConformLoadScheduleCommand nonConformLoadSchedule ) throws Exception {
		Assert.notNull( nonConformLoadSchedule, "UpdateNonConformLoadScheduleCommand should not be null" );
		Assert.notNull( nonConformLoadSchedule.getNonConformLoadScheduleId(), "UpdateNonConformLoadScheduleCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a NonConformLoadSchedule
	 */
    public void validate( DeleteNonConformLoadScheduleCommand nonConformLoadSchedule ) throws Exception {
		Assert.notNull( nonConformLoadSchedule, "{commandAlias} should not be null" );
		Assert.notNull( nonConformLoadSchedule.getNonConformLoadScheduleId(), "DeleteNonConformLoadScheduleCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a NonConformLoadSchedule
	 */
	public void validate( NonConformLoadScheduleFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "NonConformLoadScheduleFetchOneSummary should not be null" );
		Assert.notNull( summary.getNonConformLoadScheduleId(), "NonConformLoadScheduleFetchOneSummary identifier should not be null" );
	}



}
