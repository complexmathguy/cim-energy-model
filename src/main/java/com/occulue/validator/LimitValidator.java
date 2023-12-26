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

public class LimitValidator {
		
	/**
	 * default constructor
	 */
	protected LimitValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public LimitValidator getInstance() {
		return new LimitValidator();
	}
		
	/**
	 * handles creation validation for a Limit
	 */
	public void validate( CreateLimitCommand limit )throws Exception {
		Assert.notNull( limit, "CreateLimitCommand should not be null" );
//		Assert.isNull( limit.getLimitId(), "CreateLimitCommand identifier should be null" );
	}

	/**
	 * handles update validation for a Limit
	 */
	public void validate( UpdateLimitCommand limit ) throws Exception {
		Assert.notNull( limit, "UpdateLimitCommand should not be null" );
		Assert.notNull( limit.getLimitId(), "UpdateLimitCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a Limit
	 */
    public void validate( DeleteLimitCommand limit ) throws Exception {
		Assert.notNull( limit, "{commandAlias} should not be null" );
		Assert.notNull( limit.getLimitId(), "DeleteLimitCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a Limit
	 */
	public void validate( LimitFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "LimitFetchOneSummary should not be null" );
		Assert.notNull( summary.getLimitId(), "LimitFetchOneSummary identifier should not be null" );
	}



}
