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

public class OverexcLimIEEEValidator {
		
	/**
	 * default constructor
	 */
	protected OverexcLimIEEEValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public OverexcLimIEEEValidator getInstance() {
		return new OverexcLimIEEEValidator();
	}
		
	/**
	 * handles creation validation for a OverexcLimIEEE
	 */
	public void validate( CreateOverexcLimIEEECommand overexcLimIEEE )throws Exception {
		Assert.notNull( overexcLimIEEE, "CreateOverexcLimIEEECommand should not be null" );
//		Assert.isNull( overexcLimIEEE.getOverexcLimIEEEId(), "CreateOverexcLimIEEECommand identifier should be null" );
	}

	/**
	 * handles update validation for a OverexcLimIEEE
	 */
	public void validate( UpdateOverexcLimIEEECommand overexcLimIEEE ) throws Exception {
		Assert.notNull( overexcLimIEEE, "UpdateOverexcLimIEEECommand should not be null" );
		Assert.notNull( overexcLimIEEE.getOverexcLimIEEEId(), "UpdateOverexcLimIEEECommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a OverexcLimIEEE
	 */
    public void validate( DeleteOverexcLimIEEECommand overexcLimIEEE ) throws Exception {
		Assert.notNull( overexcLimIEEE, "{commandAlias} should not be null" );
		Assert.notNull( overexcLimIEEE.getOverexcLimIEEEId(), "DeleteOverexcLimIEEECommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a OverexcLimIEEE
	 */
	public void validate( OverexcLimIEEEFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "OverexcLimIEEEFetchOneSummary should not be null" );
		Assert.notNull( summary.getOverexcLimIEEEId(), "OverexcLimIEEEFetchOneSummary identifier should not be null" );
	}



}
