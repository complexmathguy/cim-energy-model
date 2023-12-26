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

public class ExcAVR3Validator {
		
	/**
	 * default constructor
	 */
	protected ExcAVR3Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcAVR3Validator getInstance() {
		return new ExcAVR3Validator();
	}
		
	/**
	 * handles creation validation for a ExcAVR3
	 */
	public void validate( CreateExcAVR3Command excAVR3 )throws Exception {
		Assert.notNull( excAVR3, "CreateExcAVR3Command should not be null" );
//		Assert.isNull( excAVR3.getExcAVR3Id(), "CreateExcAVR3Command identifier should be null" );
	}

	/**
	 * handles update validation for a ExcAVR3
	 */
	public void validate( UpdateExcAVR3Command excAVR3 ) throws Exception {
		Assert.notNull( excAVR3, "UpdateExcAVR3Command should not be null" );
		Assert.notNull( excAVR3.getExcAVR3Id(), "UpdateExcAVR3Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcAVR3
	 */
    public void validate( DeleteExcAVR3Command excAVR3 ) throws Exception {
		Assert.notNull( excAVR3, "{commandAlias} should not be null" );
		Assert.notNull( excAVR3.getExcAVR3Id(), "DeleteExcAVR3Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcAVR3
	 */
	public void validate( ExcAVR3FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcAVR3FetchOneSummary should not be null" );
		Assert.notNull( summary.getExcAVR3Id(), "ExcAVR3FetchOneSummary identifier should not be null" );
	}



}
