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

public class ExcBBCValidator {
		
	/**
	 * default constructor
	 */
	protected ExcBBCValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcBBCValidator getInstance() {
		return new ExcBBCValidator();
	}
		
	/**
	 * handles creation validation for a ExcBBC
	 */
	public void validate( CreateExcBBCCommand excBBC )throws Exception {
		Assert.notNull( excBBC, "CreateExcBBCCommand should not be null" );
//		Assert.isNull( excBBC.getExcBBCId(), "CreateExcBBCCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcBBC
	 */
	public void validate( UpdateExcBBCCommand excBBC ) throws Exception {
		Assert.notNull( excBBC, "UpdateExcBBCCommand should not be null" );
		Assert.notNull( excBBC.getExcBBCId(), "UpdateExcBBCCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcBBC
	 */
    public void validate( DeleteExcBBCCommand excBBC ) throws Exception {
		Assert.notNull( excBBC, "{commandAlias} should not be null" );
		Assert.notNull( excBBC.getExcBBCId(), "DeleteExcBBCCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcBBC
	 */
	public void validate( ExcBBCFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcBBCFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcBBCId(), "ExcBBCFetchOneSummary identifier should not be null" );
	}



}
