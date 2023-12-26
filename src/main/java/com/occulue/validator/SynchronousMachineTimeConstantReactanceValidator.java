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

public class SynchronousMachineTimeConstantReactanceValidator {
		
	/**
	 * default constructor
	 */
	protected SynchronousMachineTimeConstantReactanceValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public SynchronousMachineTimeConstantReactanceValidator getInstance() {
		return new SynchronousMachineTimeConstantReactanceValidator();
	}
		
	/**
	 * handles creation validation for a SynchronousMachineTimeConstantReactance
	 */
	public void validate( CreateSynchronousMachineTimeConstantReactanceCommand synchronousMachineTimeConstantReactance )throws Exception {
		Assert.notNull( synchronousMachineTimeConstantReactance, "CreateSynchronousMachineTimeConstantReactanceCommand should not be null" );
//		Assert.isNull( synchronousMachineTimeConstantReactance.getSynchronousMachineTimeConstantReactanceId(), "CreateSynchronousMachineTimeConstantReactanceCommand identifier should be null" );
	}

	/**
	 * handles update validation for a SynchronousMachineTimeConstantReactance
	 */
	public void validate( UpdateSynchronousMachineTimeConstantReactanceCommand synchronousMachineTimeConstantReactance ) throws Exception {
		Assert.notNull( synchronousMachineTimeConstantReactance, "UpdateSynchronousMachineTimeConstantReactanceCommand should not be null" );
		Assert.notNull( synchronousMachineTimeConstantReactance.getSynchronousMachineTimeConstantReactanceId(), "UpdateSynchronousMachineTimeConstantReactanceCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a SynchronousMachineTimeConstantReactance
	 */
    public void validate( DeleteSynchronousMachineTimeConstantReactanceCommand synchronousMachineTimeConstantReactance ) throws Exception {
		Assert.notNull( synchronousMachineTimeConstantReactance, "{commandAlias} should not be null" );
		Assert.notNull( synchronousMachineTimeConstantReactance.getSynchronousMachineTimeConstantReactanceId(), "DeleteSynchronousMachineTimeConstantReactanceCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a SynchronousMachineTimeConstantReactance
	 */
	public void validate( SynchronousMachineTimeConstantReactanceFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "SynchronousMachineTimeConstantReactanceFetchOneSummary should not be null" );
		Assert.notNull( summary.getSynchronousMachineTimeConstantReactanceId(), "SynchronousMachineTimeConstantReactanceFetchOneSummary identifier should not be null" );
	}



}
