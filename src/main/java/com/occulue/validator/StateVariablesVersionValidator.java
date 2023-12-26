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

public class StateVariablesVersionValidator {
		
	/**
	 * default constructor
	 */
	protected StateVariablesVersionValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public StateVariablesVersionValidator getInstance() {
		return new StateVariablesVersionValidator();
	}
		
	/**
	 * handles creation validation for a StateVariablesVersion
	 */
	public void validate( CreateStateVariablesVersionCommand stateVariablesVersion )throws Exception {
		Assert.notNull( stateVariablesVersion, "CreateStateVariablesVersionCommand should not be null" );
//		Assert.isNull( stateVariablesVersion.getStateVariablesVersionId(), "CreateStateVariablesVersionCommand identifier should be null" );
	}

	/**
	 * handles update validation for a StateVariablesVersion
	 */
	public void validate( UpdateStateVariablesVersionCommand stateVariablesVersion ) throws Exception {
		Assert.notNull( stateVariablesVersion, "UpdateStateVariablesVersionCommand should not be null" );
		Assert.notNull( stateVariablesVersion.getStateVariablesVersionId(), "UpdateStateVariablesVersionCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a StateVariablesVersion
	 */
    public void validate( DeleteStateVariablesVersionCommand stateVariablesVersion ) throws Exception {
		Assert.notNull( stateVariablesVersion, "{commandAlias} should not be null" );
		Assert.notNull( stateVariablesVersion.getStateVariablesVersionId(), "DeleteStateVariablesVersionCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a StateVariablesVersion
	 */
	public void validate( StateVariablesVersionFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "StateVariablesVersionFetchOneSummary should not be null" );
		Assert.notNull( summary.getStateVariablesVersionId(), "StateVariablesVersionFetchOneSummary identifier should not be null" );
	}



}
