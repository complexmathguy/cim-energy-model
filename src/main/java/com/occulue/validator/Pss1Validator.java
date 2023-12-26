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

public class Pss1Validator {
		
	/**
	 * default constructor
	 */
	protected Pss1Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public Pss1Validator getInstance() {
		return new Pss1Validator();
	}
		
	/**
	 * handles creation validation for a Pss1
	 */
	public void validate( CreatePss1Command pss1 )throws Exception {
		Assert.notNull( pss1, "CreatePss1Command should not be null" );
//		Assert.isNull( pss1.getPss1Id(), "CreatePss1Command identifier should be null" );
	}

	/**
	 * handles update validation for a Pss1
	 */
	public void validate( UpdatePss1Command pss1 ) throws Exception {
		Assert.notNull( pss1, "UpdatePss1Command should not be null" );
		Assert.notNull( pss1.getPss1Id(), "UpdatePss1Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a Pss1
	 */
    public void validate( DeletePss1Command pss1 ) throws Exception {
		Assert.notNull( pss1, "{commandAlias} should not be null" );
		Assert.notNull( pss1.getPss1Id(), "DeletePss1Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a Pss1
	 */
	public void validate( Pss1FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "Pss1FetchOneSummary should not be null" );
		Assert.notNull( summary.getPss1Id(), "Pss1FetchOneSummary identifier should not be null" );
	}



}
