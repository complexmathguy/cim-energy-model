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

public class Pss2BValidator {
		
	/**
	 * default constructor
	 */
	protected Pss2BValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public Pss2BValidator getInstance() {
		return new Pss2BValidator();
	}
		
	/**
	 * handles creation validation for a Pss2B
	 */
	public void validate( CreatePss2BCommand pss2B )throws Exception {
		Assert.notNull( pss2B, "CreatePss2BCommand should not be null" );
//		Assert.isNull( pss2B.getPss2BId(), "CreatePss2BCommand identifier should be null" );
	}

	/**
	 * handles update validation for a Pss2B
	 */
	public void validate( UpdatePss2BCommand pss2B ) throws Exception {
		Assert.notNull( pss2B, "UpdatePss2BCommand should not be null" );
		Assert.notNull( pss2B.getPss2BId(), "UpdatePss2BCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a Pss2B
	 */
    public void validate( DeletePss2BCommand pss2B ) throws Exception {
		Assert.notNull( pss2B, "{commandAlias} should not be null" );
		Assert.notNull( pss2B.getPss2BId(), "DeletePss2BCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a Pss2B
	 */
	public void validate( Pss2BFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "Pss2BFetchOneSummary should not be null" );
		Assert.notNull( summary.getPss2BId(), "Pss2BFetchOneSummary identifier should not be null" );
	}



}
