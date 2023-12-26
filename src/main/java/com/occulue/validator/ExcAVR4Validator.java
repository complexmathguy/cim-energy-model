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

public class ExcAVR4Validator {
		
	/**
	 * default constructor
	 */
	protected ExcAVR4Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcAVR4Validator getInstance() {
		return new ExcAVR4Validator();
	}
		
	/**
	 * handles creation validation for a ExcAVR4
	 */
	public void validate( CreateExcAVR4Command excAVR4 )throws Exception {
		Assert.notNull( excAVR4, "CreateExcAVR4Command should not be null" );
//		Assert.isNull( excAVR4.getExcAVR4Id(), "CreateExcAVR4Command identifier should be null" );
	}

	/**
	 * handles update validation for a ExcAVR4
	 */
	public void validate( UpdateExcAVR4Command excAVR4 ) throws Exception {
		Assert.notNull( excAVR4, "UpdateExcAVR4Command should not be null" );
		Assert.notNull( excAVR4.getExcAVR4Id(), "UpdateExcAVR4Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcAVR4
	 */
    public void validate( DeleteExcAVR4Command excAVR4 ) throws Exception {
		Assert.notNull( excAVR4, "{commandAlias} should not be null" );
		Assert.notNull( excAVR4.getExcAVR4Id(), "DeleteExcAVR4Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcAVR4
	 */
	public void validate( ExcAVR4FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcAVR4FetchOneSummary should not be null" );
		Assert.notNull( summary.getExcAVR4Id(), "ExcAVR4FetchOneSummary identifier should not be null" );
	}



}
