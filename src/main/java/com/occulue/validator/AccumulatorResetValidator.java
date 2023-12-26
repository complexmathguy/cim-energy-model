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

public class AccumulatorResetValidator {
		
	/**
	 * default constructor
	 */
	protected AccumulatorResetValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public AccumulatorResetValidator getInstance() {
		return new AccumulatorResetValidator();
	}
		
	/**
	 * handles creation validation for a AccumulatorReset
	 */
	public void validate( CreateAccumulatorResetCommand accumulatorReset )throws Exception {
		Assert.notNull( accumulatorReset, "CreateAccumulatorResetCommand should not be null" );
//		Assert.isNull( accumulatorReset.getAccumulatorResetId(), "CreateAccumulatorResetCommand identifier should be null" );
	}

	/**
	 * handles update validation for a AccumulatorReset
	 */
	public void validate( UpdateAccumulatorResetCommand accumulatorReset ) throws Exception {
		Assert.notNull( accumulatorReset, "UpdateAccumulatorResetCommand should not be null" );
		Assert.notNull( accumulatorReset.getAccumulatorResetId(), "UpdateAccumulatorResetCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a AccumulatorReset
	 */
    public void validate( DeleteAccumulatorResetCommand accumulatorReset ) throws Exception {
		Assert.notNull( accumulatorReset, "{commandAlias} should not be null" );
		Assert.notNull( accumulatorReset.getAccumulatorResetId(), "DeleteAccumulatorResetCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a AccumulatorReset
	 */
	public void validate( AccumulatorResetFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "AccumulatorResetFetchOneSummary should not be null" );
		Assert.notNull( summary.getAccumulatorResetId(), "AccumulatorResetFetchOneSummary identifier should not be null" );
	}



}
