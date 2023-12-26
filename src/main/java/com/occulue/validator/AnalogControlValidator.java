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

public class AnalogControlValidator {
		
	/**
	 * default constructor
	 */
	protected AnalogControlValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public AnalogControlValidator getInstance() {
		return new AnalogControlValidator();
	}
		
	/**
	 * handles creation validation for a AnalogControl
	 */
	public void validate( CreateAnalogControlCommand analogControl )throws Exception {
		Assert.notNull( analogControl, "CreateAnalogControlCommand should not be null" );
//		Assert.isNull( analogControl.getAnalogControlId(), "CreateAnalogControlCommand identifier should be null" );
	}

	/**
	 * handles update validation for a AnalogControl
	 */
	public void validate( UpdateAnalogControlCommand analogControl ) throws Exception {
		Assert.notNull( analogControl, "UpdateAnalogControlCommand should not be null" );
		Assert.notNull( analogControl.getAnalogControlId(), "UpdateAnalogControlCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a AnalogControl
	 */
    public void validate( DeleteAnalogControlCommand analogControl ) throws Exception {
		Assert.notNull( analogControl, "{commandAlias} should not be null" );
		Assert.notNull( analogControl.getAnalogControlId(), "DeleteAnalogControlCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a AnalogControl
	 */
	public void validate( AnalogControlFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "AnalogControlFetchOneSummary should not be null" );
		Assert.notNull( summary.getAnalogControlId(), "AnalogControlFetchOneSummary identifier should not be null" );
	}



}
