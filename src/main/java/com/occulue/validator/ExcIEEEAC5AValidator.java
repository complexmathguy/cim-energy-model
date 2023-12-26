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

public class ExcIEEEAC5AValidator {
		
	/**
	 * default constructor
	 */
	protected ExcIEEEAC5AValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcIEEEAC5AValidator getInstance() {
		return new ExcIEEEAC5AValidator();
	}
		
	/**
	 * handles creation validation for a ExcIEEEAC5A
	 */
	public void validate( CreateExcIEEEAC5ACommand excIEEEAC5A )throws Exception {
		Assert.notNull( excIEEEAC5A, "CreateExcIEEEAC5ACommand should not be null" );
//		Assert.isNull( excIEEEAC5A.getExcIEEEAC5AId(), "CreateExcIEEEAC5ACommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcIEEEAC5A
	 */
	public void validate( UpdateExcIEEEAC5ACommand excIEEEAC5A ) throws Exception {
		Assert.notNull( excIEEEAC5A, "UpdateExcIEEEAC5ACommand should not be null" );
		Assert.notNull( excIEEEAC5A.getExcIEEEAC5AId(), "UpdateExcIEEEAC5ACommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcIEEEAC5A
	 */
    public void validate( DeleteExcIEEEAC5ACommand excIEEEAC5A ) throws Exception {
		Assert.notNull( excIEEEAC5A, "{commandAlias} should not be null" );
		Assert.notNull( excIEEEAC5A.getExcIEEEAC5AId(), "DeleteExcIEEEAC5ACommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcIEEEAC5A
	 */
	public void validate( ExcIEEEAC5AFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcIEEEAC5AFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcIEEEAC5AId(), "ExcIEEEAC5AFetchOneSummary identifier should not be null" );
	}



}
