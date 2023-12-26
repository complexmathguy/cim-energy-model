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

public class ExcST7BValidator {
		
	/**
	 * default constructor
	 */
	protected ExcST7BValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcST7BValidator getInstance() {
		return new ExcST7BValidator();
	}
		
	/**
	 * handles creation validation for a ExcST7B
	 */
	public void validate( CreateExcST7BCommand excST7B )throws Exception {
		Assert.notNull( excST7B, "CreateExcST7BCommand should not be null" );
//		Assert.isNull( excST7B.getExcST7BId(), "CreateExcST7BCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcST7B
	 */
	public void validate( UpdateExcST7BCommand excST7B ) throws Exception {
		Assert.notNull( excST7B, "UpdateExcST7BCommand should not be null" );
		Assert.notNull( excST7B.getExcST7BId(), "UpdateExcST7BCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcST7B
	 */
    public void validate( DeleteExcST7BCommand excST7B ) throws Exception {
		Assert.notNull( excST7B, "{commandAlias} should not be null" );
		Assert.notNull( excST7B.getExcST7BId(), "DeleteExcST7BCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcST7B
	 */
	public void validate( ExcST7BFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcST7BFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcST7BId(), "ExcST7BFetchOneSummary identifier should not be null" );
	}



}
