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

public class PFVArControllerType1DynamicsValidator {
		
	/**
	 * default constructor
	 */
	protected PFVArControllerType1DynamicsValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public PFVArControllerType1DynamicsValidator getInstance() {
		return new PFVArControllerType1DynamicsValidator();
	}
		
	/**
	 * handles creation validation for a PFVArControllerType1Dynamics
	 */
	public void validate( CreatePFVArControllerType1DynamicsCommand pFVArControllerType1Dynamics )throws Exception {
		Assert.notNull( pFVArControllerType1Dynamics, "CreatePFVArControllerType1DynamicsCommand should not be null" );
//		Assert.isNull( pFVArControllerType1Dynamics.getPFVArControllerType1DynamicsId(), "CreatePFVArControllerType1DynamicsCommand identifier should be null" );
	}

	/**
	 * handles update validation for a PFVArControllerType1Dynamics
	 */
	public void validate( UpdatePFVArControllerType1DynamicsCommand pFVArControllerType1Dynamics ) throws Exception {
		Assert.notNull( pFVArControllerType1Dynamics, "UpdatePFVArControllerType1DynamicsCommand should not be null" );
		Assert.notNull( pFVArControllerType1Dynamics.getPFVArControllerType1DynamicsId(), "UpdatePFVArControllerType1DynamicsCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a PFVArControllerType1Dynamics
	 */
    public void validate( DeletePFVArControllerType1DynamicsCommand pFVArControllerType1Dynamics ) throws Exception {
		Assert.notNull( pFVArControllerType1Dynamics, "{commandAlias} should not be null" );
		Assert.notNull( pFVArControllerType1Dynamics.getPFVArControllerType1DynamicsId(), "DeletePFVArControllerType1DynamicsCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a PFVArControllerType1Dynamics
	 */
	public void validate( PFVArControllerType1DynamicsFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "PFVArControllerType1DynamicsFetchOneSummary should not be null" );
		Assert.notNull( summary.getPFVArControllerType1DynamicsId(), "PFVArControllerType1DynamicsFetchOneSummary identifier should not be null" );
	}



}
