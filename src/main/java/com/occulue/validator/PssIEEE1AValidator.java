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

public class PssIEEE1AValidator {
		
	/**
	 * default constructor
	 */
	protected PssIEEE1AValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public PssIEEE1AValidator getInstance() {
		return new PssIEEE1AValidator();
	}
		
	/**
	 * handles creation validation for a PssIEEE1A
	 */
	public void validate( CreatePssIEEE1ACommand pssIEEE1A )throws Exception {
		Assert.notNull( pssIEEE1A, "CreatePssIEEE1ACommand should not be null" );
//		Assert.isNull( pssIEEE1A.getPssIEEE1AId(), "CreatePssIEEE1ACommand identifier should be null" );
	}

	/**
	 * handles update validation for a PssIEEE1A
	 */
	public void validate( UpdatePssIEEE1ACommand pssIEEE1A ) throws Exception {
		Assert.notNull( pssIEEE1A, "UpdatePssIEEE1ACommand should not be null" );
		Assert.notNull( pssIEEE1A.getPssIEEE1AId(), "UpdatePssIEEE1ACommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a PssIEEE1A
	 */
    public void validate( DeletePssIEEE1ACommand pssIEEE1A ) throws Exception {
		Assert.notNull( pssIEEE1A, "{commandAlias} should not be null" );
		Assert.notNull( pssIEEE1A.getPssIEEE1AId(), "DeletePssIEEE1ACommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a PssIEEE1A
	 */
	public void validate( PssIEEE1AFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "PssIEEE1AFetchOneSummary should not be null" );
		Assert.notNull( summary.getPssIEEE1AId(), "PssIEEE1AFetchOneSummary identifier should not be null" );
	}



}
