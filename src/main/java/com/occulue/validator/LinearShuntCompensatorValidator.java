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

public class LinearShuntCompensatorValidator {
		
	/**
	 * default constructor
	 */
	protected LinearShuntCompensatorValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public LinearShuntCompensatorValidator getInstance() {
		return new LinearShuntCompensatorValidator();
	}
		
	/**
	 * handles creation validation for a LinearShuntCompensator
	 */
	public void validate( CreateLinearShuntCompensatorCommand linearShuntCompensator )throws Exception {
		Assert.notNull( linearShuntCompensator, "CreateLinearShuntCompensatorCommand should not be null" );
//		Assert.isNull( linearShuntCompensator.getLinearShuntCompensatorId(), "CreateLinearShuntCompensatorCommand identifier should be null" );
	}

	/**
	 * handles update validation for a LinearShuntCompensator
	 */
	public void validate( UpdateLinearShuntCompensatorCommand linearShuntCompensator ) throws Exception {
		Assert.notNull( linearShuntCompensator, "UpdateLinearShuntCompensatorCommand should not be null" );
		Assert.notNull( linearShuntCompensator.getLinearShuntCompensatorId(), "UpdateLinearShuntCompensatorCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a LinearShuntCompensator
	 */
    public void validate( DeleteLinearShuntCompensatorCommand linearShuntCompensator ) throws Exception {
		Assert.notNull( linearShuntCompensator, "{commandAlias} should not be null" );
		Assert.notNull( linearShuntCompensator.getLinearShuntCompensatorId(), "DeleteLinearShuntCompensatorCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a LinearShuntCompensator
	 */
	public void validate( LinearShuntCompensatorFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "LinearShuntCompensatorFetchOneSummary should not be null" );
		Assert.notNull( summary.getLinearShuntCompensatorId(), "LinearShuntCompensatorFetchOneSummary identifier should not be null" );
	}



}
