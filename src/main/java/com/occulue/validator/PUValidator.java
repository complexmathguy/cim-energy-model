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

public class PUValidator {
		
	/**
	 * default constructor
	 */
	protected PUValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public PUValidator getInstance() {
		return new PUValidator();
	}
		
	/**
	 * handles creation validation for a PU
	 */
	public void validate( CreatePUCommand pU )throws Exception {
		Assert.notNull( pU, "CreatePUCommand should not be null" );
//		Assert.isNull( pU.getPUId(), "CreatePUCommand identifier should be null" );
	}

	/**
	 * handles update validation for a PU
	 */
	public void validate( UpdatePUCommand pU ) throws Exception {
		Assert.notNull( pU, "UpdatePUCommand should not be null" );
		Assert.notNull( pU.getPUId(), "UpdatePUCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a PU
	 */
    public void validate( DeletePUCommand pU ) throws Exception {
		Assert.notNull( pU, "{commandAlias} should not be null" );
		Assert.notNull( pU.getPUId(), "DeletePUCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a PU
	 */
	public void validate( PUFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "PUFetchOneSummary should not be null" );
		Assert.notNull( summary.getPUId(), "PUFetchOneSummary identifier should not be null" );
	}



}
