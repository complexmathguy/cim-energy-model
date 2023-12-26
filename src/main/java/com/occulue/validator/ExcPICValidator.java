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

public class ExcPICValidator {
		
	/**
	 * default constructor
	 */
	protected ExcPICValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcPICValidator getInstance() {
		return new ExcPICValidator();
	}
		
	/**
	 * handles creation validation for a ExcPIC
	 */
	public void validate( CreateExcPICCommand excPIC )throws Exception {
		Assert.notNull( excPIC, "CreateExcPICCommand should not be null" );
//		Assert.isNull( excPIC.getExcPICId(), "CreateExcPICCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcPIC
	 */
	public void validate( UpdateExcPICCommand excPIC ) throws Exception {
		Assert.notNull( excPIC, "UpdateExcPICCommand should not be null" );
		Assert.notNull( excPIC.getExcPICId(), "UpdateExcPICCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcPIC
	 */
    public void validate( DeleteExcPICCommand excPIC ) throws Exception {
		Assert.notNull( excPIC, "{commandAlias} should not be null" );
		Assert.notNull( excPIC.getExcPICId(), "DeleteExcPICCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcPIC
	 */
	public void validate( ExcPICFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcPICFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcPICId(), "ExcPICFetchOneSummary identifier should not be null" );
	}



}
