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

public class ExcREXSValidator {
		
	/**
	 * default constructor
	 */
	protected ExcREXSValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcREXSValidator getInstance() {
		return new ExcREXSValidator();
	}
		
	/**
	 * handles creation validation for a ExcREXS
	 */
	public void validate( CreateExcREXSCommand excREXS )throws Exception {
		Assert.notNull( excREXS, "CreateExcREXSCommand should not be null" );
//		Assert.isNull( excREXS.getExcREXSId(), "CreateExcREXSCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcREXS
	 */
	public void validate( UpdateExcREXSCommand excREXS ) throws Exception {
		Assert.notNull( excREXS, "UpdateExcREXSCommand should not be null" );
		Assert.notNull( excREXS.getExcREXSId(), "UpdateExcREXSCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcREXS
	 */
    public void validate( DeleteExcREXSCommand excREXS ) throws Exception {
		Assert.notNull( excREXS, "{commandAlias} should not be null" );
		Assert.notNull( excREXS.getExcREXSId(), "DeleteExcREXSCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcREXS
	 */
	public void validate( ExcREXSFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcREXSFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcREXSId(), "ExcREXSFetchOneSummary identifier should not be null" );
	}



}
