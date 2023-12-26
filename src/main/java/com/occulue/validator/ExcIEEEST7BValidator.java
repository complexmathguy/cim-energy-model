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

public class ExcIEEEST7BValidator {
		
	/**
	 * default constructor
	 */
	protected ExcIEEEST7BValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcIEEEST7BValidator getInstance() {
		return new ExcIEEEST7BValidator();
	}
		
	/**
	 * handles creation validation for a ExcIEEEST7B
	 */
	public void validate( CreateExcIEEEST7BCommand excIEEEST7B )throws Exception {
		Assert.notNull( excIEEEST7B, "CreateExcIEEEST7BCommand should not be null" );
//		Assert.isNull( excIEEEST7B.getExcIEEEST7BId(), "CreateExcIEEEST7BCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcIEEEST7B
	 */
	public void validate( UpdateExcIEEEST7BCommand excIEEEST7B ) throws Exception {
		Assert.notNull( excIEEEST7B, "UpdateExcIEEEST7BCommand should not be null" );
		Assert.notNull( excIEEEST7B.getExcIEEEST7BId(), "UpdateExcIEEEST7BCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcIEEEST7B
	 */
    public void validate( DeleteExcIEEEST7BCommand excIEEEST7B ) throws Exception {
		Assert.notNull( excIEEEST7B, "{commandAlias} should not be null" );
		Assert.notNull( excIEEEST7B.getExcIEEEST7BId(), "DeleteExcIEEEST7BCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcIEEEST7B
	 */
	public void validate( ExcIEEEST7BFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcIEEEST7BFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcIEEEST7BId(), "ExcIEEEST7BFetchOneSummary identifier should not be null" );
	}



}
