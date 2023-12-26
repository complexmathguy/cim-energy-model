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

public class ExcIEEEAC7BValidator {
		
	/**
	 * default constructor
	 */
	protected ExcIEEEAC7BValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcIEEEAC7BValidator getInstance() {
		return new ExcIEEEAC7BValidator();
	}
		
	/**
	 * handles creation validation for a ExcIEEEAC7B
	 */
	public void validate( CreateExcIEEEAC7BCommand excIEEEAC7B )throws Exception {
		Assert.notNull( excIEEEAC7B, "CreateExcIEEEAC7BCommand should not be null" );
//		Assert.isNull( excIEEEAC7B.getExcIEEEAC7BId(), "CreateExcIEEEAC7BCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcIEEEAC7B
	 */
	public void validate( UpdateExcIEEEAC7BCommand excIEEEAC7B ) throws Exception {
		Assert.notNull( excIEEEAC7B, "UpdateExcIEEEAC7BCommand should not be null" );
		Assert.notNull( excIEEEAC7B.getExcIEEEAC7BId(), "UpdateExcIEEEAC7BCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcIEEEAC7B
	 */
    public void validate( DeleteExcIEEEAC7BCommand excIEEEAC7B ) throws Exception {
		Assert.notNull( excIEEEAC7B, "{commandAlias} should not be null" );
		Assert.notNull( excIEEEAC7B.getExcIEEEAC7BId(), "DeleteExcIEEEAC7BCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcIEEEAC7B
	 */
	public void validate( ExcIEEEAC7BFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcIEEEAC7BFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcIEEEAC7BId(), "ExcIEEEAC7BFetchOneSummary identifier should not be null" );
	}



}
