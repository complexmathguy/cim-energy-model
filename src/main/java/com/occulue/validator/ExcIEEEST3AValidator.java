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

public class ExcIEEEST3AValidator {
		
	/**
	 * default constructor
	 */
	protected ExcIEEEST3AValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcIEEEST3AValidator getInstance() {
		return new ExcIEEEST3AValidator();
	}
		
	/**
	 * handles creation validation for a ExcIEEEST3A
	 */
	public void validate( CreateExcIEEEST3ACommand excIEEEST3A )throws Exception {
		Assert.notNull( excIEEEST3A, "CreateExcIEEEST3ACommand should not be null" );
//		Assert.isNull( excIEEEST3A.getExcIEEEST3AId(), "CreateExcIEEEST3ACommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcIEEEST3A
	 */
	public void validate( UpdateExcIEEEST3ACommand excIEEEST3A ) throws Exception {
		Assert.notNull( excIEEEST3A, "UpdateExcIEEEST3ACommand should not be null" );
		Assert.notNull( excIEEEST3A.getExcIEEEST3AId(), "UpdateExcIEEEST3ACommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcIEEEST3A
	 */
    public void validate( DeleteExcIEEEST3ACommand excIEEEST3A ) throws Exception {
		Assert.notNull( excIEEEST3A, "{commandAlias} should not be null" );
		Assert.notNull( excIEEEST3A.getExcIEEEST3AId(), "DeleteExcIEEEST3ACommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcIEEEST3A
	 */
	public void validate( ExcIEEEST3AFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcIEEEST3AFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcIEEEST3AId(), "ExcIEEEST3AFetchOneSummary identifier should not be null" );
	}



}
