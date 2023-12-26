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

public class ExternalNetworkInjectionValidator {
		
	/**
	 * default constructor
	 */
	protected ExternalNetworkInjectionValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExternalNetworkInjectionValidator getInstance() {
		return new ExternalNetworkInjectionValidator();
	}
		
	/**
	 * handles creation validation for a ExternalNetworkInjection
	 */
	public void validate( CreateExternalNetworkInjectionCommand externalNetworkInjection )throws Exception {
		Assert.notNull( externalNetworkInjection, "CreateExternalNetworkInjectionCommand should not be null" );
//		Assert.isNull( externalNetworkInjection.getExternalNetworkInjectionId(), "CreateExternalNetworkInjectionCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExternalNetworkInjection
	 */
	public void validate( UpdateExternalNetworkInjectionCommand externalNetworkInjection ) throws Exception {
		Assert.notNull( externalNetworkInjection, "UpdateExternalNetworkInjectionCommand should not be null" );
		Assert.notNull( externalNetworkInjection.getExternalNetworkInjectionId(), "UpdateExternalNetworkInjectionCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExternalNetworkInjection
	 */
    public void validate( DeleteExternalNetworkInjectionCommand externalNetworkInjection ) throws Exception {
		Assert.notNull( externalNetworkInjection, "{commandAlias} should not be null" );
		Assert.notNull( externalNetworkInjection.getExternalNetworkInjectionId(), "DeleteExternalNetworkInjectionCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExternalNetworkInjection
	 */
	public void validate( ExternalNetworkInjectionFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExternalNetworkInjectionFetchOneSummary should not be null" );
		Assert.notNull( summary.getExternalNetworkInjectionId(), "ExternalNetworkInjectionFetchOneSummary identifier should not be null" );
	}



}
