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

public class LoadMotorValidator {
		
	/**
	 * default constructor
	 */
	protected LoadMotorValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public LoadMotorValidator getInstance() {
		return new LoadMotorValidator();
	}
		
	/**
	 * handles creation validation for a LoadMotor
	 */
	public void validate( CreateLoadMotorCommand loadMotor )throws Exception {
		Assert.notNull( loadMotor, "CreateLoadMotorCommand should not be null" );
//		Assert.isNull( loadMotor.getLoadMotorId(), "CreateLoadMotorCommand identifier should be null" );
	}

	/**
	 * handles update validation for a LoadMotor
	 */
	public void validate( UpdateLoadMotorCommand loadMotor ) throws Exception {
		Assert.notNull( loadMotor, "UpdateLoadMotorCommand should not be null" );
		Assert.notNull( loadMotor.getLoadMotorId(), "UpdateLoadMotorCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a LoadMotor
	 */
    public void validate( DeleteLoadMotorCommand loadMotor ) throws Exception {
		Assert.notNull( loadMotor, "{commandAlias} should not be null" );
		Assert.notNull( loadMotor.getLoadMotorId(), "DeleteLoadMotorCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a LoadMotor
	 */
	public void validate( LoadMotorFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "LoadMotorFetchOneSummary should not be null" );
		Assert.notNull( summary.getLoadMotorId(), "LoadMotorFetchOneSummary identifier should not be null" );
	}



}
