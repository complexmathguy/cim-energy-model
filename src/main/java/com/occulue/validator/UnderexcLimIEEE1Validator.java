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

public class UnderexcLimIEEE1Validator {
		
	/**
	 * default constructor
	 */
	protected UnderexcLimIEEE1Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public UnderexcLimIEEE1Validator getInstance() {
		return new UnderexcLimIEEE1Validator();
	}
		
	/**
	 * handles creation validation for a UnderexcLimIEEE1
	 */
	public void validate( CreateUnderexcLimIEEE1Command underexcLimIEEE1 )throws Exception {
		Assert.notNull( underexcLimIEEE1, "CreateUnderexcLimIEEE1Command should not be null" );
//		Assert.isNull( underexcLimIEEE1.getUnderexcLimIEEE1Id(), "CreateUnderexcLimIEEE1Command identifier should be null" );
	}

	/**
	 * handles update validation for a UnderexcLimIEEE1
	 */
	public void validate( UpdateUnderexcLimIEEE1Command underexcLimIEEE1 ) throws Exception {
		Assert.notNull( underexcLimIEEE1, "UpdateUnderexcLimIEEE1Command should not be null" );
		Assert.notNull( underexcLimIEEE1.getUnderexcLimIEEE1Id(), "UpdateUnderexcLimIEEE1Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a UnderexcLimIEEE1
	 */
    public void validate( DeleteUnderexcLimIEEE1Command underexcLimIEEE1 ) throws Exception {
		Assert.notNull( underexcLimIEEE1, "{commandAlias} should not be null" );
		Assert.notNull( underexcLimIEEE1.getUnderexcLimIEEE1Id(), "DeleteUnderexcLimIEEE1Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a UnderexcLimIEEE1
	 */
	public void validate( UnderexcLimIEEE1FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "UnderexcLimIEEE1FetchOneSummary should not be null" );
		Assert.notNull( summary.getUnderexcLimIEEE1Id(), "UnderexcLimIEEE1FetchOneSummary identifier should not be null" );
	}



}
