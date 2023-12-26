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

public class VoltageCompensatorDynamicsValidator {
		
	/**
	 * default constructor
	 */
	protected VoltageCompensatorDynamicsValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public VoltageCompensatorDynamicsValidator getInstance() {
		return new VoltageCompensatorDynamicsValidator();
	}
		
	/**
	 * handles creation validation for a VoltageCompensatorDynamics
	 */
	public void validate( CreateVoltageCompensatorDynamicsCommand voltageCompensatorDynamics )throws Exception {
		Assert.notNull( voltageCompensatorDynamics, "CreateVoltageCompensatorDynamicsCommand should not be null" );
//		Assert.isNull( voltageCompensatorDynamics.getVoltageCompensatorDynamicsId(), "CreateVoltageCompensatorDynamicsCommand identifier should be null" );
	}

	/**
	 * handles update validation for a VoltageCompensatorDynamics
	 */
	public void validate( UpdateVoltageCompensatorDynamicsCommand voltageCompensatorDynamics ) throws Exception {
		Assert.notNull( voltageCompensatorDynamics, "UpdateVoltageCompensatorDynamicsCommand should not be null" );
		Assert.notNull( voltageCompensatorDynamics.getVoltageCompensatorDynamicsId(), "UpdateVoltageCompensatorDynamicsCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a VoltageCompensatorDynamics
	 */
    public void validate( DeleteVoltageCompensatorDynamicsCommand voltageCompensatorDynamics ) throws Exception {
		Assert.notNull( voltageCompensatorDynamics, "{commandAlias} should not be null" );
		Assert.notNull( voltageCompensatorDynamics.getVoltageCompensatorDynamicsId(), "DeleteVoltageCompensatorDynamicsCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a VoltageCompensatorDynamics
	 */
	public void validate( VoltageCompensatorDynamicsFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "VoltageCompensatorDynamicsFetchOneSummary should not be null" );
		Assert.notNull( summary.getVoltageCompensatorDynamicsId(), "VoltageCompensatorDynamicsFetchOneSummary identifier should not be null" );
	}



}
