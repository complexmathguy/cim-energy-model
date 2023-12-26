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

public class ExcDC1AValidator {
		
	/**
	 * default constructor
	 */
	protected ExcDC1AValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcDC1AValidator getInstance() {
		return new ExcDC1AValidator();
	}
		
	/**
	 * handles creation validation for a ExcDC1A
	 */
	public void validate( CreateExcDC1ACommand excDC1A )throws Exception {
		Assert.notNull( excDC1A, "CreateExcDC1ACommand should not be null" );
//		Assert.isNull( excDC1A.getExcDC1AId(), "CreateExcDC1ACommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcDC1A
	 */
	public void validate( UpdateExcDC1ACommand excDC1A ) throws Exception {
		Assert.notNull( excDC1A, "UpdateExcDC1ACommand should not be null" );
		Assert.notNull( excDC1A.getExcDC1AId(), "UpdateExcDC1ACommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcDC1A
	 */
    public void validate( DeleteExcDC1ACommand excDC1A ) throws Exception {
		Assert.notNull( excDC1A, "{commandAlias} should not be null" );
		Assert.notNull( excDC1A.getExcDC1AId(), "DeleteExcDC1ACommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcDC1A
	 */
	public void validate( ExcDC1AFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcDC1AFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcDC1AId(), "ExcDC1AFetchOneSummary identifier should not be null" );
	}



}
