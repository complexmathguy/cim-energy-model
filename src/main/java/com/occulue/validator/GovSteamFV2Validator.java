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

public class GovSteamFV2Validator {
		
	/**
	 * default constructor
	 */
	protected GovSteamFV2Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public GovSteamFV2Validator getInstance() {
		return new GovSteamFV2Validator();
	}
		
	/**
	 * handles creation validation for a GovSteamFV2
	 */
	public void validate( CreateGovSteamFV2Command govSteamFV2 )throws Exception {
		Assert.notNull( govSteamFV2, "CreateGovSteamFV2Command should not be null" );
//		Assert.isNull( govSteamFV2.getGovSteamFV2Id(), "CreateGovSteamFV2Command identifier should be null" );
	}

	/**
	 * handles update validation for a GovSteamFV2
	 */
	public void validate( UpdateGovSteamFV2Command govSteamFV2 ) throws Exception {
		Assert.notNull( govSteamFV2, "UpdateGovSteamFV2Command should not be null" );
		Assert.notNull( govSteamFV2.getGovSteamFV2Id(), "UpdateGovSteamFV2Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a GovSteamFV2
	 */
    public void validate( DeleteGovSteamFV2Command govSteamFV2 ) throws Exception {
		Assert.notNull( govSteamFV2, "{commandAlias} should not be null" );
		Assert.notNull( govSteamFV2.getGovSteamFV2Id(), "DeleteGovSteamFV2Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a GovSteamFV2
	 */
	public void validate( GovSteamFV2FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GovSteamFV2FetchOneSummary should not be null" );
		Assert.notNull( summary.getGovSteamFV2Id(), "GovSteamFV2FetchOneSummary identifier should not be null" );
	}



}
