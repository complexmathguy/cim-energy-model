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

public class LengthValidator {
		
	/**
	 * default constructor
	 */
	protected LengthValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public LengthValidator getInstance() {
		return new LengthValidator();
	}
		
	/**
	 * handles creation validation for a Length
	 */
	public void validate( CreateLengthCommand length )throws Exception {
		Assert.notNull( length, "CreateLengthCommand should not be null" );
//		Assert.isNull( length.getLengthId(), "CreateLengthCommand identifier should be null" );
	}

	/**
	 * handles update validation for a Length
	 */
	public void validate( UpdateLengthCommand length ) throws Exception {
		Assert.notNull( length, "UpdateLengthCommand should not be null" );
		Assert.notNull( length.getLengthId(), "UpdateLengthCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a Length
	 */
    public void validate( DeleteLengthCommand length ) throws Exception {
		Assert.notNull( length, "{commandAlias} should not be null" );
		Assert.notNull( length.getLengthId(), "DeleteLengthCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a Length
	 */
	public void validate( LengthFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "LengthFetchOneSummary should not be null" );
		Assert.notNull( summary.getLengthId(), "LengthFetchOneSummary identifier should not be null" );
	}



}
