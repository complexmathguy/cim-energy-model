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

public class RotationSpeedValidator {
		
	/**
	 * default constructor
	 */
	protected RotationSpeedValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public RotationSpeedValidator getInstance() {
		return new RotationSpeedValidator();
	}
		
	/**
	 * handles creation validation for a RotationSpeed
	 */
	public void validate( CreateRotationSpeedCommand rotationSpeed )throws Exception {
		Assert.notNull( rotationSpeed, "CreateRotationSpeedCommand should not be null" );
//		Assert.isNull( rotationSpeed.getRotationSpeedId(), "CreateRotationSpeedCommand identifier should be null" );
	}

	/**
	 * handles update validation for a RotationSpeed
	 */
	public void validate( UpdateRotationSpeedCommand rotationSpeed ) throws Exception {
		Assert.notNull( rotationSpeed, "UpdateRotationSpeedCommand should not be null" );
		Assert.notNull( rotationSpeed.getRotationSpeedId(), "UpdateRotationSpeedCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a RotationSpeed
	 */
    public void validate( DeleteRotationSpeedCommand rotationSpeed ) throws Exception {
		Assert.notNull( rotationSpeed, "{commandAlias} should not be null" );
		Assert.notNull( rotationSpeed.getRotationSpeedId(), "DeleteRotationSpeedCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a RotationSpeed
	 */
	public void validate( RotationSpeedFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "RotationSpeedFetchOneSummary should not be null" );
		Assert.notNull( summary.getRotationSpeedId(), "RotationSpeedFetchOneSummary identifier should not be null" );
	}



}
