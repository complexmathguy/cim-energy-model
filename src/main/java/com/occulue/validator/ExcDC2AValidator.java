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

public class ExcDC2AValidator {
		
	/**
	 * default constructor
	 */
	protected ExcDC2AValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcDC2AValidator getInstance() {
		return new ExcDC2AValidator();
	}
		
	/**
	 * handles creation validation for a ExcDC2A
	 */
	public void validate( CreateExcDC2ACommand excDC2A )throws Exception {
		Assert.notNull( excDC2A, "CreateExcDC2ACommand should not be null" );
//		Assert.isNull( excDC2A.getExcDC2AId(), "CreateExcDC2ACommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcDC2A
	 */
	public void validate( UpdateExcDC2ACommand excDC2A ) throws Exception {
		Assert.notNull( excDC2A, "UpdateExcDC2ACommand should not be null" );
		Assert.notNull( excDC2A.getExcDC2AId(), "UpdateExcDC2ACommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcDC2A
	 */
    public void validate( DeleteExcDC2ACommand excDC2A ) throws Exception {
		Assert.notNull( excDC2A, "{commandAlias} should not be null" );
		Assert.notNull( excDC2A.getExcDC2AId(), "DeleteExcDC2ACommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcDC2A
	 */
	public void validate( ExcDC2AFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcDC2AFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcDC2AId(), "ExcDC2AFetchOneSummary identifier should not be null" );
	}



}
