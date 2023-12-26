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

public class Pss5Validator {
		
	/**
	 * default constructor
	 */
	protected Pss5Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public Pss5Validator getInstance() {
		return new Pss5Validator();
	}
		
	/**
	 * handles creation validation for a Pss5
	 */
	public void validate( CreatePss5Command pss5 )throws Exception {
		Assert.notNull( pss5, "CreatePss5Command should not be null" );
//		Assert.isNull( pss5.getPss5Id(), "CreatePss5Command identifier should be null" );
	}

	/**
	 * handles update validation for a Pss5
	 */
	public void validate( UpdatePss5Command pss5 ) throws Exception {
		Assert.notNull( pss5, "UpdatePss5Command should not be null" );
		Assert.notNull( pss5.getPss5Id(), "UpdatePss5Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a Pss5
	 */
    public void validate( DeletePss5Command pss5 ) throws Exception {
		Assert.notNull( pss5, "{commandAlias} should not be null" );
		Assert.notNull( pss5.getPss5Id(), "DeletePss5Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a Pss5
	 */
	public void validate( Pss5FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "Pss5FetchOneSummary should not be null" );
		Assert.notNull( summary.getPss5Id(), "Pss5FetchOneSummary identifier should not be null" );
	}



}
