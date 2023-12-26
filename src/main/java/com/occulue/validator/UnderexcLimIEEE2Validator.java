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

public class UnderexcLimIEEE2Validator {
		
	/**
	 * default constructor
	 */
	protected UnderexcLimIEEE2Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public UnderexcLimIEEE2Validator getInstance() {
		return new UnderexcLimIEEE2Validator();
	}
		
	/**
	 * handles creation validation for a UnderexcLimIEEE2
	 */
	public void validate( CreateUnderexcLimIEEE2Command underexcLimIEEE2 )throws Exception {
		Assert.notNull( underexcLimIEEE2, "CreateUnderexcLimIEEE2Command should not be null" );
//		Assert.isNull( underexcLimIEEE2.getUnderexcLimIEEE2Id(), "CreateUnderexcLimIEEE2Command identifier should be null" );
	}

	/**
	 * handles update validation for a UnderexcLimIEEE2
	 */
	public void validate( UpdateUnderexcLimIEEE2Command underexcLimIEEE2 ) throws Exception {
		Assert.notNull( underexcLimIEEE2, "UpdateUnderexcLimIEEE2Command should not be null" );
		Assert.notNull( underexcLimIEEE2.getUnderexcLimIEEE2Id(), "UpdateUnderexcLimIEEE2Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a UnderexcLimIEEE2
	 */
    public void validate( DeleteUnderexcLimIEEE2Command underexcLimIEEE2 ) throws Exception {
		Assert.notNull( underexcLimIEEE2, "{commandAlias} should not be null" );
		Assert.notNull( underexcLimIEEE2.getUnderexcLimIEEE2Id(), "DeleteUnderexcLimIEEE2Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a UnderexcLimIEEE2
	 */
	public void validate( UnderexcLimIEEE2FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "UnderexcLimIEEE2FetchOneSummary should not be null" );
		Assert.notNull( summary.getUnderexcLimIEEE2Id(), "UnderexcLimIEEE2FetchOneSummary identifier should not be null" );
	}



}
