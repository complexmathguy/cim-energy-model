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

public class Pss1AValidator {
		
	/**
	 * default constructor
	 */
	protected Pss1AValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public Pss1AValidator getInstance() {
		return new Pss1AValidator();
	}
		
	/**
	 * handles creation validation for a Pss1A
	 */
	public void validate( CreatePss1ACommand pss1A )throws Exception {
		Assert.notNull( pss1A, "CreatePss1ACommand should not be null" );
//		Assert.isNull( pss1A.getPss1AId(), "CreatePss1ACommand identifier should be null" );
	}

	/**
	 * handles update validation for a Pss1A
	 */
	public void validate( UpdatePss1ACommand pss1A ) throws Exception {
		Assert.notNull( pss1A, "UpdatePss1ACommand should not be null" );
		Assert.notNull( pss1A.getPss1AId(), "UpdatePss1ACommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a Pss1A
	 */
    public void validate( DeletePss1ACommand pss1A ) throws Exception {
		Assert.notNull( pss1A, "{commandAlias} should not be null" );
		Assert.notNull( pss1A.getPss1AId(), "DeletePss1ACommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a Pss1A
	 */
	public void validate( Pss1AFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "Pss1AFetchOneSummary should not be null" );
		Assert.notNull( summary.getPss1AId(), "Pss1AFetchOneSummary identifier should not be null" );
	}



}
