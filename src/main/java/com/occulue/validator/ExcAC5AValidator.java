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

public class ExcAC5AValidator {
		
	/**
	 * default constructor
	 */
	protected ExcAC5AValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcAC5AValidator getInstance() {
		return new ExcAC5AValidator();
	}
		
	/**
	 * handles creation validation for a ExcAC5A
	 */
	public void validate( CreateExcAC5ACommand excAC5A )throws Exception {
		Assert.notNull( excAC5A, "CreateExcAC5ACommand should not be null" );
//		Assert.isNull( excAC5A.getExcAC5AId(), "CreateExcAC5ACommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcAC5A
	 */
	public void validate( UpdateExcAC5ACommand excAC5A ) throws Exception {
		Assert.notNull( excAC5A, "UpdateExcAC5ACommand should not be null" );
		Assert.notNull( excAC5A.getExcAC5AId(), "UpdateExcAC5ACommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcAC5A
	 */
    public void validate( DeleteExcAC5ACommand excAC5A ) throws Exception {
		Assert.notNull( excAC5A, "{commandAlias} should not be null" );
		Assert.notNull( excAC5A.getExcAC5AId(), "DeleteExcAC5ACommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcAC5A
	 */
	public void validate( ExcAC5AFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcAC5AFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcAC5AId(), "ExcAC5AFetchOneSummary identifier should not be null" );
	}



}
