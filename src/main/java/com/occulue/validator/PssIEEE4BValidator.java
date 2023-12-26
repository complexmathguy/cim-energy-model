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

public class PssIEEE4BValidator {
		
	/**
	 * default constructor
	 */
	protected PssIEEE4BValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public PssIEEE4BValidator getInstance() {
		return new PssIEEE4BValidator();
	}
		
	/**
	 * handles creation validation for a PssIEEE4B
	 */
	public void validate( CreatePssIEEE4BCommand pssIEEE4B )throws Exception {
		Assert.notNull( pssIEEE4B, "CreatePssIEEE4BCommand should not be null" );
//		Assert.isNull( pssIEEE4B.getPssIEEE4BId(), "CreatePssIEEE4BCommand identifier should be null" );
	}

	/**
	 * handles update validation for a PssIEEE4B
	 */
	public void validate( UpdatePssIEEE4BCommand pssIEEE4B ) throws Exception {
		Assert.notNull( pssIEEE4B, "UpdatePssIEEE4BCommand should not be null" );
		Assert.notNull( pssIEEE4B.getPssIEEE4BId(), "UpdatePssIEEE4BCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a PssIEEE4B
	 */
    public void validate( DeletePssIEEE4BCommand pssIEEE4B ) throws Exception {
		Assert.notNull( pssIEEE4B, "{commandAlias} should not be null" );
		Assert.notNull( pssIEEE4B.getPssIEEE4BId(), "DeletePssIEEE4BCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a PssIEEE4B
	 */
	public void validate( PssIEEE4BFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "PssIEEE4BFetchOneSummary should not be null" );
		Assert.notNull( summary.getPssIEEE4BId(), "PssIEEE4BFetchOneSummary identifier should not be null" );
	}



}
