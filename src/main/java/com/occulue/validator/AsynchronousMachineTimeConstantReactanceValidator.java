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

public class AsynchronousMachineTimeConstantReactanceValidator {
		
	/**
	 * default constructor
	 */
	protected AsynchronousMachineTimeConstantReactanceValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public AsynchronousMachineTimeConstantReactanceValidator getInstance() {
		return new AsynchronousMachineTimeConstantReactanceValidator();
	}
		
	/**
	 * handles creation validation for a AsynchronousMachineTimeConstantReactance
	 */
	public void validate( CreateAsynchronousMachineTimeConstantReactanceCommand asynchronousMachineTimeConstantReactance )throws Exception {
		Assert.notNull( asynchronousMachineTimeConstantReactance, "CreateAsynchronousMachineTimeConstantReactanceCommand should not be null" );
//		Assert.isNull( asynchronousMachineTimeConstantReactance.getAsynchronousMachineTimeConstantReactanceId(), "CreateAsynchronousMachineTimeConstantReactanceCommand identifier should be null" );
	}

	/**
	 * handles update validation for a AsynchronousMachineTimeConstantReactance
	 */
	public void validate( UpdateAsynchronousMachineTimeConstantReactanceCommand asynchronousMachineTimeConstantReactance ) throws Exception {
		Assert.notNull( asynchronousMachineTimeConstantReactance, "UpdateAsynchronousMachineTimeConstantReactanceCommand should not be null" );
		Assert.notNull( asynchronousMachineTimeConstantReactance.getAsynchronousMachineTimeConstantReactanceId(), "UpdateAsynchronousMachineTimeConstantReactanceCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a AsynchronousMachineTimeConstantReactance
	 */
    public void validate( DeleteAsynchronousMachineTimeConstantReactanceCommand asynchronousMachineTimeConstantReactance ) throws Exception {
		Assert.notNull( asynchronousMachineTimeConstantReactance, "{commandAlias} should not be null" );
		Assert.notNull( asynchronousMachineTimeConstantReactance.getAsynchronousMachineTimeConstantReactanceId(), "DeleteAsynchronousMachineTimeConstantReactanceCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a AsynchronousMachineTimeConstantReactance
	 */
	public void validate( AsynchronousMachineTimeConstantReactanceFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "AsynchronousMachineTimeConstantReactanceFetchOneSummary should not be null" );
		Assert.notNull( summary.getAsynchronousMachineTimeConstantReactanceId(), "AsynchronousMachineTimeConstantReactanceFetchOneSummary identifier should not be null" );
	}



}
