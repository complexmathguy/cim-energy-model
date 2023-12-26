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

public class ExcELIN2Validator {
		
	/**
	 * default constructor
	 */
	protected ExcELIN2Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcELIN2Validator getInstance() {
		return new ExcELIN2Validator();
	}
		
	/**
	 * handles creation validation for a ExcELIN2
	 */
	public void validate( CreateExcELIN2Command excELIN2 )throws Exception {
		Assert.notNull( excELIN2, "CreateExcELIN2Command should not be null" );
//		Assert.isNull( excELIN2.getExcELIN2Id(), "CreateExcELIN2Command identifier should be null" );
	}

	/**
	 * handles update validation for a ExcELIN2
	 */
	public void validate( UpdateExcELIN2Command excELIN2 ) throws Exception {
		Assert.notNull( excELIN2, "UpdateExcELIN2Command should not be null" );
		Assert.notNull( excELIN2.getExcELIN2Id(), "UpdateExcELIN2Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcELIN2
	 */
    public void validate( DeleteExcELIN2Command excELIN2 ) throws Exception {
		Assert.notNull( excELIN2, "{commandAlias} should not be null" );
		Assert.notNull( excELIN2.getExcELIN2Id(), "DeleteExcELIN2Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcELIN2
	 */
	public void validate( ExcELIN2FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcELIN2FetchOneSummary should not be null" );
		Assert.notNull( summary.getExcELIN2Id(), "ExcELIN2FetchOneSummary identifier should not be null" );
	}



}
