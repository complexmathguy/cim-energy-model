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

public class ExcHUValidator {
		
	/**
	 * default constructor
	 */
	protected ExcHUValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcHUValidator getInstance() {
		return new ExcHUValidator();
	}
		
	/**
	 * handles creation validation for a ExcHU
	 */
	public void validate( CreateExcHUCommand excHU )throws Exception {
		Assert.notNull( excHU, "CreateExcHUCommand should not be null" );
//		Assert.isNull( excHU.getExcHUId(), "CreateExcHUCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcHU
	 */
	public void validate( UpdateExcHUCommand excHU ) throws Exception {
		Assert.notNull( excHU, "UpdateExcHUCommand should not be null" );
		Assert.notNull( excHU.getExcHUId(), "UpdateExcHUCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcHU
	 */
    public void validate( DeleteExcHUCommand excHU ) throws Exception {
		Assert.notNull( excHU, "{commandAlias} should not be null" );
		Assert.notNull( excHU.getExcHUId(), "DeleteExcHUCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcHU
	 */
	public void validate( ExcHUFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcHUFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcHUId(), "ExcHUFetchOneSummary identifier should not be null" );
	}



}
