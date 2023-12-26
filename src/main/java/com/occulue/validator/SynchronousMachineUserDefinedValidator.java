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

public class SynchronousMachineUserDefinedValidator {
		
	/**
	 * default constructor
	 */
	protected SynchronousMachineUserDefinedValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public SynchronousMachineUserDefinedValidator getInstance() {
		return new SynchronousMachineUserDefinedValidator();
	}
		
	/**
	 * handles creation validation for a SynchronousMachineUserDefined
	 */
	public void validate( CreateSynchronousMachineUserDefinedCommand synchronousMachineUserDefined )throws Exception {
		Assert.notNull( synchronousMachineUserDefined, "CreateSynchronousMachineUserDefinedCommand should not be null" );
//		Assert.isNull( synchronousMachineUserDefined.getSynchronousMachineUserDefinedId(), "CreateSynchronousMachineUserDefinedCommand identifier should be null" );
	}

	/**
	 * handles update validation for a SynchronousMachineUserDefined
	 */
	public void validate( UpdateSynchronousMachineUserDefinedCommand synchronousMachineUserDefined ) throws Exception {
		Assert.notNull( synchronousMachineUserDefined, "UpdateSynchronousMachineUserDefinedCommand should not be null" );
		Assert.notNull( synchronousMachineUserDefined.getSynchronousMachineUserDefinedId(), "UpdateSynchronousMachineUserDefinedCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a SynchronousMachineUserDefined
	 */
    public void validate( DeleteSynchronousMachineUserDefinedCommand synchronousMachineUserDefined ) throws Exception {
		Assert.notNull( synchronousMachineUserDefined, "{commandAlias} should not be null" );
		Assert.notNull( synchronousMachineUserDefined.getSynchronousMachineUserDefinedId(), "DeleteSynchronousMachineUserDefinedCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a SynchronousMachineUserDefined
	 */
	public void validate( SynchronousMachineUserDefinedFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "SynchronousMachineUserDefinedFetchOneSummary should not be null" );
		Assert.notNull( summary.getSynchronousMachineUserDefinedId(), "SynchronousMachineUserDefinedFetchOneSummary identifier should not be null" );
	}



}
