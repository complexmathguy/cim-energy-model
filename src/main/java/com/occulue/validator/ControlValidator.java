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

public class ControlValidator {
		
	/**
	 * default constructor
	 */
	protected ControlValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ControlValidator getInstance() {
		return new ControlValidator();
	}
		
	/**
	 * handles creation validation for a Control
	 */
	public void validate( CreateControlCommand control )throws Exception {
		Assert.notNull( control, "CreateControlCommand should not be null" );
//		Assert.isNull( control.getControlId(), "CreateControlCommand identifier should be null" );
	}

	/**
	 * handles update validation for a Control
	 */
	public void validate( UpdateControlCommand control ) throws Exception {
		Assert.notNull( control, "UpdateControlCommand should not be null" );
		Assert.notNull( control.getControlId(), "UpdateControlCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a Control
	 */
    public void validate( DeleteControlCommand control ) throws Exception {
		Assert.notNull( control, "{commandAlias} should not be null" );
		Assert.notNull( control.getControlId(), "DeleteControlCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a Control
	 */
	public void validate( ControlFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ControlFetchOneSummary should not be null" );
		Assert.notNull( summary.getControlId(), "ControlFetchOneSummary identifier should not be null" );
	}



}
