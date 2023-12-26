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

public class GovSteam1Validator {
		
	/**
	 * default constructor
	 */
	protected GovSteam1Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public GovSteam1Validator getInstance() {
		return new GovSteam1Validator();
	}
		
	/**
	 * handles creation validation for a GovSteam1
	 */
	public void validate( CreateGovSteam1Command govSteam1 )throws Exception {
		Assert.notNull( govSteam1, "CreateGovSteam1Command should not be null" );
//		Assert.isNull( govSteam1.getGovSteam1Id(), "CreateGovSteam1Command identifier should be null" );
	}

	/**
	 * handles update validation for a GovSteam1
	 */
	public void validate( UpdateGovSteam1Command govSteam1 ) throws Exception {
		Assert.notNull( govSteam1, "UpdateGovSteam1Command should not be null" );
		Assert.notNull( govSteam1.getGovSteam1Id(), "UpdateGovSteam1Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a GovSteam1
	 */
    public void validate( DeleteGovSteam1Command govSteam1 ) throws Exception {
		Assert.notNull( govSteam1, "{commandAlias} should not be null" );
		Assert.notNull( govSteam1.getGovSteam1Id(), "DeleteGovSteam1Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a GovSteam1
	 */
	public void validate( GovSteam1FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GovSteam1FetchOneSummary should not be null" );
		Assert.notNull( summary.getGovSteam1Id(), "GovSteam1FetchOneSummary identifier should not be null" );
	}



}
