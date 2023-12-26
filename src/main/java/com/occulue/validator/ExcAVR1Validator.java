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

public class ExcAVR1Validator {
		
	/**
	 * default constructor
	 */
	protected ExcAVR1Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcAVR1Validator getInstance() {
		return new ExcAVR1Validator();
	}
		
	/**
	 * handles creation validation for a ExcAVR1
	 */
	public void validate( CreateExcAVR1Command excAVR1 )throws Exception {
		Assert.notNull( excAVR1, "CreateExcAVR1Command should not be null" );
//		Assert.isNull( excAVR1.getExcAVR1Id(), "CreateExcAVR1Command identifier should be null" );
	}

	/**
	 * handles update validation for a ExcAVR1
	 */
	public void validate( UpdateExcAVR1Command excAVR1 ) throws Exception {
		Assert.notNull( excAVR1, "UpdateExcAVR1Command should not be null" );
		Assert.notNull( excAVR1.getExcAVR1Id(), "UpdateExcAVR1Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcAVR1
	 */
    public void validate( DeleteExcAVR1Command excAVR1 ) throws Exception {
		Assert.notNull( excAVR1, "{commandAlias} should not be null" );
		Assert.notNull( excAVR1.getExcAVR1Id(), "DeleteExcAVR1Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcAVR1
	 */
	public void validate( ExcAVR1FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcAVR1FetchOneSummary should not be null" );
		Assert.notNull( summary.getExcAVR1Id(), "ExcAVR1FetchOneSummary identifier should not be null" );
	}



}
