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

public class RotatingMachineDynamicsValidator {
		
	/**
	 * default constructor
	 */
	protected RotatingMachineDynamicsValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public RotatingMachineDynamicsValidator getInstance() {
		return new RotatingMachineDynamicsValidator();
	}
		
	/**
	 * handles creation validation for a RotatingMachineDynamics
	 */
	public void validate( CreateRotatingMachineDynamicsCommand rotatingMachineDynamics )throws Exception {
		Assert.notNull( rotatingMachineDynamics, "CreateRotatingMachineDynamicsCommand should not be null" );
//		Assert.isNull( rotatingMachineDynamics.getRotatingMachineDynamicsId(), "CreateRotatingMachineDynamicsCommand identifier should be null" );
	}

	/**
	 * handles update validation for a RotatingMachineDynamics
	 */
	public void validate( UpdateRotatingMachineDynamicsCommand rotatingMachineDynamics ) throws Exception {
		Assert.notNull( rotatingMachineDynamics, "UpdateRotatingMachineDynamicsCommand should not be null" );
		Assert.notNull( rotatingMachineDynamics.getRotatingMachineDynamicsId(), "UpdateRotatingMachineDynamicsCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a RotatingMachineDynamics
	 */
    public void validate( DeleteRotatingMachineDynamicsCommand rotatingMachineDynamics ) throws Exception {
		Assert.notNull( rotatingMachineDynamics, "{commandAlias} should not be null" );
		Assert.notNull( rotatingMachineDynamics.getRotatingMachineDynamicsId(), "DeleteRotatingMachineDynamicsCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a RotatingMachineDynamics
	 */
	public void validate( RotatingMachineDynamicsFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "RotatingMachineDynamicsFetchOneSummary should not be null" );
		Assert.notNull( summary.getRotatingMachineDynamicsId(), "RotatingMachineDynamicsFetchOneSummary identifier should not be null" );
	}



}
