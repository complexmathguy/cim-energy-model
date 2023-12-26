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

public class OverexcLimX1Validator {
		
	/**
	 * default constructor
	 */
	protected OverexcLimX1Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public OverexcLimX1Validator getInstance() {
		return new OverexcLimX1Validator();
	}
		
	/**
	 * handles creation validation for a OverexcLimX1
	 */
	public void validate( CreateOverexcLimX1Command overexcLimX1 )throws Exception {
		Assert.notNull( overexcLimX1, "CreateOverexcLimX1Command should not be null" );
//		Assert.isNull( overexcLimX1.getOverexcLimX1Id(), "CreateOverexcLimX1Command identifier should be null" );
	}

	/**
	 * handles update validation for a OverexcLimX1
	 */
	public void validate( UpdateOverexcLimX1Command overexcLimX1 ) throws Exception {
		Assert.notNull( overexcLimX1, "UpdateOverexcLimX1Command should not be null" );
		Assert.notNull( overexcLimX1.getOverexcLimX1Id(), "UpdateOverexcLimX1Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a OverexcLimX1
	 */
    public void validate( DeleteOverexcLimX1Command overexcLimX1 ) throws Exception {
		Assert.notNull( overexcLimX1, "{commandAlias} should not be null" );
		Assert.notNull( overexcLimX1.getOverexcLimX1Id(), "DeleteOverexcLimX1Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a OverexcLimX1
	 */
	public void validate( OverexcLimX1FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "OverexcLimX1FetchOneSummary should not be null" );
		Assert.notNull( summary.getOverexcLimX1Id(), "OverexcLimX1FetchOneSummary identifier should not be null" );
	}



}
