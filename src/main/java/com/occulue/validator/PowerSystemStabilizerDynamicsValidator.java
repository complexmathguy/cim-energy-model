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

public class PowerSystemStabilizerDynamicsValidator {
		
	/**
	 * default constructor
	 */
	protected PowerSystemStabilizerDynamicsValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public PowerSystemStabilizerDynamicsValidator getInstance() {
		return new PowerSystemStabilizerDynamicsValidator();
	}
		
	/**
	 * handles creation validation for a PowerSystemStabilizerDynamics
	 */
	public void validate( CreatePowerSystemStabilizerDynamicsCommand powerSystemStabilizerDynamics )throws Exception {
		Assert.notNull( powerSystemStabilizerDynamics, "CreatePowerSystemStabilizerDynamicsCommand should not be null" );
//		Assert.isNull( powerSystemStabilizerDynamics.getPowerSystemStabilizerDynamicsId(), "CreatePowerSystemStabilizerDynamicsCommand identifier should be null" );
	}

	/**
	 * handles update validation for a PowerSystemStabilizerDynamics
	 */
	public void validate( UpdatePowerSystemStabilizerDynamicsCommand powerSystemStabilizerDynamics ) throws Exception {
		Assert.notNull( powerSystemStabilizerDynamics, "UpdatePowerSystemStabilizerDynamicsCommand should not be null" );
		Assert.notNull( powerSystemStabilizerDynamics.getPowerSystemStabilizerDynamicsId(), "UpdatePowerSystemStabilizerDynamicsCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a PowerSystemStabilizerDynamics
	 */
    public void validate( DeletePowerSystemStabilizerDynamicsCommand powerSystemStabilizerDynamics ) throws Exception {
		Assert.notNull( powerSystemStabilizerDynamics, "{commandAlias} should not be null" );
		Assert.notNull( powerSystemStabilizerDynamics.getPowerSystemStabilizerDynamicsId(), "DeletePowerSystemStabilizerDynamicsCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a PowerSystemStabilizerDynamics
	 */
	public void validate( PowerSystemStabilizerDynamicsFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "PowerSystemStabilizerDynamicsFetchOneSummary should not be null" );
		Assert.notNull( summary.getPowerSystemStabilizerDynamicsId(), "PowerSystemStabilizerDynamicsFetchOneSummary identifier should not be null" );
	}



}
