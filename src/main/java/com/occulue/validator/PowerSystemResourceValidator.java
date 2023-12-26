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

public class PowerSystemResourceValidator {
		
	/**
	 * default constructor
	 */
	protected PowerSystemResourceValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public PowerSystemResourceValidator getInstance() {
		return new PowerSystemResourceValidator();
	}
		
	/**
	 * handles creation validation for a PowerSystemResource
	 */
	public void validate( CreatePowerSystemResourceCommand powerSystemResource )throws Exception {
		Assert.notNull( powerSystemResource, "CreatePowerSystemResourceCommand should not be null" );
//		Assert.isNull( powerSystemResource.getPowerSystemResourceId(), "CreatePowerSystemResourceCommand identifier should be null" );
	}

	/**
	 * handles update validation for a PowerSystemResource
	 */
	public void validate( UpdatePowerSystemResourceCommand powerSystemResource ) throws Exception {
		Assert.notNull( powerSystemResource, "UpdatePowerSystemResourceCommand should not be null" );
		Assert.notNull( powerSystemResource.getPowerSystemResourceId(), "UpdatePowerSystemResourceCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a PowerSystemResource
	 */
    public void validate( DeletePowerSystemResourceCommand powerSystemResource ) throws Exception {
		Assert.notNull( powerSystemResource, "{commandAlias} should not be null" );
		Assert.notNull( powerSystemResource.getPowerSystemResourceId(), "DeletePowerSystemResourceCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a PowerSystemResource
	 */
	public void validate( PowerSystemResourceFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "PowerSystemResourceFetchOneSummary should not be null" );
		Assert.notNull( summary.getPowerSystemResourceId(), "PowerSystemResourceFetchOneSummary identifier should not be null" );
	}



}
