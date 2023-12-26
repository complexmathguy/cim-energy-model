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

public class ExcAC6AValidator {
		
	/**
	 * default constructor
	 */
	protected ExcAC6AValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcAC6AValidator getInstance() {
		return new ExcAC6AValidator();
	}
		
	/**
	 * handles creation validation for a ExcAC6A
	 */
	public void validate( CreateExcAC6ACommand excAC6A )throws Exception {
		Assert.notNull( excAC6A, "CreateExcAC6ACommand should not be null" );
//		Assert.isNull( excAC6A.getExcAC6AId(), "CreateExcAC6ACommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcAC6A
	 */
	public void validate( UpdateExcAC6ACommand excAC6A ) throws Exception {
		Assert.notNull( excAC6A, "UpdateExcAC6ACommand should not be null" );
		Assert.notNull( excAC6A.getExcAC6AId(), "UpdateExcAC6ACommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcAC6A
	 */
    public void validate( DeleteExcAC6ACommand excAC6A ) throws Exception {
		Assert.notNull( excAC6A, "{commandAlias} should not be null" );
		Assert.notNull( excAC6A.getExcAC6AId(), "DeleteExcAC6ACommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcAC6A
	 */
	public void validate( ExcAC6AFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcAC6AFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcAC6AId(), "ExcAC6AFetchOneSummary identifier should not be null" );
	}



}
