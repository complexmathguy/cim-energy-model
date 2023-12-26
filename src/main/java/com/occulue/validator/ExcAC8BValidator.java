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

public class ExcAC8BValidator {
		
	/**
	 * default constructor
	 */
	protected ExcAC8BValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcAC8BValidator getInstance() {
		return new ExcAC8BValidator();
	}
		
	/**
	 * handles creation validation for a ExcAC8B
	 */
	public void validate( CreateExcAC8BCommand excAC8B )throws Exception {
		Assert.notNull( excAC8B, "CreateExcAC8BCommand should not be null" );
//		Assert.isNull( excAC8B.getExcAC8BId(), "CreateExcAC8BCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcAC8B
	 */
	public void validate( UpdateExcAC8BCommand excAC8B ) throws Exception {
		Assert.notNull( excAC8B, "UpdateExcAC8BCommand should not be null" );
		Assert.notNull( excAC8B.getExcAC8BId(), "UpdateExcAC8BCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcAC8B
	 */
    public void validate( DeleteExcAC8BCommand excAC8B ) throws Exception {
		Assert.notNull( excAC8B, "{commandAlias} should not be null" );
		Assert.notNull( excAC8B.getExcAC8BId(), "DeleteExcAC8BCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcAC8B
	 */
	public void validate( ExcAC8BFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcAC8BFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcAC8BId(), "ExcAC8BFetchOneSummary identifier should not be null" );
	}



}
