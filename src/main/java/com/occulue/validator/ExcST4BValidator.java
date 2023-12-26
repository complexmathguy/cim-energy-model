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

public class ExcST4BValidator {
		
	/**
	 * default constructor
	 */
	protected ExcST4BValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcST4BValidator getInstance() {
		return new ExcST4BValidator();
	}
		
	/**
	 * handles creation validation for a ExcST4B
	 */
	public void validate( CreateExcST4BCommand excST4B )throws Exception {
		Assert.notNull( excST4B, "CreateExcST4BCommand should not be null" );
//		Assert.isNull( excST4B.getExcST4BId(), "CreateExcST4BCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcST4B
	 */
	public void validate( UpdateExcST4BCommand excST4B ) throws Exception {
		Assert.notNull( excST4B, "UpdateExcST4BCommand should not be null" );
		Assert.notNull( excST4B.getExcST4BId(), "UpdateExcST4BCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcST4B
	 */
    public void validate( DeleteExcST4BCommand excST4B ) throws Exception {
		Assert.notNull( excST4B, "{commandAlias} should not be null" );
		Assert.notNull( excST4B.getExcST4BId(), "DeleteExcST4BCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcST4B
	 */
	public void validate( ExcST4BFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcST4BFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcST4BId(), "ExcST4BFetchOneSummary identifier should not be null" );
	}



}
