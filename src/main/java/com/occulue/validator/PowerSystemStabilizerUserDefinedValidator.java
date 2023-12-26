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

public class PowerSystemStabilizerUserDefinedValidator {
		
	/**
	 * default constructor
	 */
	protected PowerSystemStabilizerUserDefinedValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public PowerSystemStabilizerUserDefinedValidator getInstance() {
		return new PowerSystemStabilizerUserDefinedValidator();
	}
		
	/**
	 * handles creation validation for a PowerSystemStabilizerUserDefined
	 */
	public void validate( CreatePowerSystemStabilizerUserDefinedCommand powerSystemStabilizerUserDefined )throws Exception {
		Assert.notNull( powerSystemStabilizerUserDefined, "CreatePowerSystemStabilizerUserDefinedCommand should not be null" );
//		Assert.isNull( powerSystemStabilizerUserDefined.getPowerSystemStabilizerUserDefinedId(), "CreatePowerSystemStabilizerUserDefinedCommand identifier should be null" );
	}

	/**
	 * handles update validation for a PowerSystemStabilizerUserDefined
	 */
	public void validate( UpdatePowerSystemStabilizerUserDefinedCommand powerSystemStabilizerUserDefined ) throws Exception {
		Assert.notNull( powerSystemStabilizerUserDefined, "UpdatePowerSystemStabilizerUserDefinedCommand should not be null" );
		Assert.notNull( powerSystemStabilizerUserDefined.getPowerSystemStabilizerUserDefinedId(), "UpdatePowerSystemStabilizerUserDefinedCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a PowerSystemStabilizerUserDefined
	 */
    public void validate( DeletePowerSystemStabilizerUserDefinedCommand powerSystemStabilizerUserDefined ) throws Exception {
		Assert.notNull( powerSystemStabilizerUserDefined, "{commandAlias} should not be null" );
		Assert.notNull( powerSystemStabilizerUserDefined.getPowerSystemStabilizerUserDefinedId(), "DeletePowerSystemStabilizerUserDefinedCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a PowerSystemStabilizerUserDefined
	 */
	public void validate( PowerSystemStabilizerUserDefinedFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "PowerSystemStabilizerUserDefinedFetchOneSummary should not be null" );
		Assert.notNull( summary.getPowerSystemStabilizerUserDefinedId(), "PowerSystemStabilizerUserDefinedFetchOneSummary identifier should not be null" );
	}



}
