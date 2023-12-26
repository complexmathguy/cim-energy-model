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

public class SvPowerFlowValidator {
		
	/**
	 * default constructor
	 */
	protected SvPowerFlowValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public SvPowerFlowValidator getInstance() {
		return new SvPowerFlowValidator();
	}
		
	/**
	 * handles creation validation for a SvPowerFlow
	 */
	public void validate( CreateSvPowerFlowCommand svPowerFlow )throws Exception {
		Assert.notNull( svPowerFlow, "CreateSvPowerFlowCommand should not be null" );
//		Assert.isNull( svPowerFlow.getSvPowerFlowId(), "CreateSvPowerFlowCommand identifier should be null" );
	}

	/**
	 * handles update validation for a SvPowerFlow
	 */
	public void validate( UpdateSvPowerFlowCommand svPowerFlow ) throws Exception {
		Assert.notNull( svPowerFlow, "UpdateSvPowerFlowCommand should not be null" );
		Assert.notNull( svPowerFlow.getSvPowerFlowId(), "UpdateSvPowerFlowCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a SvPowerFlow
	 */
    public void validate( DeleteSvPowerFlowCommand svPowerFlow ) throws Exception {
		Assert.notNull( svPowerFlow, "{commandAlias} should not be null" );
		Assert.notNull( svPowerFlow.getSvPowerFlowId(), "DeleteSvPowerFlowCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a SvPowerFlow
	 */
	public void validate( SvPowerFlowFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "SvPowerFlowFetchOneSummary should not be null" );
		Assert.notNull( summary.getSvPowerFlowId(), "SvPowerFlowFetchOneSummary identifier should not be null" );
	}



}
