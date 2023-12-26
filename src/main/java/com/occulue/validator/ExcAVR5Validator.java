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

public class ExcAVR5Validator {
		
	/**
	 * default constructor
	 */
	protected ExcAVR5Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcAVR5Validator getInstance() {
		return new ExcAVR5Validator();
	}
		
	/**
	 * handles creation validation for a ExcAVR5
	 */
	public void validate( CreateExcAVR5Command excAVR5 )throws Exception {
		Assert.notNull( excAVR5, "CreateExcAVR5Command should not be null" );
//		Assert.isNull( excAVR5.getExcAVR5Id(), "CreateExcAVR5Command identifier should be null" );
	}

	/**
	 * handles update validation for a ExcAVR5
	 */
	public void validate( UpdateExcAVR5Command excAVR5 ) throws Exception {
		Assert.notNull( excAVR5, "UpdateExcAVR5Command should not be null" );
		Assert.notNull( excAVR5.getExcAVR5Id(), "UpdateExcAVR5Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcAVR5
	 */
    public void validate( DeleteExcAVR5Command excAVR5 ) throws Exception {
		Assert.notNull( excAVR5, "{commandAlias} should not be null" );
		Assert.notNull( excAVR5.getExcAVR5Id(), "DeleteExcAVR5Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcAVR5
	 */
	public void validate( ExcAVR5FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcAVR5FetchOneSummary should not be null" );
		Assert.notNull( summary.getExcAVR5Id(), "ExcAVR5FetchOneSummary identifier should not be null" );
	}



}
