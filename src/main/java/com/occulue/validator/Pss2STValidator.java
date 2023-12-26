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

public class Pss2STValidator {
		
	/**
	 * default constructor
	 */
	protected Pss2STValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public Pss2STValidator getInstance() {
		return new Pss2STValidator();
	}
		
	/**
	 * handles creation validation for a Pss2ST
	 */
	public void validate( CreatePss2STCommand pss2ST )throws Exception {
		Assert.notNull( pss2ST, "CreatePss2STCommand should not be null" );
//		Assert.isNull( pss2ST.getPss2STId(), "CreatePss2STCommand identifier should be null" );
	}

	/**
	 * handles update validation for a Pss2ST
	 */
	public void validate( UpdatePss2STCommand pss2ST ) throws Exception {
		Assert.notNull( pss2ST, "UpdatePss2STCommand should not be null" );
		Assert.notNull( pss2ST.getPss2STId(), "UpdatePss2STCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a Pss2ST
	 */
    public void validate( DeletePss2STCommand pss2ST ) throws Exception {
		Assert.notNull( pss2ST, "{commandAlias} should not be null" );
		Assert.notNull( pss2ST.getPss2STId(), "DeletePss2STCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a Pss2ST
	 */
	public void validate( Pss2STFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "Pss2STFetchOneSummary should not be null" );
		Assert.notNull( summary.getPss2STId(), "Pss2STFetchOneSummary identifier should not be null" );
	}



}
