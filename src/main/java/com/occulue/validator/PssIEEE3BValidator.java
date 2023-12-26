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

public class PssIEEE3BValidator {
		
	/**
	 * default constructor
	 */
	protected PssIEEE3BValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public PssIEEE3BValidator getInstance() {
		return new PssIEEE3BValidator();
	}
		
	/**
	 * handles creation validation for a PssIEEE3B
	 */
	public void validate( CreatePssIEEE3BCommand pssIEEE3B )throws Exception {
		Assert.notNull( pssIEEE3B, "CreatePssIEEE3BCommand should not be null" );
//		Assert.isNull( pssIEEE3B.getPssIEEE3BId(), "CreatePssIEEE3BCommand identifier should be null" );
	}

	/**
	 * handles update validation for a PssIEEE3B
	 */
	public void validate( UpdatePssIEEE3BCommand pssIEEE3B ) throws Exception {
		Assert.notNull( pssIEEE3B, "UpdatePssIEEE3BCommand should not be null" );
		Assert.notNull( pssIEEE3B.getPssIEEE3BId(), "UpdatePssIEEE3BCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a PssIEEE3B
	 */
    public void validate( DeletePssIEEE3BCommand pssIEEE3B ) throws Exception {
		Assert.notNull( pssIEEE3B, "{commandAlias} should not be null" );
		Assert.notNull( pssIEEE3B.getPssIEEE3BId(), "DeletePssIEEE3BCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a PssIEEE3B
	 */
	public void validate( PssIEEE3BFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "PssIEEE3BFetchOneSummary should not be null" );
		Assert.notNull( summary.getPssIEEE3BId(), "PssIEEE3BFetchOneSummary identifier should not be null" );
	}



}
