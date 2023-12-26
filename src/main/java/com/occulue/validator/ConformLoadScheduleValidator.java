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

public class ConformLoadScheduleValidator {
		
	/**
	 * default constructor
	 */
	protected ConformLoadScheduleValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ConformLoadScheduleValidator getInstance() {
		return new ConformLoadScheduleValidator();
	}
		
	/**
	 * handles creation validation for a ConformLoadSchedule
	 */
	public void validate( CreateConformLoadScheduleCommand conformLoadSchedule )throws Exception {
		Assert.notNull( conformLoadSchedule, "CreateConformLoadScheduleCommand should not be null" );
//		Assert.isNull( conformLoadSchedule.getConformLoadScheduleId(), "CreateConformLoadScheduleCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ConformLoadSchedule
	 */
	public void validate( UpdateConformLoadScheduleCommand conformLoadSchedule ) throws Exception {
		Assert.notNull( conformLoadSchedule, "UpdateConformLoadScheduleCommand should not be null" );
		Assert.notNull( conformLoadSchedule.getConformLoadScheduleId(), "UpdateConformLoadScheduleCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ConformLoadSchedule
	 */
    public void validate( DeleteConformLoadScheduleCommand conformLoadSchedule ) throws Exception {
		Assert.notNull( conformLoadSchedule, "{commandAlias} should not be null" );
		Assert.notNull( conformLoadSchedule.getConformLoadScheduleId(), "DeleteConformLoadScheduleCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ConformLoadSchedule
	 */
	public void validate( ConformLoadScheduleFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ConformLoadScheduleFetchOneSummary should not be null" );
		Assert.notNull( summary.getConformLoadScheduleId(), "ConformLoadScheduleFetchOneSummary identifier should not be null" );
	}



}
