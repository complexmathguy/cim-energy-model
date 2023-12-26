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

public class ExcAC4AValidator {
		
	/**
	 * default constructor
	 */
	protected ExcAC4AValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcAC4AValidator getInstance() {
		return new ExcAC4AValidator();
	}
		
	/**
	 * handles creation validation for a ExcAC4A
	 */
	public void validate( CreateExcAC4ACommand excAC4A )throws Exception {
		Assert.notNull( excAC4A, "CreateExcAC4ACommand should not be null" );
//		Assert.isNull( excAC4A.getExcAC4AId(), "CreateExcAC4ACommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcAC4A
	 */
	public void validate( UpdateExcAC4ACommand excAC4A ) throws Exception {
		Assert.notNull( excAC4A, "UpdateExcAC4ACommand should not be null" );
		Assert.notNull( excAC4A.getExcAC4AId(), "UpdateExcAC4ACommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcAC4A
	 */
    public void validate( DeleteExcAC4ACommand excAC4A ) throws Exception {
		Assert.notNull( excAC4A, "{commandAlias} should not be null" );
		Assert.notNull( excAC4A.getExcAC4AId(), "DeleteExcAC4ACommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcAC4A
	 */
	public void validate( ExcAC4AFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcAC4AFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcAC4AId(), "ExcAC4AFetchOneSummary identifier should not be null" );
	}



}
