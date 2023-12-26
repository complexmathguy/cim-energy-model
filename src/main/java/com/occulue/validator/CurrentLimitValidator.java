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

public class CurrentLimitValidator {
		
	/**
	 * default constructor
	 */
	protected CurrentLimitValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public CurrentLimitValidator getInstance() {
		return new CurrentLimitValidator();
	}
		
	/**
	 * handles creation validation for a CurrentLimit
	 */
	public void validate( CreateCurrentLimitCommand currentLimit )throws Exception {
		Assert.notNull( currentLimit, "CreateCurrentLimitCommand should not be null" );
//		Assert.isNull( currentLimit.getCurrentLimitId(), "CreateCurrentLimitCommand identifier should be null" );
	}

	/**
	 * handles update validation for a CurrentLimit
	 */
	public void validate( UpdateCurrentLimitCommand currentLimit ) throws Exception {
		Assert.notNull( currentLimit, "UpdateCurrentLimitCommand should not be null" );
		Assert.notNull( currentLimit.getCurrentLimitId(), "UpdateCurrentLimitCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a CurrentLimit
	 */
    public void validate( DeleteCurrentLimitCommand currentLimit ) throws Exception {
		Assert.notNull( currentLimit, "{commandAlias} should not be null" );
		Assert.notNull( currentLimit.getCurrentLimitId(), "DeleteCurrentLimitCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a CurrentLimit
	 */
	public void validate( CurrentLimitFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "CurrentLimitFetchOneSummary should not be null" );
		Assert.notNull( summary.getCurrentLimitId(), "CurrentLimitFetchOneSummary identifier should not be null" );
	}



}
