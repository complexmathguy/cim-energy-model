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

public class ExcAC1AValidator {
		
	/**
	 * default constructor
	 */
	protected ExcAC1AValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcAC1AValidator getInstance() {
		return new ExcAC1AValidator();
	}
		
	/**
	 * handles creation validation for a ExcAC1A
	 */
	public void validate( CreateExcAC1ACommand excAC1A )throws Exception {
		Assert.notNull( excAC1A, "CreateExcAC1ACommand should not be null" );
//		Assert.isNull( excAC1A.getExcAC1AId(), "CreateExcAC1ACommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcAC1A
	 */
	public void validate( UpdateExcAC1ACommand excAC1A ) throws Exception {
		Assert.notNull( excAC1A, "UpdateExcAC1ACommand should not be null" );
		Assert.notNull( excAC1A.getExcAC1AId(), "UpdateExcAC1ACommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcAC1A
	 */
    public void validate( DeleteExcAC1ACommand excAC1A ) throws Exception {
		Assert.notNull( excAC1A, "{commandAlias} should not be null" );
		Assert.notNull( excAC1A.getExcAC1AId(), "DeleteExcAC1ACommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcAC1A
	 */
	public void validate( ExcAC1AFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcAC1AFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcAC1AId(), "ExcAC1AFetchOneSummary identifier should not be null" );
	}



}
