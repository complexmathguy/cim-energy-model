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

public class ActivePowerValidator {
		
	/**
	 * default constructor
	 */
	protected ActivePowerValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ActivePowerValidator getInstance() {
		return new ActivePowerValidator();
	}
		
	/**
	 * handles creation validation for a ActivePower
	 */
	public void validate( CreateActivePowerCommand activePower )throws Exception {
		Assert.notNull( activePower, "CreateActivePowerCommand should not be null" );
//		Assert.isNull( activePower.getActivePowerId(), "CreateActivePowerCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ActivePower
	 */
	public void validate( UpdateActivePowerCommand activePower ) throws Exception {
		Assert.notNull( activePower, "UpdateActivePowerCommand should not be null" );
		Assert.notNull( activePower.getActivePowerId(), "UpdateActivePowerCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ActivePower
	 */
    public void validate( DeleteActivePowerCommand activePower ) throws Exception {
		Assert.notNull( activePower, "{commandAlias} should not be null" );
		Assert.notNull( activePower.getActivePowerId(), "DeleteActivePowerCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ActivePower
	 */
	public void validate( ActivePowerFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ActivePowerFetchOneSummary should not be null" );
		Assert.notNull( summary.getActivePowerId(), "ActivePowerFetchOneSummary identifier should not be null" );
	}



}
