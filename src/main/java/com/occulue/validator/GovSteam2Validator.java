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

public class GovSteam2Validator {
		
	/**
	 * default constructor
	 */
	protected GovSteam2Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public GovSteam2Validator getInstance() {
		return new GovSteam2Validator();
	}
		
	/**
	 * handles creation validation for a GovSteam2
	 */
	public void validate( CreateGovSteam2Command govSteam2 )throws Exception {
		Assert.notNull( govSteam2, "CreateGovSteam2Command should not be null" );
//		Assert.isNull( govSteam2.getGovSteam2Id(), "CreateGovSteam2Command identifier should be null" );
	}

	/**
	 * handles update validation for a GovSteam2
	 */
	public void validate( UpdateGovSteam2Command govSteam2 ) throws Exception {
		Assert.notNull( govSteam2, "UpdateGovSteam2Command should not be null" );
		Assert.notNull( govSteam2.getGovSteam2Id(), "UpdateGovSteam2Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a GovSteam2
	 */
    public void validate( DeleteGovSteam2Command govSteam2 ) throws Exception {
		Assert.notNull( govSteam2, "{commandAlias} should not be null" );
		Assert.notNull( govSteam2.getGovSteam2Id(), "DeleteGovSteam2Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a GovSteam2
	 */
	public void validate( GovSteam2FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GovSteam2FetchOneSummary should not be null" );
		Assert.notNull( summary.getGovSteam2Id(), "GovSteam2FetchOneSummary identifier should not be null" );
	}



}
