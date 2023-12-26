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

public class GovSteamCCValidator {
		
	/**
	 * default constructor
	 */
	protected GovSteamCCValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public GovSteamCCValidator getInstance() {
		return new GovSteamCCValidator();
	}
		
	/**
	 * handles creation validation for a GovSteamCC
	 */
	public void validate( CreateGovSteamCCCommand govSteamCC )throws Exception {
		Assert.notNull( govSteamCC, "CreateGovSteamCCCommand should not be null" );
//		Assert.isNull( govSteamCC.getGovSteamCCId(), "CreateGovSteamCCCommand identifier should be null" );
	}

	/**
	 * handles update validation for a GovSteamCC
	 */
	public void validate( UpdateGovSteamCCCommand govSteamCC ) throws Exception {
		Assert.notNull( govSteamCC, "UpdateGovSteamCCCommand should not be null" );
		Assert.notNull( govSteamCC.getGovSteamCCId(), "UpdateGovSteamCCCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a GovSteamCC
	 */
    public void validate( DeleteGovSteamCCCommand govSteamCC ) throws Exception {
		Assert.notNull( govSteamCC, "{commandAlias} should not be null" );
		Assert.notNull( govSteamCC.getGovSteamCCId(), "DeleteGovSteamCCCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a GovSteamCC
	 */
	public void validate( GovSteamCCFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GovSteamCCFetchOneSummary should not be null" );
		Assert.notNull( summary.getGovSteamCCId(), "GovSteamCCFetchOneSummary identifier should not be null" );
	}



}
