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

public class WindTurbineType1or2DynamicsValidator {
		
	/**
	 * default constructor
	 */
	protected WindTurbineType1or2DynamicsValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public WindTurbineType1or2DynamicsValidator getInstance() {
		return new WindTurbineType1or2DynamicsValidator();
	}
		
	/**
	 * handles creation validation for a WindTurbineType1or2Dynamics
	 */
	public void validate( CreateWindTurbineType1or2DynamicsCommand windTurbineType1or2Dynamics )throws Exception {
		Assert.notNull( windTurbineType1or2Dynamics, "CreateWindTurbineType1or2DynamicsCommand should not be null" );
//		Assert.isNull( windTurbineType1or2Dynamics.getWindTurbineType1or2DynamicsId(), "CreateWindTurbineType1or2DynamicsCommand identifier should be null" );
	}

	/**
	 * handles update validation for a WindTurbineType1or2Dynamics
	 */
	public void validate( UpdateWindTurbineType1or2DynamicsCommand windTurbineType1or2Dynamics ) throws Exception {
		Assert.notNull( windTurbineType1or2Dynamics, "UpdateWindTurbineType1or2DynamicsCommand should not be null" );
		Assert.notNull( windTurbineType1or2Dynamics.getWindTurbineType1or2DynamicsId(), "UpdateWindTurbineType1or2DynamicsCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a WindTurbineType1or2Dynamics
	 */
    public void validate( DeleteWindTurbineType1or2DynamicsCommand windTurbineType1or2Dynamics ) throws Exception {
		Assert.notNull( windTurbineType1or2Dynamics, "{commandAlias} should not be null" );
		Assert.notNull( windTurbineType1or2Dynamics.getWindTurbineType1or2DynamicsId(), "DeleteWindTurbineType1or2DynamicsCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a WindTurbineType1or2Dynamics
	 */
	public void validate( WindTurbineType1or2DynamicsFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "WindTurbineType1or2DynamicsFetchOneSummary should not be null" );
		Assert.notNull( summary.getWindTurbineType1or2DynamicsId(), "WindTurbineType1or2DynamicsFetchOneSummary identifier should not be null" );
	}



}
