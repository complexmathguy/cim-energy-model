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

public class PssSB4Validator {
		
	/**
	 * default constructor
	 */
	protected PssSB4Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public PssSB4Validator getInstance() {
		return new PssSB4Validator();
	}
		
	/**
	 * handles creation validation for a PssSB4
	 */
	public void validate( CreatePssSB4Command pssSB4 )throws Exception {
		Assert.notNull( pssSB4, "CreatePssSB4Command should not be null" );
//		Assert.isNull( pssSB4.getPssSB4Id(), "CreatePssSB4Command identifier should be null" );
	}

	/**
	 * handles update validation for a PssSB4
	 */
	public void validate( UpdatePssSB4Command pssSB4 ) throws Exception {
		Assert.notNull( pssSB4, "UpdatePssSB4Command should not be null" );
		Assert.notNull( pssSB4.getPssSB4Id(), "UpdatePssSB4Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a PssSB4
	 */
    public void validate( DeletePssSB4Command pssSB4 ) throws Exception {
		Assert.notNull( pssSB4, "{commandAlias} should not be null" );
		Assert.notNull( pssSB4.getPssSB4Id(), "DeletePssSB4Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a PssSB4
	 */
	public void validate( PssSB4FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "PssSB4FetchOneSummary should not be null" );
		Assert.notNull( summary.getPssSB4Id(), "PssSB4FetchOneSummary identifier should not be null" );
	}



}
