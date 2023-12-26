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

public class ExcIEEEST5BValidator {
		
	/**
	 * default constructor
	 */
	protected ExcIEEEST5BValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcIEEEST5BValidator getInstance() {
		return new ExcIEEEST5BValidator();
	}
		
	/**
	 * handles creation validation for a ExcIEEEST5B
	 */
	public void validate( CreateExcIEEEST5BCommand excIEEEST5B )throws Exception {
		Assert.notNull( excIEEEST5B, "CreateExcIEEEST5BCommand should not be null" );
//		Assert.isNull( excIEEEST5B.getExcIEEEST5BId(), "CreateExcIEEEST5BCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcIEEEST5B
	 */
	public void validate( UpdateExcIEEEST5BCommand excIEEEST5B ) throws Exception {
		Assert.notNull( excIEEEST5B, "UpdateExcIEEEST5BCommand should not be null" );
		Assert.notNull( excIEEEST5B.getExcIEEEST5BId(), "UpdateExcIEEEST5BCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcIEEEST5B
	 */
    public void validate( DeleteExcIEEEST5BCommand excIEEEST5B ) throws Exception {
		Assert.notNull( excIEEEST5B, "{commandAlias} should not be null" );
		Assert.notNull( excIEEEST5B.getExcIEEEST5BId(), "DeleteExcIEEEST5BCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcIEEEST5B
	 */
	public void validate( ExcIEEEST5BFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcIEEEST5BFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcIEEEST5BId(), "ExcIEEEST5BFetchOneSummary identifier should not be null" );
	}



}
