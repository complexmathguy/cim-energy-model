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

public class AngleRadiansValidator {
		
	/**
	 * default constructor
	 */
	protected AngleRadiansValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public AngleRadiansValidator getInstance() {
		return new AngleRadiansValidator();
	}
		
	/**
	 * handles creation validation for a AngleRadians
	 */
	public void validate( CreateAngleRadiansCommand angleRadians )throws Exception {
		Assert.notNull( angleRadians, "CreateAngleRadiansCommand should not be null" );
//		Assert.isNull( angleRadians.getAngleRadiansId(), "CreateAngleRadiansCommand identifier should be null" );
	}

	/**
	 * handles update validation for a AngleRadians
	 */
	public void validate( UpdateAngleRadiansCommand angleRadians ) throws Exception {
		Assert.notNull( angleRadians, "UpdateAngleRadiansCommand should not be null" );
		Assert.notNull( angleRadians.getAngleRadiansId(), "UpdateAngleRadiansCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a AngleRadians
	 */
    public void validate( DeleteAngleRadiansCommand angleRadians ) throws Exception {
		Assert.notNull( angleRadians, "{commandAlias} should not be null" );
		Assert.notNull( angleRadians.getAngleRadiansId(), "DeleteAngleRadiansCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a AngleRadians
	 */
	public void validate( AngleRadiansFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "AngleRadiansFetchOneSummary should not be null" );
		Assert.notNull( summary.getAngleRadiansId(), "AngleRadiansFetchOneSummary identifier should not be null" );
	}



}
