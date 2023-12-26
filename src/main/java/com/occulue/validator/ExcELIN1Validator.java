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

public class ExcELIN1Validator {
		
	/**
	 * default constructor
	 */
	protected ExcELIN1Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcELIN1Validator getInstance() {
		return new ExcELIN1Validator();
	}
		
	/**
	 * handles creation validation for a ExcELIN1
	 */
	public void validate( CreateExcELIN1Command excELIN1 )throws Exception {
		Assert.notNull( excELIN1, "CreateExcELIN1Command should not be null" );
//		Assert.isNull( excELIN1.getExcELIN1Id(), "CreateExcELIN1Command identifier should be null" );
	}

	/**
	 * handles update validation for a ExcELIN1
	 */
	public void validate( UpdateExcELIN1Command excELIN1 ) throws Exception {
		Assert.notNull( excELIN1, "UpdateExcELIN1Command should not be null" );
		Assert.notNull( excELIN1.getExcELIN1Id(), "UpdateExcELIN1Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcELIN1
	 */
    public void validate( DeleteExcELIN1Command excELIN1 ) throws Exception {
		Assert.notNull( excELIN1, "{commandAlias} should not be null" );
		Assert.notNull( excELIN1.getExcELIN1Id(), "DeleteExcELIN1Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcELIN1
	 */
	public void validate( ExcELIN1FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcELIN1FetchOneSummary should not be null" );
		Assert.notNull( summary.getExcELIN1Id(), "ExcELIN1FetchOneSummary identifier should not be null" );
	}



}
