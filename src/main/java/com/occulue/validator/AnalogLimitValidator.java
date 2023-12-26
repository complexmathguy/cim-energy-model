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

public class AnalogLimitValidator {
		
	/**
	 * default constructor
	 */
	protected AnalogLimitValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public AnalogLimitValidator getInstance() {
		return new AnalogLimitValidator();
	}
		
	/**
	 * handles creation validation for a AnalogLimit
	 */
	public void validate( CreateAnalogLimitCommand analogLimit )throws Exception {
		Assert.notNull( analogLimit, "CreateAnalogLimitCommand should not be null" );
//		Assert.isNull( analogLimit.getAnalogLimitId(), "CreateAnalogLimitCommand identifier should be null" );
	}

	/**
	 * handles update validation for a AnalogLimit
	 */
	public void validate( UpdateAnalogLimitCommand analogLimit ) throws Exception {
		Assert.notNull( analogLimit, "UpdateAnalogLimitCommand should not be null" );
		Assert.notNull( analogLimit.getAnalogLimitId(), "UpdateAnalogLimitCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a AnalogLimit
	 */
    public void validate( DeleteAnalogLimitCommand analogLimit ) throws Exception {
		Assert.notNull( analogLimit, "{commandAlias} should not be null" );
		Assert.notNull( analogLimit.getAnalogLimitId(), "DeleteAnalogLimitCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a AnalogLimit
	 */
	public void validate( AnalogLimitFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "AnalogLimitFetchOneSummary should not be null" );
		Assert.notNull( summary.getAnalogLimitId(), "AnalogLimitFetchOneSummary identifier should not be null" );
	}



}
