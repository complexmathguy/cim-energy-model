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

public class ExcST6BValidator {
		
	/**
	 * default constructor
	 */
	protected ExcST6BValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcST6BValidator getInstance() {
		return new ExcST6BValidator();
	}
		
	/**
	 * handles creation validation for a ExcST6B
	 */
	public void validate( CreateExcST6BCommand excST6B )throws Exception {
		Assert.notNull( excST6B, "CreateExcST6BCommand should not be null" );
//		Assert.isNull( excST6B.getExcST6BId(), "CreateExcST6BCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcST6B
	 */
	public void validate( UpdateExcST6BCommand excST6B ) throws Exception {
		Assert.notNull( excST6B, "UpdateExcST6BCommand should not be null" );
		Assert.notNull( excST6B.getExcST6BId(), "UpdateExcST6BCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcST6B
	 */
    public void validate( DeleteExcST6BCommand excST6B ) throws Exception {
		Assert.notNull( excST6B, "{commandAlias} should not be null" );
		Assert.notNull( excST6B.getExcST6BId(), "DeleteExcST6BCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcST6B
	 */
	public void validate( ExcST6BFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcST6BFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcST6BId(), "ExcST6BFetchOneSummary identifier should not be null" );
	}



}
