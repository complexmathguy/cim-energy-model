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

public class AnalogValueValidator {
		
	/**
	 * default constructor
	 */
	protected AnalogValueValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public AnalogValueValidator getInstance() {
		return new AnalogValueValidator();
	}
		
	/**
	 * handles creation validation for a AnalogValue
	 */
	public void validate( CreateAnalogValueCommand analogValue )throws Exception {
		Assert.notNull( analogValue, "CreateAnalogValueCommand should not be null" );
//		Assert.isNull( analogValue.getAnalogValueId(), "CreateAnalogValueCommand identifier should be null" );
	}

	/**
	 * handles update validation for a AnalogValue
	 */
	public void validate( UpdateAnalogValueCommand analogValue ) throws Exception {
		Assert.notNull( analogValue, "UpdateAnalogValueCommand should not be null" );
		Assert.notNull( analogValue.getAnalogValueId(), "UpdateAnalogValueCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a AnalogValue
	 */
    public void validate( DeleteAnalogValueCommand analogValue ) throws Exception {
		Assert.notNull( analogValue, "{commandAlias} should not be null" );
		Assert.notNull( analogValue.getAnalogValueId(), "DeleteAnalogValueCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a AnalogValue
	 */
	public void validate( AnalogValueFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "AnalogValueFetchOneSummary should not be null" );
		Assert.notNull( summary.getAnalogValueId(), "AnalogValueFetchOneSummary identifier should not be null" );
	}



}
