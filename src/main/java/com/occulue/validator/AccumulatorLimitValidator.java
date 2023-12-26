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

public class AccumulatorLimitValidator {
		
	/**
	 * default constructor
	 */
	protected AccumulatorLimitValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public AccumulatorLimitValidator getInstance() {
		return new AccumulatorLimitValidator();
	}
		
	/**
	 * handles creation validation for a AccumulatorLimit
	 */
	public void validate( CreateAccumulatorLimitCommand accumulatorLimit )throws Exception {
		Assert.notNull( accumulatorLimit, "CreateAccumulatorLimitCommand should not be null" );
//		Assert.isNull( accumulatorLimit.getAccumulatorLimitId(), "CreateAccumulatorLimitCommand identifier should be null" );
	}

	/**
	 * handles update validation for a AccumulatorLimit
	 */
	public void validate( UpdateAccumulatorLimitCommand accumulatorLimit ) throws Exception {
		Assert.notNull( accumulatorLimit, "UpdateAccumulatorLimitCommand should not be null" );
		Assert.notNull( accumulatorLimit.getAccumulatorLimitId(), "UpdateAccumulatorLimitCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a AccumulatorLimit
	 */
    public void validate( DeleteAccumulatorLimitCommand accumulatorLimit ) throws Exception {
		Assert.notNull( accumulatorLimit, "{commandAlias} should not be null" );
		Assert.notNull( accumulatorLimit.getAccumulatorLimitId(), "DeleteAccumulatorLimitCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a AccumulatorLimit
	 */
	public void validate( AccumulatorLimitFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "AccumulatorLimitFetchOneSummary should not be null" );
		Assert.notNull( summary.getAccumulatorLimitId(), "AccumulatorLimitFetchOneSummary identifier should not be null" );
	}



}
