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

public class ExcAC2AValidator {
		
	/**
	 * default constructor
	 */
	protected ExcAC2AValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcAC2AValidator getInstance() {
		return new ExcAC2AValidator();
	}
		
	/**
	 * handles creation validation for a ExcAC2A
	 */
	public void validate( CreateExcAC2ACommand excAC2A )throws Exception {
		Assert.notNull( excAC2A, "CreateExcAC2ACommand should not be null" );
//		Assert.isNull( excAC2A.getExcAC2AId(), "CreateExcAC2ACommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcAC2A
	 */
	public void validate( UpdateExcAC2ACommand excAC2A ) throws Exception {
		Assert.notNull( excAC2A, "UpdateExcAC2ACommand should not be null" );
		Assert.notNull( excAC2A.getExcAC2AId(), "UpdateExcAC2ACommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcAC2A
	 */
    public void validate( DeleteExcAC2ACommand excAC2A ) throws Exception {
		Assert.notNull( excAC2A, "{commandAlias} should not be null" );
		Assert.notNull( excAC2A.getExcAC2AId(), "DeleteExcAC2ACommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcAC2A
	 */
	public void validate( ExcAC2AFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcAC2AFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcAC2AId(), "ExcAC2AFetchOneSummary identifier should not be null" );
	}



}
