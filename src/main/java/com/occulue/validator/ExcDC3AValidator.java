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

public class ExcDC3AValidator {
		
	/**
	 * default constructor
	 */
	protected ExcDC3AValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcDC3AValidator getInstance() {
		return new ExcDC3AValidator();
	}
		
	/**
	 * handles creation validation for a ExcDC3A
	 */
	public void validate( CreateExcDC3ACommand excDC3A )throws Exception {
		Assert.notNull( excDC3A, "CreateExcDC3ACommand should not be null" );
//		Assert.isNull( excDC3A.getExcDC3AId(), "CreateExcDC3ACommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcDC3A
	 */
	public void validate( UpdateExcDC3ACommand excDC3A ) throws Exception {
		Assert.notNull( excDC3A, "UpdateExcDC3ACommand should not be null" );
		Assert.notNull( excDC3A.getExcDC3AId(), "UpdateExcDC3ACommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcDC3A
	 */
    public void validate( DeleteExcDC3ACommand excDC3A ) throws Exception {
		Assert.notNull( excDC3A, "{commandAlias} should not be null" );
		Assert.notNull( excDC3A.getExcDC3AId(), "DeleteExcDC3ACommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcDC3A
	 */
	public void validate( ExcDC3AFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcDC3AFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcDC3AId(), "ExcDC3AFetchOneSummary identifier should not be null" );
	}



}
