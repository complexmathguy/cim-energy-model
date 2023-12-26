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

public class ExcIEEEAC6AValidator {
		
	/**
	 * default constructor
	 */
	protected ExcIEEEAC6AValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcIEEEAC6AValidator getInstance() {
		return new ExcIEEEAC6AValidator();
	}
		
	/**
	 * handles creation validation for a ExcIEEEAC6A
	 */
	public void validate( CreateExcIEEEAC6ACommand excIEEEAC6A )throws Exception {
		Assert.notNull( excIEEEAC6A, "CreateExcIEEEAC6ACommand should not be null" );
//		Assert.isNull( excIEEEAC6A.getExcIEEEAC6AId(), "CreateExcIEEEAC6ACommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcIEEEAC6A
	 */
	public void validate( UpdateExcIEEEAC6ACommand excIEEEAC6A ) throws Exception {
		Assert.notNull( excIEEEAC6A, "UpdateExcIEEEAC6ACommand should not be null" );
		Assert.notNull( excIEEEAC6A.getExcIEEEAC6AId(), "UpdateExcIEEEAC6ACommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcIEEEAC6A
	 */
    public void validate( DeleteExcIEEEAC6ACommand excIEEEAC6A ) throws Exception {
		Assert.notNull( excIEEEAC6A, "{commandAlias} should not be null" );
		Assert.notNull( excIEEEAC6A.getExcIEEEAC6AId(), "DeleteExcIEEEAC6ACommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcIEEEAC6A
	 */
	public void validate( ExcIEEEAC6AFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcIEEEAC6AFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcIEEEAC6AId(), "ExcIEEEAC6AFetchOneSummary identifier should not be null" );
	}



}
