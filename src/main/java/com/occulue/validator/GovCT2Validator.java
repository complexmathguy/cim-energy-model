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

public class GovCT2Validator {
		
	/**
	 * default constructor
	 */
	protected GovCT2Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public GovCT2Validator getInstance() {
		return new GovCT2Validator();
	}
		
	/**
	 * handles creation validation for a GovCT2
	 */
	public void validate( CreateGovCT2Command govCT2 )throws Exception {
		Assert.notNull( govCT2, "CreateGovCT2Command should not be null" );
//		Assert.isNull( govCT2.getGovCT2Id(), "CreateGovCT2Command identifier should be null" );
	}

	/**
	 * handles update validation for a GovCT2
	 */
	public void validate( UpdateGovCT2Command govCT2 ) throws Exception {
		Assert.notNull( govCT2, "UpdateGovCT2Command should not be null" );
		Assert.notNull( govCT2.getGovCT2Id(), "UpdateGovCT2Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a GovCT2
	 */
    public void validate( DeleteGovCT2Command govCT2 ) throws Exception {
		Assert.notNull( govCT2, "{commandAlias} should not be null" );
		Assert.notNull( govCT2.getGovCT2Id(), "DeleteGovCT2Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a GovCT2
	 */
	public void validate( GovCT2FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GovCT2FetchOneSummary should not be null" );
		Assert.notNull( summary.getGovCT2Id(), "GovCT2FetchOneSummary identifier should not be null" );
	}



}
