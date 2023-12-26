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

public class ExcDC3A1Validator {
		
	/**
	 * default constructor
	 */
	protected ExcDC3A1Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcDC3A1Validator getInstance() {
		return new ExcDC3A1Validator();
	}
		
	/**
	 * handles creation validation for a ExcDC3A1
	 */
	public void validate( CreateExcDC3A1Command excDC3A1 )throws Exception {
		Assert.notNull( excDC3A1, "CreateExcDC3A1Command should not be null" );
//		Assert.isNull( excDC3A1.getExcDC3A1Id(), "CreateExcDC3A1Command identifier should be null" );
	}

	/**
	 * handles update validation for a ExcDC3A1
	 */
	public void validate( UpdateExcDC3A1Command excDC3A1 ) throws Exception {
		Assert.notNull( excDC3A1, "UpdateExcDC3A1Command should not be null" );
		Assert.notNull( excDC3A1.getExcDC3A1Id(), "UpdateExcDC3A1Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcDC3A1
	 */
    public void validate( DeleteExcDC3A1Command excDC3A1 ) throws Exception {
		Assert.notNull( excDC3A1, "{commandAlias} should not be null" );
		Assert.notNull( excDC3A1.getExcDC3A1Id(), "DeleteExcDC3A1Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcDC3A1
	 */
	public void validate( ExcDC3A1FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcDC3A1FetchOneSummary should not be null" );
		Assert.notNull( summary.getExcDC3A1Id(), "ExcDC3A1FetchOneSummary identifier should not be null" );
	}



}
