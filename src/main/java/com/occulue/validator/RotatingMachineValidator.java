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

public class RotatingMachineValidator {
		
	/**
	 * default constructor
	 */
	protected RotatingMachineValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public RotatingMachineValidator getInstance() {
		return new RotatingMachineValidator();
	}
		
	/**
	 * handles creation validation for a RotatingMachine
	 */
	public void validate( CreateRotatingMachineCommand rotatingMachine )throws Exception {
		Assert.notNull( rotatingMachine, "CreateRotatingMachineCommand should not be null" );
//		Assert.isNull( rotatingMachine.getRotatingMachineId(), "CreateRotatingMachineCommand identifier should be null" );
	}

	/**
	 * handles update validation for a RotatingMachine
	 */
	public void validate( UpdateRotatingMachineCommand rotatingMachine ) throws Exception {
		Assert.notNull( rotatingMachine, "UpdateRotatingMachineCommand should not be null" );
		Assert.notNull( rotatingMachine.getRotatingMachineId(), "UpdateRotatingMachineCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a RotatingMachine
	 */
    public void validate( DeleteRotatingMachineCommand rotatingMachine ) throws Exception {
		Assert.notNull( rotatingMachine, "{commandAlias} should not be null" );
		Assert.notNull( rotatingMachine.getRotatingMachineId(), "DeleteRotatingMachineCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a RotatingMachine
	 */
	public void validate( RotatingMachineFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "RotatingMachineFetchOneSummary should not be null" );
		Assert.notNull( summary.getRotatingMachineId(), "RotatingMachineFetchOneSummary identifier should not be null" );
	}



}
