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

public class DynamicsVersionValidator {
		
	/**
	 * default constructor
	 */
	protected DynamicsVersionValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public DynamicsVersionValidator getInstance() {
		return new DynamicsVersionValidator();
	}
		
	/**
	 * handles creation validation for a DynamicsVersion
	 */
	public void validate( CreateDynamicsVersionCommand dynamicsVersion )throws Exception {
		Assert.notNull( dynamicsVersion, "CreateDynamicsVersionCommand should not be null" );
//		Assert.isNull( dynamicsVersion.getDynamicsVersionId(), "CreateDynamicsVersionCommand identifier should be null" );
	}

	/**
	 * handles update validation for a DynamicsVersion
	 */
	public void validate( UpdateDynamicsVersionCommand dynamicsVersion ) throws Exception {
		Assert.notNull( dynamicsVersion, "UpdateDynamicsVersionCommand should not be null" );
		Assert.notNull( dynamicsVersion.getDynamicsVersionId(), "UpdateDynamicsVersionCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a DynamicsVersion
	 */
    public void validate( DeleteDynamicsVersionCommand dynamicsVersion ) throws Exception {
		Assert.notNull( dynamicsVersion, "{commandAlias} should not be null" );
		Assert.notNull( dynamicsVersion.getDynamicsVersionId(), "DeleteDynamicsVersionCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a DynamicsVersion
	 */
	public void validate( DynamicsVersionFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "DynamicsVersionFetchOneSummary should not be null" );
		Assert.notNull( summary.getDynamicsVersionId(), "DynamicsVersionFetchOneSummary identifier should not be null" );
	}



}
