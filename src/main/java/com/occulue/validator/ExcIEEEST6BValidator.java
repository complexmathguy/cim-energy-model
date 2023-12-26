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

public class ExcIEEEST6BValidator {
		
	/**
	 * default constructor
	 */
	protected ExcIEEEST6BValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcIEEEST6BValidator getInstance() {
		return new ExcIEEEST6BValidator();
	}
		
	/**
	 * handles creation validation for a ExcIEEEST6B
	 */
	public void validate( CreateExcIEEEST6BCommand excIEEEST6B )throws Exception {
		Assert.notNull( excIEEEST6B, "CreateExcIEEEST6BCommand should not be null" );
//		Assert.isNull( excIEEEST6B.getExcIEEEST6BId(), "CreateExcIEEEST6BCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcIEEEST6B
	 */
	public void validate( UpdateExcIEEEST6BCommand excIEEEST6B ) throws Exception {
		Assert.notNull( excIEEEST6B, "UpdateExcIEEEST6BCommand should not be null" );
		Assert.notNull( excIEEEST6B.getExcIEEEST6BId(), "UpdateExcIEEEST6BCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcIEEEST6B
	 */
    public void validate( DeleteExcIEEEST6BCommand excIEEEST6B ) throws Exception {
		Assert.notNull( excIEEEST6B, "{commandAlias} should not be null" );
		Assert.notNull( excIEEEST6B.getExcIEEEST6BId(), "DeleteExcIEEEST6BCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcIEEEST6B
	 */
	public void validate( ExcIEEEST6BFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcIEEEST6BFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcIEEEST6BId(), "ExcIEEEST6BFetchOneSummary identifier should not be null" );
	}



}
