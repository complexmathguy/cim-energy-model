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

public class GovSteamIEEE1Validator {
		
	/**
	 * default constructor
	 */
	protected GovSteamIEEE1Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public GovSteamIEEE1Validator getInstance() {
		return new GovSteamIEEE1Validator();
	}
		
	/**
	 * handles creation validation for a GovSteamIEEE1
	 */
	public void validate( CreateGovSteamIEEE1Command govSteamIEEE1 )throws Exception {
		Assert.notNull( govSteamIEEE1, "CreateGovSteamIEEE1Command should not be null" );
//		Assert.isNull( govSteamIEEE1.getGovSteamIEEE1Id(), "CreateGovSteamIEEE1Command identifier should be null" );
	}

	/**
	 * handles update validation for a GovSteamIEEE1
	 */
	public void validate( UpdateGovSteamIEEE1Command govSteamIEEE1 ) throws Exception {
		Assert.notNull( govSteamIEEE1, "UpdateGovSteamIEEE1Command should not be null" );
		Assert.notNull( govSteamIEEE1.getGovSteamIEEE1Id(), "UpdateGovSteamIEEE1Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a GovSteamIEEE1
	 */
    public void validate( DeleteGovSteamIEEE1Command govSteamIEEE1 ) throws Exception {
		Assert.notNull( govSteamIEEE1, "{commandAlias} should not be null" );
		Assert.notNull( govSteamIEEE1.getGovSteamIEEE1Id(), "DeleteGovSteamIEEE1Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a GovSteamIEEE1
	 */
	public void validate( GovSteamIEEE1FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GovSteamIEEE1FetchOneSummary should not be null" );
		Assert.notNull( summary.getGovSteamIEEE1Id(), "GovSteamIEEE1FetchOneSummary identifier should not be null" );
	}



}
