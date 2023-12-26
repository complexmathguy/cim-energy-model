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

public class ExcAVR2Validator {
		
	/**
	 * default constructor
	 */
	protected ExcAVR2Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcAVR2Validator getInstance() {
		return new ExcAVR2Validator();
	}
		
	/**
	 * handles creation validation for a ExcAVR2
	 */
	public void validate( CreateExcAVR2Command excAVR2 )throws Exception {
		Assert.notNull( excAVR2, "CreateExcAVR2Command should not be null" );
//		Assert.isNull( excAVR2.getExcAVR2Id(), "CreateExcAVR2Command identifier should be null" );
	}

	/**
	 * handles update validation for a ExcAVR2
	 */
	public void validate( UpdateExcAVR2Command excAVR2 ) throws Exception {
		Assert.notNull( excAVR2, "UpdateExcAVR2Command should not be null" );
		Assert.notNull( excAVR2.getExcAVR2Id(), "UpdateExcAVR2Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcAVR2
	 */
    public void validate( DeleteExcAVR2Command excAVR2 ) throws Exception {
		Assert.notNull( excAVR2, "{commandAlias} should not be null" );
		Assert.notNull( excAVR2.getExcAVR2Id(), "DeleteExcAVR2Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcAVR2
	 */
	public void validate( ExcAVR2FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcAVR2FetchOneSummary should not be null" );
		Assert.notNull( summary.getExcAVR2Id(), "ExcAVR2FetchOneSummary identifier should not be null" );
	}



}
