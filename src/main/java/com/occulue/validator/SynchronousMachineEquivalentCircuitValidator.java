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

public class SynchronousMachineEquivalentCircuitValidator {
		
	/**
	 * default constructor
	 */
	protected SynchronousMachineEquivalentCircuitValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public SynchronousMachineEquivalentCircuitValidator getInstance() {
		return new SynchronousMachineEquivalentCircuitValidator();
	}
		
	/**
	 * handles creation validation for a SynchronousMachineEquivalentCircuit
	 */
	public void validate( CreateSynchronousMachineEquivalentCircuitCommand synchronousMachineEquivalentCircuit )throws Exception {
		Assert.notNull( synchronousMachineEquivalentCircuit, "CreateSynchronousMachineEquivalentCircuitCommand should not be null" );
//		Assert.isNull( synchronousMachineEquivalentCircuit.getSynchronousMachineEquivalentCircuitId(), "CreateSynchronousMachineEquivalentCircuitCommand identifier should be null" );
	}

	/**
	 * handles update validation for a SynchronousMachineEquivalentCircuit
	 */
	public void validate( UpdateSynchronousMachineEquivalentCircuitCommand synchronousMachineEquivalentCircuit ) throws Exception {
		Assert.notNull( synchronousMachineEquivalentCircuit, "UpdateSynchronousMachineEquivalentCircuitCommand should not be null" );
		Assert.notNull( synchronousMachineEquivalentCircuit.getSynchronousMachineEquivalentCircuitId(), "UpdateSynchronousMachineEquivalentCircuitCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a SynchronousMachineEquivalentCircuit
	 */
    public void validate( DeleteSynchronousMachineEquivalentCircuitCommand synchronousMachineEquivalentCircuit ) throws Exception {
		Assert.notNull( synchronousMachineEquivalentCircuit, "{commandAlias} should not be null" );
		Assert.notNull( synchronousMachineEquivalentCircuit.getSynchronousMachineEquivalentCircuitId(), "DeleteSynchronousMachineEquivalentCircuitCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a SynchronousMachineEquivalentCircuit
	 */
	public void validate( SynchronousMachineEquivalentCircuitFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "SynchronousMachineEquivalentCircuitFetchOneSummary should not be null" );
		Assert.notNull( summary.getSynchronousMachineEquivalentCircuitId(), "SynchronousMachineEquivalentCircuitFetchOneSummary identifier should not be null" );
	}



}
