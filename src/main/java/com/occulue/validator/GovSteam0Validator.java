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

public class GovSteam0Validator {
		
	/**
	 * default constructor
	 */
	protected GovSteam0Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public GovSteam0Validator getInstance() {
		return new GovSteam0Validator();
	}
		
	/**
	 * handles creation validation for a GovSteam0
	 */
	public void validate( CreateGovSteam0Command govSteam0 )throws Exception {
		Assert.notNull( govSteam0, "CreateGovSteam0Command should not be null" );
//		Assert.isNull( govSteam0.getGovSteam0Id(), "CreateGovSteam0Command identifier should be null" );
	}

	/**
	 * handles update validation for a GovSteam0
	 */
	public void validate( UpdateGovSteam0Command govSteam0 ) throws Exception {
		Assert.notNull( govSteam0, "UpdateGovSteam0Command should not be null" );
		Assert.notNull( govSteam0.getGovSteam0Id(), "UpdateGovSteam0Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a GovSteam0
	 */
    public void validate( DeleteGovSteam0Command govSteam0 ) throws Exception {
		Assert.notNull( govSteam0, "{commandAlias} should not be null" );
		Assert.notNull( govSteam0.getGovSteam0Id(), "DeleteGovSteam0Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a GovSteam0
	 */
	public void validate( GovSteam0FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GovSteam0FetchOneSummary should not be null" );
		Assert.notNull( summary.getGovSteam0Id(), "GovSteam0FetchOneSummary identifier should not be null" );
	}



}
