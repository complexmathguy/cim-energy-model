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

public class UnderexcLimX2Validator {
		
	/**
	 * default constructor
	 */
	protected UnderexcLimX2Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public UnderexcLimX2Validator getInstance() {
		return new UnderexcLimX2Validator();
	}
		
	/**
	 * handles creation validation for a UnderexcLimX2
	 */
	public void validate( CreateUnderexcLimX2Command underexcLimX2 )throws Exception {
		Assert.notNull( underexcLimX2, "CreateUnderexcLimX2Command should not be null" );
//		Assert.isNull( underexcLimX2.getUnderexcLimX2Id(), "CreateUnderexcLimX2Command identifier should be null" );
	}

	/**
	 * handles update validation for a UnderexcLimX2
	 */
	public void validate( UpdateUnderexcLimX2Command underexcLimX2 ) throws Exception {
		Assert.notNull( underexcLimX2, "UpdateUnderexcLimX2Command should not be null" );
		Assert.notNull( underexcLimX2.getUnderexcLimX2Id(), "UpdateUnderexcLimX2Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a UnderexcLimX2
	 */
    public void validate( DeleteUnderexcLimX2Command underexcLimX2 ) throws Exception {
		Assert.notNull( underexcLimX2, "{commandAlias} should not be null" );
		Assert.notNull( underexcLimX2.getUnderexcLimX2Id(), "DeleteUnderexcLimX2Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a UnderexcLimX2
	 */
	public void validate( UnderexcLimX2FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "UnderexcLimX2FetchOneSummary should not be null" );
		Assert.notNull( summary.getUnderexcLimX2Id(), "UnderexcLimX2FetchOneSummary identifier should not be null" );
	}



}
