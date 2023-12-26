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

public class OverexcitationLimiterDynamicsValidator {
		
	/**
	 * default constructor
	 */
	protected OverexcitationLimiterDynamicsValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public OverexcitationLimiterDynamicsValidator getInstance() {
		return new OverexcitationLimiterDynamicsValidator();
	}
		
	/**
	 * handles creation validation for a OverexcitationLimiterDynamics
	 */
	public void validate( CreateOverexcitationLimiterDynamicsCommand overexcitationLimiterDynamics )throws Exception {
		Assert.notNull( overexcitationLimiterDynamics, "CreateOverexcitationLimiterDynamicsCommand should not be null" );
//		Assert.isNull( overexcitationLimiterDynamics.getOverexcitationLimiterDynamicsId(), "CreateOverexcitationLimiterDynamicsCommand identifier should be null" );
	}

	/**
	 * handles update validation for a OverexcitationLimiterDynamics
	 */
	public void validate( UpdateOverexcitationLimiterDynamicsCommand overexcitationLimiterDynamics ) throws Exception {
		Assert.notNull( overexcitationLimiterDynamics, "UpdateOverexcitationLimiterDynamicsCommand should not be null" );
		Assert.notNull( overexcitationLimiterDynamics.getOverexcitationLimiterDynamicsId(), "UpdateOverexcitationLimiterDynamicsCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a OverexcitationLimiterDynamics
	 */
    public void validate( DeleteOverexcitationLimiterDynamicsCommand overexcitationLimiterDynamics ) throws Exception {
		Assert.notNull( overexcitationLimiterDynamics, "{commandAlias} should not be null" );
		Assert.notNull( overexcitationLimiterDynamics.getOverexcitationLimiterDynamicsId(), "DeleteOverexcitationLimiterDynamicsCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a OverexcitationLimiterDynamics
	 */
	public void validate( OverexcitationLimiterDynamicsFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "OverexcitationLimiterDynamicsFetchOneSummary should not be null" );
		Assert.notNull( summary.getOverexcitationLimiterDynamicsId(), "OverexcitationLimiterDynamicsFetchOneSummary identifier should not be null" );
	}



}
