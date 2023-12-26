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

public class PssSKValidator {
		
	/**
	 * default constructor
	 */
	protected PssSKValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public PssSKValidator getInstance() {
		return new PssSKValidator();
	}
		
	/**
	 * handles creation validation for a PssSK
	 */
	public void validate( CreatePssSKCommand pssSK )throws Exception {
		Assert.notNull( pssSK, "CreatePssSKCommand should not be null" );
//		Assert.isNull( pssSK.getPssSKId(), "CreatePssSKCommand identifier should be null" );
	}

	/**
	 * handles update validation for a PssSK
	 */
	public void validate( UpdatePssSKCommand pssSK ) throws Exception {
		Assert.notNull( pssSK, "UpdatePssSKCommand should not be null" );
		Assert.notNull( pssSK.getPssSKId(), "UpdatePssSKCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a PssSK
	 */
    public void validate( DeletePssSKCommand pssSK ) throws Exception {
		Assert.notNull( pssSK, "{commandAlias} should not be null" );
		Assert.notNull( pssSK.getPssSKId(), "DeletePssSKCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a PssSK
	 */
	public void validate( PssSKFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "PssSKFetchOneSummary should not be null" );
		Assert.notNull( summary.getPssSKId(), "PssSKFetchOneSummary identifier should not be null" );
	}



}
