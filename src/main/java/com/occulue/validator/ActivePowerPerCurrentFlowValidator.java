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

public class ActivePowerPerCurrentFlowValidator {
		
	/**
	 * default constructor
	 */
	protected ActivePowerPerCurrentFlowValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ActivePowerPerCurrentFlowValidator getInstance() {
		return new ActivePowerPerCurrentFlowValidator();
	}
		
	/**
	 * handles creation validation for a ActivePowerPerCurrentFlow
	 */
	public void validate( CreateActivePowerPerCurrentFlowCommand activePowerPerCurrentFlow )throws Exception {
		Assert.notNull( activePowerPerCurrentFlow, "CreateActivePowerPerCurrentFlowCommand should not be null" );
//		Assert.isNull( activePowerPerCurrentFlow.getActivePowerPerCurrentFlowId(), "CreateActivePowerPerCurrentFlowCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ActivePowerPerCurrentFlow
	 */
	public void validate( UpdateActivePowerPerCurrentFlowCommand activePowerPerCurrentFlow ) throws Exception {
		Assert.notNull( activePowerPerCurrentFlow, "UpdateActivePowerPerCurrentFlowCommand should not be null" );
		Assert.notNull( activePowerPerCurrentFlow.getActivePowerPerCurrentFlowId(), "UpdateActivePowerPerCurrentFlowCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ActivePowerPerCurrentFlow
	 */
    public void validate( DeleteActivePowerPerCurrentFlowCommand activePowerPerCurrentFlow ) throws Exception {
		Assert.notNull( activePowerPerCurrentFlow, "{commandAlias} should not be null" );
		Assert.notNull( activePowerPerCurrentFlow.getActivePowerPerCurrentFlowId(), "DeleteActivePowerPerCurrentFlowCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ActivePowerPerCurrentFlow
	 */
	public void validate( ActivePowerPerCurrentFlowFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ActivePowerPerCurrentFlowFetchOneSummary should not be null" );
		Assert.notNull( summary.getActivePowerPerCurrentFlowId(), "ActivePowerPerCurrentFlowFetchOneSummary identifier should not be null" );
	}



}
