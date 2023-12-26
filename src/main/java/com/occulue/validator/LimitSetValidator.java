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

public class LimitSetValidator {
		
	/**
	 * default constructor
	 */
	protected LimitSetValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public LimitSetValidator getInstance() {
		return new LimitSetValidator();
	}
		
	/**
	 * handles creation validation for a LimitSet
	 */
	public void validate( CreateLimitSetCommand limitSet )throws Exception {
		Assert.notNull( limitSet, "CreateLimitSetCommand should not be null" );
//		Assert.isNull( limitSet.getLimitSetId(), "CreateLimitSetCommand identifier should be null" );
	}

	/**
	 * handles update validation for a LimitSet
	 */
	public void validate( UpdateLimitSetCommand limitSet ) throws Exception {
		Assert.notNull( limitSet, "UpdateLimitSetCommand should not be null" );
		Assert.notNull( limitSet.getLimitSetId(), "UpdateLimitSetCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a LimitSet
	 */
    public void validate( DeleteLimitSetCommand limitSet ) throws Exception {
		Assert.notNull( limitSet, "{commandAlias} should not be null" );
		Assert.notNull( limitSet.getLimitSetId(), "DeleteLimitSetCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a LimitSet
	 */
	public void validate( LimitSetFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "LimitSetFetchOneSummary should not be null" );
		Assert.notNull( summary.getLimitSetId(), "LimitSetFetchOneSummary identifier should not be null" );
	}



}
