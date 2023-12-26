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

public class AccumulatorValueValidator {
		
	/**
	 * default constructor
	 */
	protected AccumulatorValueValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public AccumulatorValueValidator getInstance() {
		return new AccumulatorValueValidator();
	}
		
	/**
	 * handles creation validation for a AccumulatorValue
	 */
	public void validate( CreateAccumulatorValueCommand accumulatorValue )throws Exception {
		Assert.notNull( accumulatorValue, "CreateAccumulatorValueCommand should not be null" );
//		Assert.isNull( accumulatorValue.getAccumulatorValueId(), "CreateAccumulatorValueCommand identifier should be null" );
	}

	/**
	 * handles update validation for a AccumulatorValue
	 */
	public void validate( UpdateAccumulatorValueCommand accumulatorValue ) throws Exception {
		Assert.notNull( accumulatorValue, "UpdateAccumulatorValueCommand should not be null" );
		Assert.notNull( accumulatorValue.getAccumulatorValueId(), "UpdateAccumulatorValueCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a AccumulatorValue
	 */
    public void validate( DeleteAccumulatorValueCommand accumulatorValue ) throws Exception {
		Assert.notNull( accumulatorValue, "{commandAlias} should not be null" );
		Assert.notNull( accumulatorValue.getAccumulatorValueId(), "DeleteAccumulatorValueCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a AccumulatorValue
	 */
	public void validate( AccumulatorValueFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "AccumulatorValueFetchOneSummary should not be null" );
		Assert.notNull( summary.getAccumulatorValueId(), "AccumulatorValueFetchOneSummary identifier should not be null" );
	}



}
