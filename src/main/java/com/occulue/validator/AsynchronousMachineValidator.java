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

public class AsynchronousMachineValidator {
		
	/**
	 * default constructor
	 */
	protected AsynchronousMachineValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public AsynchronousMachineValidator getInstance() {
		return new AsynchronousMachineValidator();
	}
		
	/**
	 * handles creation validation for a AsynchronousMachine
	 */
	public void validate( CreateAsynchronousMachineCommand asynchronousMachine )throws Exception {
		Assert.notNull( asynchronousMachine, "CreateAsynchronousMachineCommand should not be null" );
//		Assert.isNull( asynchronousMachine.getAsynchronousMachineId(), "CreateAsynchronousMachineCommand identifier should be null" );
	}

	/**
	 * handles update validation for a AsynchronousMachine
	 */
	public void validate( UpdateAsynchronousMachineCommand asynchronousMachine ) throws Exception {
		Assert.notNull( asynchronousMachine, "UpdateAsynchronousMachineCommand should not be null" );
		Assert.notNull( asynchronousMachine.getAsynchronousMachineId(), "UpdateAsynchronousMachineCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a AsynchronousMachine
	 */
    public void validate( DeleteAsynchronousMachineCommand asynchronousMachine ) throws Exception {
		Assert.notNull( asynchronousMachine, "{commandAlias} should not be null" );
		Assert.notNull( asynchronousMachine.getAsynchronousMachineId(), "DeleteAsynchronousMachineCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a AsynchronousMachine
	 */
	public void validate( AsynchronousMachineFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "AsynchronousMachineFetchOneSummary should not be null" );
		Assert.notNull( summary.getAsynchronousMachineId(), "AsynchronousMachineFetchOneSummary identifier should not be null" );
	}



}
