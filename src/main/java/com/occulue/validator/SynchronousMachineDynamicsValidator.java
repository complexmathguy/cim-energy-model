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

public class SynchronousMachineDynamicsValidator {
		
	/**
	 * default constructor
	 */
	protected SynchronousMachineDynamicsValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public SynchronousMachineDynamicsValidator getInstance() {
		return new SynchronousMachineDynamicsValidator();
	}
		
	/**
	 * handles creation validation for a SynchronousMachineDynamics
	 */
	public void validate( CreateSynchronousMachineDynamicsCommand synchronousMachineDynamics )throws Exception {
		Assert.notNull( synchronousMachineDynamics, "CreateSynchronousMachineDynamicsCommand should not be null" );
//		Assert.isNull( synchronousMachineDynamics.getSynchronousMachineDynamicsId(), "CreateSynchronousMachineDynamicsCommand identifier should be null" );
	}

	/**
	 * handles update validation for a SynchronousMachineDynamics
	 */
	public void validate( UpdateSynchronousMachineDynamicsCommand synchronousMachineDynamics ) throws Exception {
		Assert.notNull( synchronousMachineDynamics, "UpdateSynchronousMachineDynamicsCommand should not be null" );
		Assert.notNull( synchronousMachineDynamics.getSynchronousMachineDynamicsId(), "UpdateSynchronousMachineDynamicsCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a SynchronousMachineDynamics
	 */
    public void validate( DeleteSynchronousMachineDynamicsCommand synchronousMachineDynamics ) throws Exception {
		Assert.notNull( synchronousMachineDynamics, "{commandAlias} should not be null" );
		Assert.notNull( synchronousMachineDynamics.getSynchronousMachineDynamicsId(), "DeleteSynchronousMachineDynamicsCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a SynchronousMachineDynamics
	 */
	public void validate( SynchronousMachineDynamicsFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "SynchronousMachineDynamicsFetchOneSummary should not be null" );
		Assert.notNull( summary.getSynchronousMachineDynamicsId(), "SynchronousMachineDynamicsFetchOneSummary identifier should not be null" );
	}



}
