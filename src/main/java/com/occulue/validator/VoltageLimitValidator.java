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

public class VoltageLimitValidator {
		
	/**
	 * default constructor
	 */
	protected VoltageLimitValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public VoltageLimitValidator getInstance() {
		return new VoltageLimitValidator();
	}
		
	/**
	 * handles creation validation for a VoltageLimit
	 */
	public void validate( CreateVoltageLimitCommand voltageLimit )throws Exception {
		Assert.notNull( voltageLimit, "CreateVoltageLimitCommand should not be null" );
//		Assert.isNull( voltageLimit.getVoltageLimitId(), "CreateVoltageLimitCommand identifier should be null" );
	}

	/**
	 * handles update validation for a VoltageLimit
	 */
	public void validate( UpdateVoltageLimitCommand voltageLimit ) throws Exception {
		Assert.notNull( voltageLimit, "UpdateVoltageLimitCommand should not be null" );
		Assert.notNull( voltageLimit.getVoltageLimitId(), "UpdateVoltageLimitCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a VoltageLimit
	 */
    public void validate( DeleteVoltageLimitCommand voltageLimit ) throws Exception {
		Assert.notNull( voltageLimit, "{commandAlias} should not be null" );
		Assert.notNull( voltageLimit.getVoltageLimitId(), "DeleteVoltageLimitCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a VoltageLimit
	 */
	public void validate( VoltageLimitFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "VoltageLimitFetchOneSummary should not be null" );
		Assert.notNull( summary.getVoltageLimitId(), "VoltageLimitFetchOneSummary identifier should not be null" );
	}



}
