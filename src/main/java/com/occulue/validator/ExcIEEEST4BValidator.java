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

public class ExcIEEEST4BValidator {
		
	/**
	 * default constructor
	 */
	protected ExcIEEEST4BValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcIEEEST4BValidator getInstance() {
		return new ExcIEEEST4BValidator();
	}
		
	/**
	 * handles creation validation for a ExcIEEEST4B
	 */
	public void validate( CreateExcIEEEST4BCommand excIEEEST4B )throws Exception {
		Assert.notNull( excIEEEST4B, "CreateExcIEEEST4BCommand should not be null" );
//		Assert.isNull( excIEEEST4B.getExcIEEEST4BId(), "CreateExcIEEEST4BCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcIEEEST4B
	 */
	public void validate( UpdateExcIEEEST4BCommand excIEEEST4B ) throws Exception {
		Assert.notNull( excIEEEST4B, "UpdateExcIEEEST4BCommand should not be null" );
		Assert.notNull( excIEEEST4B.getExcIEEEST4BId(), "UpdateExcIEEEST4BCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcIEEEST4B
	 */
    public void validate( DeleteExcIEEEST4BCommand excIEEEST4B ) throws Exception {
		Assert.notNull( excIEEEST4B, "{commandAlias} should not be null" );
		Assert.notNull( excIEEEST4B.getExcIEEEST4BId(), "DeleteExcIEEEST4BCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcIEEEST4B
	 */
	public void validate( ExcIEEEST4BFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcIEEEST4BFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcIEEEST4BId(), "ExcIEEEST4BFetchOneSummary identifier should not be null" );
	}



}
