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

public class PssWECCValidator {
		
	/**
	 * default constructor
	 */
	protected PssWECCValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public PssWECCValidator getInstance() {
		return new PssWECCValidator();
	}
		
	/**
	 * handles creation validation for a PssWECC
	 */
	public void validate( CreatePssWECCCommand pssWECC )throws Exception {
		Assert.notNull( pssWECC, "CreatePssWECCCommand should not be null" );
//		Assert.isNull( pssWECC.getPssWECCId(), "CreatePssWECCCommand identifier should be null" );
	}

	/**
	 * handles update validation for a PssWECC
	 */
	public void validate( UpdatePssWECCCommand pssWECC ) throws Exception {
		Assert.notNull( pssWECC, "UpdatePssWECCCommand should not be null" );
		Assert.notNull( pssWECC.getPssWECCId(), "UpdatePssWECCCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a PssWECC
	 */
    public void validate( DeletePssWECCCommand pssWECC ) throws Exception {
		Assert.notNull( pssWECC, "{commandAlias} should not be null" );
		Assert.notNull( pssWECC.getPssWECCId(), "DeletePssWECCCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a PssWECC
	 */
	public void validate( PssWECCFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "PssWECCFetchOneSummary should not be null" );
		Assert.notNull( summary.getPssWECCId(), "PssWECCFetchOneSummary identifier should not be null" );
	}



}
