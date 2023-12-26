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

public class AccumulatorValidator {
		
	/**
	 * default constructor
	 */
	protected AccumulatorValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public AccumulatorValidator getInstance() {
		return new AccumulatorValidator();
	}
		
	/**
	 * handles creation validation for a Accumulator
	 */
	public void validate( CreateAccumulatorCommand accumulator )throws Exception {
		Assert.notNull( accumulator, "CreateAccumulatorCommand should not be null" );
//		Assert.isNull( accumulator.getAccumulatorId(), "CreateAccumulatorCommand identifier should be null" );
	}

	/**
	 * handles update validation for a Accumulator
	 */
	public void validate( UpdateAccumulatorCommand accumulator ) throws Exception {
		Assert.notNull( accumulator, "UpdateAccumulatorCommand should not be null" );
		Assert.notNull( accumulator.getAccumulatorId(), "UpdateAccumulatorCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a Accumulator
	 */
    public void validate( DeleteAccumulatorCommand accumulator ) throws Exception {
		Assert.notNull( accumulator, "{commandAlias} should not be null" );
		Assert.notNull( accumulator.getAccumulatorId(), "DeleteAccumulatorCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a Accumulator
	 */
	public void validate( AccumulatorFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "AccumulatorFetchOneSummary should not be null" );
		Assert.notNull( summary.getAccumulatorId(), "AccumulatorFetchOneSummary identifier should not be null" );
	}



}
