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

public class DiscontinuousExcitationControlDynamicsValidator {
		
	/**
	 * default constructor
	 */
	protected DiscontinuousExcitationControlDynamicsValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public DiscontinuousExcitationControlDynamicsValidator getInstance() {
		return new DiscontinuousExcitationControlDynamicsValidator();
	}
		
	/**
	 * handles creation validation for a DiscontinuousExcitationControlDynamics
	 */
	public void validate( CreateDiscontinuousExcitationControlDynamicsCommand discontinuousExcitationControlDynamics )throws Exception {
		Assert.notNull( discontinuousExcitationControlDynamics, "CreateDiscontinuousExcitationControlDynamicsCommand should not be null" );
//		Assert.isNull( discontinuousExcitationControlDynamics.getDiscontinuousExcitationControlDynamicsId(), "CreateDiscontinuousExcitationControlDynamicsCommand identifier should be null" );
	}

	/**
	 * handles update validation for a DiscontinuousExcitationControlDynamics
	 */
	public void validate( UpdateDiscontinuousExcitationControlDynamicsCommand discontinuousExcitationControlDynamics ) throws Exception {
		Assert.notNull( discontinuousExcitationControlDynamics, "UpdateDiscontinuousExcitationControlDynamicsCommand should not be null" );
		Assert.notNull( discontinuousExcitationControlDynamics.getDiscontinuousExcitationControlDynamicsId(), "UpdateDiscontinuousExcitationControlDynamicsCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a DiscontinuousExcitationControlDynamics
	 */
    public void validate( DeleteDiscontinuousExcitationControlDynamicsCommand discontinuousExcitationControlDynamics ) throws Exception {
		Assert.notNull( discontinuousExcitationControlDynamics, "{commandAlias} should not be null" );
		Assert.notNull( discontinuousExcitationControlDynamics.getDiscontinuousExcitationControlDynamicsId(), "DeleteDiscontinuousExcitationControlDynamicsCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a DiscontinuousExcitationControlDynamics
	 */
	public void validate( DiscontinuousExcitationControlDynamicsFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "DiscontinuousExcitationControlDynamicsFetchOneSummary should not be null" );
		Assert.notNull( summary.getDiscontinuousExcitationControlDynamicsId(), "DiscontinuousExcitationControlDynamicsFetchOneSummary identifier should not be null" );
	}



}
