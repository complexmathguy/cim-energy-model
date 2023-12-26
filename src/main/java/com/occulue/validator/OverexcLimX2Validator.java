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

public class OverexcLimX2Validator {
		
	/**
	 * default constructor
	 */
	protected OverexcLimX2Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public OverexcLimX2Validator getInstance() {
		return new OverexcLimX2Validator();
	}
		
	/**
	 * handles creation validation for a OverexcLimX2
	 */
	public void validate( CreateOverexcLimX2Command overexcLimX2 )throws Exception {
		Assert.notNull( overexcLimX2, "CreateOverexcLimX2Command should not be null" );
//		Assert.isNull( overexcLimX2.getOverexcLimX2Id(), "CreateOverexcLimX2Command identifier should be null" );
	}

	/**
	 * handles update validation for a OverexcLimX2
	 */
	public void validate( UpdateOverexcLimX2Command overexcLimX2 ) throws Exception {
		Assert.notNull( overexcLimX2, "UpdateOverexcLimX2Command should not be null" );
		Assert.notNull( overexcLimX2.getOverexcLimX2Id(), "UpdateOverexcLimX2Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a OverexcLimX2
	 */
    public void validate( DeleteOverexcLimX2Command overexcLimX2 ) throws Exception {
		Assert.notNull( overexcLimX2, "{commandAlias} should not be null" );
		Assert.notNull( overexcLimX2.getOverexcLimX2Id(), "DeleteOverexcLimX2Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a OverexcLimX2
	 */
	public void validate( OverexcLimX2FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "OverexcLimX2FetchOneSummary should not be null" );
		Assert.notNull( summary.getOverexcLimX2Id(), "OverexcLimX2FetchOneSummary identifier should not be null" );
	}



}
