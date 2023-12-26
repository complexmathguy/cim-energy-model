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

public class AsynchronousMachineEquivalentCircuitValidator {
		
	/**
	 * default constructor
	 */
	protected AsynchronousMachineEquivalentCircuitValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public AsynchronousMachineEquivalentCircuitValidator getInstance() {
		return new AsynchronousMachineEquivalentCircuitValidator();
	}
		
	/**
	 * handles creation validation for a AsynchronousMachineEquivalentCircuit
	 */
	public void validate( CreateAsynchronousMachineEquivalentCircuitCommand asynchronousMachineEquivalentCircuit )throws Exception {
		Assert.notNull( asynchronousMachineEquivalentCircuit, "CreateAsynchronousMachineEquivalentCircuitCommand should not be null" );
//		Assert.isNull( asynchronousMachineEquivalentCircuit.getAsynchronousMachineEquivalentCircuitId(), "CreateAsynchronousMachineEquivalentCircuitCommand identifier should be null" );
	}

	/**
	 * handles update validation for a AsynchronousMachineEquivalentCircuit
	 */
	public void validate( UpdateAsynchronousMachineEquivalentCircuitCommand asynchronousMachineEquivalentCircuit ) throws Exception {
		Assert.notNull( asynchronousMachineEquivalentCircuit, "UpdateAsynchronousMachineEquivalentCircuitCommand should not be null" );
		Assert.notNull( asynchronousMachineEquivalentCircuit.getAsynchronousMachineEquivalentCircuitId(), "UpdateAsynchronousMachineEquivalentCircuitCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a AsynchronousMachineEquivalentCircuit
	 */
    public void validate( DeleteAsynchronousMachineEquivalentCircuitCommand asynchronousMachineEquivalentCircuit ) throws Exception {
		Assert.notNull( asynchronousMachineEquivalentCircuit, "{commandAlias} should not be null" );
		Assert.notNull( asynchronousMachineEquivalentCircuit.getAsynchronousMachineEquivalentCircuitId(), "DeleteAsynchronousMachineEquivalentCircuitCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a AsynchronousMachineEquivalentCircuit
	 */
	public void validate( AsynchronousMachineEquivalentCircuitFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "AsynchronousMachineEquivalentCircuitFetchOneSummary should not be null" );
		Assert.notNull( summary.getAsynchronousMachineEquivalentCircuitId(), "AsynchronousMachineEquivalentCircuitFetchOneSummary identifier should not be null" );
	}



}
