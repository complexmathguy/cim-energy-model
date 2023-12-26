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

public class ProprietaryParameterDynamicsValidator {
		
	/**
	 * default constructor
	 */
	protected ProprietaryParameterDynamicsValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ProprietaryParameterDynamicsValidator getInstance() {
		return new ProprietaryParameterDynamicsValidator();
	}
		
	/**
	 * handles creation validation for a ProprietaryParameterDynamics
	 */
	public void validate( CreateProprietaryParameterDynamicsCommand proprietaryParameterDynamics )throws Exception {
		Assert.notNull( proprietaryParameterDynamics, "CreateProprietaryParameterDynamicsCommand should not be null" );
//		Assert.isNull( proprietaryParameterDynamics.getProprietaryParameterDynamicsId(), "CreateProprietaryParameterDynamicsCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ProprietaryParameterDynamics
	 */
	public void validate( UpdateProprietaryParameterDynamicsCommand proprietaryParameterDynamics ) throws Exception {
		Assert.notNull( proprietaryParameterDynamics, "UpdateProprietaryParameterDynamicsCommand should not be null" );
		Assert.notNull( proprietaryParameterDynamics.getProprietaryParameterDynamicsId(), "UpdateProprietaryParameterDynamicsCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ProprietaryParameterDynamics
	 */
    public void validate( DeleteProprietaryParameterDynamicsCommand proprietaryParameterDynamics ) throws Exception {
		Assert.notNull( proprietaryParameterDynamics, "{commandAlias} should not be null" );
		Assert.notNull( proprietaryParameterDynamics.getProprietaryParameterDynamicsId(), "DeleteProprietaryParameterDynamicsCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ProprietaryParameterDynamics
	 */
	public void validate( ProprietaryParameterDynamicsFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ProprietaryParameterDynamicsFetchOneSummary should not be null" );
		Assert.notNull( summary.getProprietaryParameterDynamicsId(), "ProprietaryParameterDynamicsFetchOneSummary identifier should not be null" );
	}



}
