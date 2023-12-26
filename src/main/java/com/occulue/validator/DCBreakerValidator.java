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

public class DCBreakerValidator {
		
	/**
	 * default constructor
	 */
	protected DCBreakerValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public DCBreakerValidator getInstance() {
		return new DCBreakerValidator();
	}
		
	/**
	 * handles creation validation for a DCBreaker
	 */
	public void validate( CreateDCBreakerCommand dCBreaker )throws Exception {
		Assert.notNull( dCBreaker, "CreateDCBreakerCommand should not be null" );
//		Assert.isNull( dCBreaker.getDCBreakerId(), "CreateDCBreakerCommand identifier should be null" );
	}

	/**
	 * handles update validation for a DCBreaker
	 */
	public void validate( UpdateDCBreakerCommand dCBreaker ) throws Exception {
		Assert.notNull( dCBreaker, "UpdateDCBreakerCommand should not be null" );
		Assert.notNull( dCBreaker.getDCBreakerId(), "UpdateDCBreakerCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a DCBreaker
	 */
    public void validate( DeleteDCBreakerCommand dCBreaker ) throws Exception {
		Assert.notNull( dCBreaker, "{commandAlias} should not be null" );
		Assert.notNull( dCBreaker.getDCBreakerId(), "DeleteDCBreakerCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a DCBreaker
	 */
	public void validate( DCBreakerFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "DCBreakerFetchOneSummary should not be null" );
		Assert.notNull( summary.getDCBreakerId(), "DCBreakerFetchOneSummary identifier should not be null" );
	}



}
