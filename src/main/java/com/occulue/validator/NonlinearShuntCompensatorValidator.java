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

public class NonlinearShuntCompensatorValidator {
		
	/**
	 * default constructor
	 */
	protected NonlinearShuntCompensatorValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public NonlinearShuntCompensatorValidator getInstance() {
		return new NonlinearShuntCompensatorValidator();
	}
		
	/**
	 * handles creation validation for a NonlinearShuntCompensator
	 */
	public void validate( CreateNonlinearShuntCompensatorCommand nonlinearShuntCompensator )throws Exception {
		Assert.notNull( nonlinearShuntCompensator, "CreateNonlinearShuntCompensatorCommand should not be null" );
//		Assert.isNull( nonlinearShuntCompensator.getNonlinearShuntCompensatorId(), "CreateNonlinearShuntCompensatorCommand identifier should be null" );
	}

	/**
	 * handles update validation for a NonlinearShuntCompensator
	 */
	public void validate( UpdateNonlinearShuntCompensatorCommand nonlinearShuntCompensator ) throws Exception {
		Assert.notNull( nonlinearShuntCompensator, "UpdateNonlinearShuntCompensatorCommand should not be null" );
		Assert.notNull( nonlinearShuntCompensator.getNonlinearShuntCompensatorId(), "UpdateNonlinearShuntCompensatorCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a NonlinearShuntCompensator
	 */
    public void validate( DeleteNonlinearShuntCompensatorCommand nonlinearShuntCompensator ) throws Exception {
		Assert.notNull( nonlinearShuntCompensator, "{commandAlias} should not be null" );
		Assert.notNull( nonlinearShuntCompensator.getNonlinearShuntCompensatorId(), "DeleteNonlinearShuntCompensatorCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a NonlinearShuntCompensator
	 */
	public void validate( NonlinearShuntCompensatorFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "NonlinearShuntCompensatorFetchOneSummary should not be null" );
		Assert.notNull( summary.getNonlinearShuntCompensatorId(), "NonlinearShuntCompensatorFetchOneSummary identifier should not be null" );
	}



}
