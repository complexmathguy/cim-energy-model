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

public class ExcIEEEAC8BValidator {
		
	/**
	 * default constructor
	 */
	protected ExcIEEEAC8BValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcIEEEAC8BValidator getInstance() {
		return new ExcIEEEAC8BValidator();
	}
		
	/**
	 * handles creation validation for a ExcIEEEAC8B
	 */
	public void validate( CreateExcIEEEAC8BCommand excIEEEAC8B )throws Exception {
		Assert.notNull( excIEEEAC8B, "CreateExcIEEEAC8BCommand should not be null" );
//		Assert.isNull( excIEEEAC8B.getExcIEEEAC8BId(), "CreateExcIEEEAC8BCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcIEEEAC8B
	 */
	public void validate( UpdateExcIEEEAC8BCommand excIEEEAC8B ) throws Exception {
		Assert.notNull( excIEEEAC8B, "UpdateExcIEEEAC8BCommand should not be null" );
		Assert.notNull( excIEEEAC8B.getExcIEEEAC8BId(), "UpdateExcIEEEAC8BCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcIEEEAC8B
	 */
    public void validate( DeleteExcIEEEAC8BCommand excIEEEAC8B ) throws Exception {
		Assert.notNull( excIEEEAC8B, "{commandAlias} should not be null" );
		Assert.notNull( excIEEEAC8B.getExcIEEEAC8BId(), "DeleteExcIEEEAC8BCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcIEEEAC8B
	 */
	public void validate( ExcIEEEAC8BFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcIEEEAC8BFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcIEEEAC8BId(), "ExcIEEEAC8BFetchOneSummary identifier should not be null" );
	}



}
