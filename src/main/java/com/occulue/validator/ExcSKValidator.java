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

public class ExcSKValidator {
		
	/**
	 * default constructor
	 */
	protected ExcSKValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcSKValidator getInstance() {
		return new ExcSKValidator();
	}
		
	/**
	 * handles creation validation for a ExcSK
	 */
	public void validate( CreateExcSKCommand excSK )throws Exception {
		Assert.notNull( excSK, "CreateExcSKCommand should not be null" );
//		Assert.isNull( excSK.getExcSKId(), "CreateExcSKCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcSK
	 */
	public void validate( UpdateExcSKCommand excSK ) throws Exception {
		Assert.notNull( excSK, "UpdateExcSKCommand should not be null" );
		Assert.notNull( excSK.getExcSKId(), "UpdateExcSKCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcSK
	 */
    public void validate( DeleteExcSKCommand excSK ) throws Exception {
		Assert.notNull( excSK, "{commandAlias} should not be null" );
		Assert.notNull( excSK.getExcSKId(), "DeleteExcSKCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcSK
	 */
	public void validate( ExcSKFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcSKFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcSKId(), "ExcSKFetchOneSummary identifier should not be null" );
	}



}
