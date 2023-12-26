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

public class TurbineGovernorDynamicsValidator {
		
	/**
	 * default constructor
	 */
	protected TurbineGovernorDynamicsValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public TurbineGovernorDynamicsValidator getInstance() {
		return new TurbineGovernorDynamicsValidator();
	}
		
	/**
	 * handles creation validation for a TurbineGovernorDynamics
	 */
	public void validate( CreateTurbineGovernorDynamicsCommand turbineGovernorDynamics )throws Exception {
		Assert.notNull( turbineGovernorDynamics, "CreateTurbineGovernorDynamicsCommand should not be null" );
//		Assert.isNull( turbineGovernorDynamics.getTurbineGovernorDynamicsId(), "CreateTurbineGovernorDynamicsCommand identifier should be null" );
	}

	/**
	 * handles update validation for a TurbineGovernorDynamics
	 */
	public void validate( UpdateTurbineGovernorDynamicsCommand turbineGovernorDynamics ) throws Exception {
		Assert.notNull( turbineGovernorDynamics, "UpdateTurbineGovernorDynamicsCommand should not be null" );
		Assert.notNull( turbineGovernorDynamics.getTurbineGovernorDynamicsId(), "UpdateTurbineGovernorDynamicsCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a TurbineGovernorDynamics
	 */
    public void validate( DeleteTurbineGovernorDynamicsCommand turbineGovernorDynamics ) throws Exception {
		Assert.notNull( turbineGovernorDynamics, "{commandAlias} should not be null" );
		Assert.notNull( turbineGovernorDynamics.getTurbineGovernorDynamicsId(), "DeleteTurbineGovernorDynamicsCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a TurbineGovernorDynamics
	 */
	public void validate( TurbineGovernorDynamicsFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "TurbineGovernorDynamicsFetchOneSummary should not be null" );
		Assert.notNull( summary.getTurbineGovernorDynamicsId(), "TurbineGovernorDynamicsFetchOneSummary identifier should not be null" );
	}



}
