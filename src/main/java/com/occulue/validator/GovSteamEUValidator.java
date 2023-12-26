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

public class GovSteamEUValidator {
		
	/**
	 * default constructor
	 */
	protected GovSteamEUValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public GovSteamEUValidator getInstance() {
		return new GovSteamEUValidator();
	}
		
	/**
	 * handles creation validation for a GovSteamEU
	 */
	public void validate( CreateGovSteamEUCommand govSteamEU )throws Exception {
		Assert.notNull( govSteamEU, "CreateGovSteamEUCommand should not be null" );
//		Assert.isNull( govSteamEU.getGovSteamEUId(), "CreateGovSteamEUCommand identifier should be null" );
	}

	/**
	 * handles update validation for a GovSteamEU
	 */
	public void validate( UpdateGovSteamEUCommand govSteamEU ) throws Exception {
		Assert.notNull( govSteamEU, "UpdateGovSteamEUCommand should not be null" );
		Assert.notNull( govSteamEU.getGovSteamEUId(), "UpdateGovSteamEUCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a GovSteamEU
	 */
    public void validate( DeleteGovSteamEUCommand govSteamEU ) throws Exception {
		Assert.notNull( govSteamEU, "{commandAlias} should not be null" );
		Assert.notNull( govSteamEU.getGovSteamEUId(), "DeleteGovSteamEUCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a GovSteamEU
	 */
	public void validate( GovSteamEUFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GovSteamEUFetchOneSummary should not be null" );
		Assert.notNull( summary.getGovSteamEUId(), "GovSteamEUFetchOneSummary identifier should not be null" );
	}



}
