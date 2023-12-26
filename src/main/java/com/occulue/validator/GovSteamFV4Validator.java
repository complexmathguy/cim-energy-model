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

public class GovSteamFV4Validator {
		
	/**
	 * default constructor
	 */
	protected GovSteamFV4Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public GovSteamFV4Validator getInstance() {
		return new GovSteamFV4Validator();
	}
		
	/**
	 * handles creation validation for a GovSteamFV4
	 */
	public void validate( CreateGovSteamFV4Command govSteamFV4 )throws Exception {
		Assert.notNull( govSteamFV4, "CreateGovSteamFV4Command should not be null" );
//		Assert.isNull( govSteamFV4.getGovSteamFV4Id(), "CreateGovSteamFV4Command identifier should be null" );
	}

	/**
	 * handles update validation for a GovSteamFV4
	 */
	public void validate( UpdateGovSteamFV4Command govSteamFV4 ) throws Exception {
		Assert.notNull( govSteamFV4, "UpdateGovSteamFV4Command should not be null" );
		Assert.notNull( govSteamFV4.getGovSteamFV4Id(), "UpdateGovSteamFV4Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a GovSteamFV4
	 */
    public void validate( DeleteGovSteamFV4Command govSteamFV4 ) throws Exception {
		Assert.notNull( govSteamFV4, "{commandAlias} should not be null" );
		Assert.notNull( govSteamFV4.getGovSteamFV4Id(), "DeleteGovSteamFV4Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a GovSteamFV4
	 */
	public void validate( GovSteamFV4FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GovSteamFV4FetchOneSummary should not be null" );
		Assert.notNull( summary.getGovSteamFV4Id(), "GovSteamFV4FetchOneSummary identifier should not be null" );
	}



}
