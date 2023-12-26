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

public class ShuntCompensatorValidator {
		
	/**
	 * default constructor
	 */
	protected ShuntCompensatorValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ShuntCompensatorValidator getInstance() {
		return new ShuntCompensatorValidator();
	}
		
	/**
	 * handles creation validation for a ShuntCompensator
	 */
	public void validate( CreateShuntCompensatorCommand shuntCompensator )throws Exception {
		Assert.notNull( shuntCompensator, "CreateShuntCompensatorCommand should not be null" );
//		Assert.isNull( shuntCompensator.getShuntCompensatorId(), "CreateShuntCompensatorCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ShuntCompensator
	 */
	public void validate( UpdateShuntCompensatorCommand shuntCompensator ) throws Exception {
		Assert.notNull( shuntCompensator, "UpdateShuntCompensatorCommand should not be null" );
		Assert.notNull( shuntCompensator.getShuntCompensatorId(), "UpdateShuntCompensatorCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ShuntCompensator
	 */
    public void validate( DeleteShuntCompensatorCommand shuntCompensator ) throws Exception {
		Assert.notNull( shuntCompensator, "{commandAlias} should not be null" );
		Assert.notNull( shuntCompensator.getShuntCompensatorId(), "DeleteShuntCompensatorCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ShuntCompensator
	 */
	public void validate( ShuntCompensatorFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ShuntCompensatorFetchOneSummary should not be null" );
		Assert.notNull( summary.getShuntCompensatorId(), "ShuntCompensatorFetchOneSummary identifier should not be null" );
	}



}
