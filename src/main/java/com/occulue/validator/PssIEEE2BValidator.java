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

public class PssIEEE2BValidator {
		
	/**
	 * default constructor
	 */
	protected PssIEEE2BValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public PssIEEE2BValidator getInstance() {
		return new PssIEEE2BValidator();
	}
		
	/**
	 * handles creation validation for a PssIEEE2B
	 */
	public void validate( CreatePssIEEE2BCommand pssIEEE2B )throws Exception {
		Assert.notNull( pssIEEE2B, "CreatePssIEEE2BCommand should not be null" );
//		Assert.isNull( pssIEEE2B.getPssIEEE2BId(), "CreatePssIEEE2BCommand identifier should be null" );
	}

	/**
	 * handles update validation for a PssIEEE2B
	 */
	public void validate( UpdatePssIEEE2BCommand pssIEEE2B ) throws Exception {
		Assert.notNull( pssIEEE2B, "UpdatePssIEEE2BCommand should not be null" );
		Assert.notNull( pssIEEE2B.getPssIEEE2BId(), "UpdatePssIEEE2BCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a PssIEEE2B
	 */
    public void validate( DeletePssIEEE2BCommand pssIEEE2B ) throws Exception {
		Assert.notNull( pssIEEE2B, "{commandAlias} should not be null" );
		Assert.notNull( pssIEEE2B.getPssIEEE2BId(), "DeletePssIEEE2BCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a PssIEEE2B
	 */
	public void validate( PssIEEE2BFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "PssIEEE2BFetchOneSummary should not be null" );
		Assert.notNull( summary.getPssIEEE2BId(), "PssIEEE2BFetchOneSummary identifier should not be null" );
	}



}
