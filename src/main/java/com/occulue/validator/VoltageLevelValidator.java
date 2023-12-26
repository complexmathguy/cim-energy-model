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

public class VoltageLevelValidator {
		
	/**
	 * default constructor
	 */
	protected VoltageLevelValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public VoltageLevelValidator getInstance() {
		return new VoltageLevelValidator();
	}
		
	/**
	 * handles creation validation for a VoltageLevel
	 */
	public void validate( CreateVoltageLevelCommand voltageLevel )throws Exception {
		Assert.notNull( voltageLevel, "CreateVoltageLevelCommand should not be null" );
//		Assert.isNull( voltageLevel.getVoltageLevelId(), "CreateVoltageLevelCommand identifier should be null" );
	}

	/**
	 * handles update validation for a VoltageLevel
	 */
	public void validate( UpdateVoltageLevelCommand voltageLevel ) throws Exception {
		Assert.notNull( voltageLevel, "UpdateVoltageLevelCommand should not be null" );
		Assert.notNull( voltageLevel.getVoltageLevelId(), "UpdateVoltageLevelCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a VoltageLevel
	 */
    public void validate( DeleteVoltageLevelCommand voltageLevel ) throws Exception {
		Assert.notNull( voltageLevel, "{commandAlias} should not be null" );
		Assert.notNull( voltageLevel.getVoltageLevelId(), "DeleteVoltageLevelCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a VoltageLevel
	 */
	public void validate( VoltageLevelFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "VoltageLevelFetchOneSummary should not be null" );
		Assert.notNull( summary.getVoltageLevelId(), "VoltageLevelFetchOneSummary identifier should not be null" );
	}



}
