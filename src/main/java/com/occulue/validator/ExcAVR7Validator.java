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

public class ExcAVR7Validator {
		
	/**
	 * default constructor
	 */
	protected ExcAVR7Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcAVR7Validator getInstance() {
		return new ExcAVR7Validator();
	}
		
	/**
	 * handles creation validation for a ExcAVR7
	 */
	public void validate( CreateExcAVR7Command excAVR7 )throws Exception {
		Assert.notNull( excAVR7, "CreateExcAVR7Command should not be null" );
//		Assert.isNull( excAVR7.getExcAVR7Id(), "CreateExcAVR7Command identifier should be null" );
	}

	/**
	 * handles update validation for a ExcAVR7
	 */
	public void validate( UpdateExcAVR7Command excAVR7 ) throws Exception {
		Assert.notNull( excAVR7, "UpdateExcAVR7Command should not be null" );
		Assert.notNull( excAVR7.getExcAVR7Id(), "UpdateExcAVR7Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcAVR7
	 */
    public void validate( DeleteExcAVR7Command excAVR7 ) throws Exception {
		Assert.notNull( excAVR7, "{commandAlias} should not be null" );
		Assert.notNull( excAVR7.getExcAVR7Id(), "DeleteExcAVR7Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcAVR7
	 */
	public void validate( ExcAVR7FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcAVR7FetchOneSummary should not be null" );
		Assert.notNull( summary.getExcAVR7Id(), "ExcAVR7FetchOneSummary identifier should not be null" );
	}



}
