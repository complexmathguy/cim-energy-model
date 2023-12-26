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

public class UnderexcLimX1Validator {
		
	/**
	 * default constructor
	 */
	protected UnderexcLimX1Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public UnderexcLimX1Validator getInstance() {
		return new UnderexcLimX1Validator();
	}
		
	/**
	 * handles creation validation for a UnderexcLimX1
	 */
	public void validate( CreateUnderexcLimX1Command underexcLimX1 )throws Exception {
		Assert.notNull( underexcLimX1, "CreateUnderexcLimX1Command should not be null" );
//		Assert.isNull( underexcLimX1.getUnderexcLimX1Id(), "CreateUnderexcLimX1Command identifier should be null" );
	}

	/**
	 * handles update validation for a UnderexcLimX1
	 */
	public void validate( UpdateUnderexcLimX1Command underexcLimX1 ) throws Exception {
		Assert.notNull( underexcLimX1, "UpdateUnderexcLimX1Command should not be null" );
		Assert.notNull( underexcLimX1.getUnderexcLimX1Id(), "UpdateUnderexcLimX1Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a UnderexcLimX1
	 */
    public void validate( DeleteUnderexcLimX1Command underexcLimX1 ) throws Exception {
		Assert.notNull( underexcLimX1, "{commandAlias} should not be null" );
		Assert.notNull( underexcLimX1.getUnderexcLimX1Id(), "DeleteUnderexcLimX1Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a UnderexcLimX1
	 */
	public void validate( UnderexcLimX1FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "UnderexcLimX1FetchOneSummary should not be null" );
		Assert.notNull( summary.getUnderexcLimX1Id(), "UnderexcLimX1FetchOneSummary identifier should not be null" );
	}



}
