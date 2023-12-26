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

public class WindTurbineType3or4DynamicsValidator {
		
	/**
	 * default constructor
	 */
	protected WindTurbineType3or4DynamicsValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public WindTurbineType3or4DynamicsValidator getInstance() {
		return new WindTurbineType3or4DynamicsValidator();
	}
		
	/**
	 * handles creation validation for a WindTurbineType3or4Dynamics
	 */
	public void validate( CreateWindTurbineType3or4DynamicsCommand windTurbineType3or4Dynamics )throws Exception {
		Assert.notNull( windTurbineType3or4Dynamics, "CreateWindTurbineType3or4DynamicsCommand should not be null" );
//		Assert.isNull( windTurbineType3or4Dynamics.getWindTurbineType3or4DynamicsId(), "CreateWindTurbineType3or4DynamicsCommand identifier should be null" );
	}

	/**
	 * handles update validation for a WindTurbineType3or4Dynamics
	 */
	public void validate( UpdateWindTurbineType3or4DynamicsCommand windTurbineType3or4Dynamics ) throws Exception {
		Assert.notNull( windTurbineType3or4Dynamics, "UpdateWindTurbineType3or4DynamicsCommand should not be null" );
		Assert.notNull( windTurbineType3or4Dynamics.getWindTurbineType3or4DynamicsId(), "UpdateWindTurbineType3or4DynamicsCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a WindTurbineType3or4Dynamics
	 */
    public void validate( DeleteWindTurbineType3or4DynamicsCommand windTurbineType3or4Dynamics ) throws Exception {
		Assert.notNull( windTurbineType3or4Dynamics, "{commandAlias} should not be null" );
		Assert.notNull( windTurbineType3or4Dynamics.getWindTurbineType3or4DynamicsId(), "DeleteWindTurbineType3or4DynamicsCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a WindTurbineType3or4Dynamics
	 */
	public void validate( WindTurbineType3or4DynamicsFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "WindTurbineType3or4DynamicsFetchOneSummary should not be null" );
		Assert.notNull( summary.getWindTurbineType3or4DynamicsId(), "WindTurbineType3or4DynamicsFetchOneSummary identifier should not be null" );
	}



}
