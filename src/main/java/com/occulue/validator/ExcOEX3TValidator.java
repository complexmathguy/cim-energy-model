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

public class ExcOEX3TValidator {
		
	/**
	 * default constructor
	 */
	protected ExcOEX3TValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcOEX3TValidator getInstance() {
		return new ExcOEX3TValidator();
	}
		
	/**
	 * handles creation validation for a ExcOEX3T
	 */
	public void validate( CreateExcOEX3TCommand excOEX3T )throws Exception {
		Assert.notNull( excOEX3T, "CreateExcOEX3TCommand should not be null" );
//		Assert.isNull( excOEX3T.getExcOEX3TId(), "CreateExcOEX3TCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcOEX3T
	 */
	public void validate( UpdateExcOEX3TCommand excOEX3T ) throws Exception {
		Assert.notNull( excOEX3T, "UpdateExcOEX3TCommand should not be null" );
		Assert.notNull( excOEX3T.getExcOEX3TId(), "UpdateExcOEX3TCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcOEX3T
	 */
    public void validate( DeleteExcOEX3TCommand excOEX3T ) throws Exception {
		Assert.notNull( excOEX3T, "{commandAlias} should not be null" );
		Assert.notNull( excOEX3T.getExcOEX3TId(), "DeleteExcOEX3TCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcOEX3T
	 */
	public void validate( ExcOEX3TFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcOEX3TFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcOEX3TId(), "ExcOEX3TFetchOneSummary identifier should not be null" );
	}



}
