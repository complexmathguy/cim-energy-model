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

public class GovSteamFV3Validator {
		
	/**
	 * default constructor
	 */
	protected GovSteamFV3Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public GovSteamFV3Validator getInstance() {
		return new GovSteamFV3Validator();
	}
		
	/**
	 * handles creation validation for a GovSteamFV3
	 */
	public void validate( CreateGovSteamFV3Command govSteamFV3 )throws Exception {
		Assert.notNull( govSteamFV3, "CreateGovSteamFV3Command should not be null" );
//		Assert.isNull( govSteamFV3.getGovSteamFV3Id(), "CreateGovSteamFV3Command identifier should be null" );
	}

	/**
	 * handles update validation for a GovSteamFV3
	 */
	public void validate( UpdateGovSteamFV3Command govSteamFV3 ) throws Exception {
		Assert.notNull( govSteamFV3, "UpdateGovSteamFV3Command should not be null" );
		Assert.notNull( govSteamFV3.getGovSteamFV3Id(), "UpdateGovSteamFV3Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a GovSteamFV3
	 */
    public void validate( DeleteGovSteamFV3Command govSteamFV3 ) throws Exception {
		Assert.notNull( govSteamFV3, "{commandAlias} should not be null" );
		Assert.notNull( govSteamFV3.getGovSteamFV3Id(), "DeleteGovSteamFV3Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a GovSteamFV3
	 */
	public void validate( GovSteamFV3FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GovSteamFV3FetchOneSummary should not be null" );
		Assert.notNull( summary.getGovSteamFV3Id(), "GovSteamFV3FetchOneSummary identifier should not be null" );
	}



}
