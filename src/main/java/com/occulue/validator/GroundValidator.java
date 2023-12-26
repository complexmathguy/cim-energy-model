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

public class GroundValidator {
		
	/**
	 * default constructor
	 */
	protected GroundValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public GroundValidator getInstance() {
		return new GroundValidator();
	}
		
	/**
	 * handles creation validation for a Ground
	 */
	public void validate( CreateGroundCommand ground )throws Exception {
		Assert.notNull( ground, "CreateGroundCommand should not be null" );
//		Assert.isNull( ground.getGroundId(), "CreateGroundCommand identifier should be null" );
	}

	/**
	 * handles update validation for a Ground
	 */
	public void validate( UpdateGroundCommand ground ) throws Exception {
		Assert.notNull( ground, "UpdateGroundCommand should not be null" );
		Assert.notNull( ground.getGroundId(), "UpdateGroundCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a Ground
	 */
    public void validate( DeleteGroundCommand ground ) throws Exception {
		Assert.notNull( ground, "{commandAlias} should not be null" );
		Assert.notNull( ground.getGroundId(), "DeleteGroundCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a Ground
	 */
	public void validate( GroundFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GroundFetchOneSummary should not be null" );
		Assert.notNull( summary.getGroundId(), "GroundFetchOneSummary identifier should not be null" );
	}



}
