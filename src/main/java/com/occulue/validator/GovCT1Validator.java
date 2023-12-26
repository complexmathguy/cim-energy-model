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

public class GovCT1Validator {
		
	/**
	 * default constructor
	 */
	protected GovCT1Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public GovCT1Validator getInstance() {
		return new GovCT1Validator();
	}
		
	/**
	 * handles creation validation for a GovCT1
	 */
	public void validate( CreateGovCT1Command govCT1 )throws Exception {
		Assert.notNull( govCT1, "CreateGovCT1Command should not be null" );
//		Assert.isNull( govCT1.getGovCT1Id(), "CreateGovCT1Command identifier should be null" );
	}

	/**
	 * handles update validation for a GovCT1
	 */
	public void validate( UpdateGovCT1Command govCT1 ) throws Exception {
		Assert.notNull( govCT1, "UpdateGovCT1Command should not be null" );
		Assert.notNull( govCT1.getGovCT1Id(), "UpdateGovCT1Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a GovCT1
	 */
    public void validate( DeleteGovCT1Command govCT1 ) throws Exception {
		Assert.notNull( govCT1, "{commandAlias} should not be null" );
		Assert.notNull( govCT1.getGovCT1Id(), "DeleteGovCT1Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a GovCT1
	 */
	public void validate( GovCT1FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GovCT1FetchOneSummary should not be null" );
		Assert.notNull( summary.getGovCT1Id(), "GovCT1FetchOneSummary identifier should not be null" );
	}



}
