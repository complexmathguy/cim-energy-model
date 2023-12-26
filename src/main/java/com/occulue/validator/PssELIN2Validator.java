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

public class PssELIN2Validator {
		
	/**
	 * default constructor
	 */
	protected PssELIN2Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public PssELIN2Validator getInstance() {
		return new PssELIN2Validator();
	}
		
	/**
	 * handles creation validation for a PssELIN2
	 */
	public void validate( CreatePssELIN2Command pssELIN2 )throws Exception {
		Assert.notNull( pssELIN2, "CreatePssELIN2Command should not be null" );
//		Assert.isNull( pssELIN2.getPssELIN2Id(), "CreatePssELIN2Command identifier should be null" );
	}

	/**
	 * handles update validation for a PssELIN2
	 */
	public void validate( UpdatePssELIN2Command pssELIN2 ) throws Exception {
		Assert.notNull( pssELIN2, "UpdatePssELIN2Command should not be null" );
		Assert.notNull( pssELIN2.getPssELIN2Id(), "UpdatePssELIN2Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a PssELIN2
	 */
    public void validate( DeletePssELIN2Command pssELIN2 ) throws Exception {
		Assert.notNull( pssELIN2, "{commandAlias} should not be null" );
		Assert.notNull( pssELIN2.getPssELIN2Id(), "DeletePssELIN2Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a PssELIN2
	 */
	public void validate( PssELIN2FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "PssELIN2FetchOneSummary should not be null" );
		Assert.notNull( summary.getPssELIN2Id(), "PssELIN2FetchOneSummary identifier should not be null" );
	}



}
