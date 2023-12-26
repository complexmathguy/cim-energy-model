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

public class ExcCZValidator {
		
	/**
	 * default constructor
	 */
	protected ExcCZValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcCZValidator getInstance() {
		return new ExcCZValidator();
	}
		
	/**
	 * handles creation validation for a ExcCZ
	 */
	public void validate( CreateExcCZCommand excCZ )throws Exception {
		Assert.notNull( excCZ, "CreateExcCZCommand should not be null" );
//		Assert.isNull( excCZ.getExcCZId(), "CreateExcCZCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcCZ
	 */
	public void validate( UpdateExcCZCommand excCZ ) throws Exception {
		Assert.notNull( excCZ, "UpdateExcCZCommand should not be null" );
		Assert.notNull( excCZ.getExcCZId(), "UpdateExcCZCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcCZ
	 */
    public void validate( DeleteExcCZCommand excCZ ) throws Exception {
		Assert.notNull( excCZ, "{commandAlias} should not be null" );
		Assert.notNull( excCZ.getExcCZId(), "DeleteExcCZCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcCZ
	 */
	public void validate( ExcCZFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcCZFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcCZId(), "ExcCZFetchOneSummary identifier should not be null" );
	}



}
