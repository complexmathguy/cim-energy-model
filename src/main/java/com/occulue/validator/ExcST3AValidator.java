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

public class ExcST3AValidator {
		
	/**
	 * default constructor
	 */
	protected ExcST3AValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcST3AValidator getInstance() {
		return new ExcST3AValidator();
	}
		
	/**
	 * handles creation validation for a ExcST3A
	 */
	public void validate( CreateExcST3ACommand excST3A )throws Exception {
		Assert.notNull( excST3A, "CreateExcST3ACommand should not be null" );
//		Assert.isNull( excST3A.getExcST3AId(), "CreateExcST3ACommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcST3A
	 */
	public void validate( UpdateExcST3ACommand excST3A ) throws Exception {
		Assert.notNull( excST3A, "UpdateExcST3ACommand should not be null" );
		Assert.notNull( excST3A.getExcST3AId(), "UpdateExcST3ACommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcST3A
	 */
    public void validate( DeleteExcST3ACommand excST3A ) throws Exception {
		Assert.notNull( excST3A, "{commandAlias} should not be null" );
		Assert.notNull( excST3A.getExcST3AId(), "DeleteExcST3ACommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcST3A
	 */
	public void validate( ExcST3AFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcST3AFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcST3AId(), "ExcST3AFetchOneSummary identifier should not be null" );
	}



}
