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

public class ExcAC3AValidator {
		
	/**
	 * default constructor
	 */
	protected ExcAC3AValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcAC3AValidator getInstance() {
		return new ExcAC3AValidator();
	}
		
	/**
	 * handles creation validation for a ExcAC3A
	 */
	public void validate( CreateExcAC3ACommand excAC3A )throws Exception {
		Assert.notNull( excAC3A, "CreateExcAC3ACommand should not be null" );
//		Assert.isNull( excAC3A.getExcAC3AId(), "CreateExcAC3ACommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcAC3A
	 */
	public void validate( UpdateExcAC3ACommand excAC3A ) throws Exception {
		Assert.notNull( excAC3A, "UpdateExcAC3ACommand should not be null" );
		Assert.notNull( excAC3A.getExcAC3AId(), "UpdateExcAC3ACommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcAC3A
	 */
    public void validate( DeleteExcAC3ACommand excAC3A ) throws Exception {
		Assert.notNull( excAC3A, "{commandAlias} should not be null" );
		Assert.notNull( excAC3A.getExcAC3AId(), "DeleteExcAC3ACommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcAC3A
	 */
	public void validate( ExcAC3AFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcAC3AFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcAC3AId(), "ExcAC3AFetchOneSummary identifier should not be null" );
	}



}
