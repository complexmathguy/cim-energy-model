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

public class AsynchronousMachineDynamicsValidator {
		
	/**
	 * default constructor
	 */
	protected AsynchronousMachineDynamicsValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public AsynchronousMachineDynamicsValidator getInstance() {
		return new AsynchronousMachineDynamicsValidator();
	}
		
	/**
	 * handles creation validation for a AsynchronousMachineDynamics
	 */
	public void validate( CreateAsynchronousMachineDynamicsCommand asynchronousMachineDynamics )throws Exception {
		Assert.notNull( asynchronousMachineDynamics, "CreateAsynchronousMachineDynamicsCommand should not be null" );
//		Assert.isNull( asynchronousMachineDynamics.getAsynchronousMachineDynamicsId(), "CreateAsynchronousMachineDynamicsCommand identifier should be null" );
	}

	/**
	 * handles update validation for a AsynchronousMachineDynamics
	 */
	public void validate( UpdateAsynchronousMachineDynamicsCommand asynchronousMachineDynamics ) throws Exception {
		Assert.notNull( asynchronousMachineDynamics, "UpdateAsynchronousMachineDynamicsCommand should not be null" );
		Assert.notNull( asynchronousMachineDynamics.getAsynchronousMachineDynamicsId(), "UpdateAsynchronousMachineDynamicsCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a AsynchronousMachineDynamics
	 */
    public void validate( DeleteAsynchronousMachineDynamicsCommand asynchronousMachineDynamics ) throws Exception {
		Assert.notNull( asynchronousMachineDynamics, "{commandAlias} should not be null" );
		Assert.notNull( asynchronousMachineDynamics.getAsynchronousMachineDynamicsId(), "DeleteAsynchronousMachineDynamicsCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a AsynchronousMachineDynamics
	 */
	public void validate( AsynchronousMachineDynamicsFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "AsynchronousMachineDynamicsFetchOneSummary should not be null" );
		Assert.notNull( summary.getAsynchronousMachineDynamicsId(), "AsynchronousMachineDynamicsFetchOneSummary identifier should not be null" );
	}



}
