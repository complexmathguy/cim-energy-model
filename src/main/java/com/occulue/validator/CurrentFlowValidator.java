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

public class CurrentFlowValidator {
		
	/**
	 * default constructor
	 */
	protected CurrentFlowValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public CurrentFlowValidator getInstance() {
		return new CurrentFlowValidator();
	}
		
	/**
	 * handles creation validation for a CurrentFlow
	 */
	public void validate( CreateCurrentFlowCommand currentFlow )throws Exception {
		Assert.notNull( currentFlow, "CreateCurrentFlowCommand should not be null" );
//		Assert.isNull( currentFlow.getCurrentFlowId(), "CreateCurrentFlowCommand identifier should be null" );
	}

	/**
	 * handles update validation for a CurrentFlow
	 */
	public void validate( UpdateCurrentFlowCommand currentFlow ) throws Exception {
		Assert.notNull( currentFlow, "UpdateCurrentFlowCommand should not be null" );
		Assert.notNull( currentFlow.getCurrentFlowId(), "UpdateCurrentFlowCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a CurrentFlow
	 */
    public void validate( DeleteCurrentFlowCommand currentFlow ) throws Exception {
		Assert.notNull( currentFlow, "{commandAlias} should not be null" );
		Assert.notNull( currentFlow.getCurrentFlowId(), "DeleteCurrentFlowCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a CurrentFlow
	 */
	public void validate( CurrentFlowFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "CurrentFlowFetchOneSummary should not be null" );
		Assert.notNull( summary.getCurrentFlowId(), "CurrentFlowFetchOneSummary identifier should not be null" );
	}



}
