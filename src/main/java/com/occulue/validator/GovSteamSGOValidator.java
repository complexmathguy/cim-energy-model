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

public class GovSteamSGOValidator {
		
	/**
	 * default constructor
	 */
	protected GovSteamSGOValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public GovSteamSGOValidator getInstance() {
		return new GovSteamSGOValidator();
	}
		
	/**
	 * handles creation validation for a GovSteamSGO
	 */
	public void validate( CreateGovSteamSGOCommand govSteamSGO )throws Exception {
		Assert.notNull( govSteamSGO, "CreateGovSteamSGOCommand should not be null" );
//		Assert.isNull( govSteamSGO.getGovSteamSGOId(), "CreateGovSteamSGOCommand identifier should be null" );
	}

	/**
	 * handles update validation for a GovSteamSGO
	 */
	public void validate( UpdateGovSteamSGOCommand govSteamSGO ) throws Exception {
		Assert.notNull( govSteamSGO, "UpdateGovSteamSGOCommand should not be null" );
		Assert.notNull( govSteamSGO.getGovSteamSGOId(), "UpdateGovSteamSGOCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a GovSteamSGO
	 */
    public void validate( DeleteGovSteamSGOCommand govSteamSGO ) throws Exception {
		Assert.notNull( govSteamSGO, "{commandAlias} should not be null" );
		Assert.notNull( govSteamSGO.getGovSteamSGOId(), "DeleteGovSteamSGOCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a GovSteamSGO
	 */
	public void validate( GovSteamSGOFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GovSteamSGOFetchOneSummary should not be null" );
		Assert.notNull( summary.getGovSteamSGOId(), "GovSteamSGOFetchOneSummary identifier should not be null" );
	}



}
