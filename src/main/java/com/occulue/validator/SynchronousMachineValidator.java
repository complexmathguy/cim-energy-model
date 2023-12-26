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

public class SynchronousMachineValidator {
		
	/**
	 * default constructor
	 */
	protected SynchronousMachineValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public SynchronousMachineValidator getInstance() {
		return new SynchronousMachineValidator();
	}
		
	/**
	 * handles creation validation for a SynchronousMachine
	 */
	public void validate( CreateSynchronousMachineCommand synchronousMachine )throws Exception {
		Assert.notNull( synchronousMachine, "CreateSynchronousMachineCommand should not be null" );
//		Assert.isNull( synchronousMachine.getSynchronousMachineId(), "CreateSynchronousMachineCommand identifier should be null" );
	}

	/**
	 * handles update validation for a SynchronousMachine
	 */
	public void validate( UpdateSynchronousMachineCommand synchronousMachine ) throws Exception {
		Assert.notNull( synchronousMachine, "UpdateSynchronousMachineCommand should not be null" );
		Assert.notNull( synchronousMachine.getSynchronousMachineId(), "UpdateSynchronousMachineCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a SynchronousMachine
	 */
    public void validate( DeleteSynchronousMachineCommand synchronousMachine ) throws Exception {
		Assert.notNull( synchronousMachine, "{commandAlias} should not be null" );
		Assert.notNull( synchronousMachine.getSynchronousMachineId(), "DeleteSynchronousMachineCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a SynchronousMachine
	 */
	public void validate( SynchronousMachineFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "SynchronousMachineFetchOneSummary should not be null" );
		Assert.notNull( summary.getSynchronousMachineId(), "SynchronousMachineFetchOneSummary identifier should not be null" );
	}



}
