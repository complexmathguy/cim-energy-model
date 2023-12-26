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

public class GovHydroIEEE2Validator {
		
	/**
	 * default constructor
	 */
	protected GovHydroIEEE2Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public GovHydroIEEE2Validator getInstance() {
		return new GovHydroIEEE2Validator();
	}
		
	/**
	 * handles creation validation for a GovHydroIEEE2
	 */
	public void validate( CreateGovHydroIEEE2Command govHydroIEEE2 )throws Exception {
		Assert.notNull( govHydroIEEE2, "CreateGovHydroIEEE2Command should not be null" );
//		Assert.isNull( govHydroIEEE2.getGovHydroIEEE2Id(), "CreateGovHydroIEEE2Command identifier should be null" );
	}

	/**
	 * handles update validation for a GovHydroIEEE2
	 */
	public void validate( UpdateGovHydroIEEE2Command govHydroIEEE2 ) throws Exception {
		Assert.notNull( govHydroIEEE2, "UpdateGovHydroIEEE2Command should not be null" );
		Assert.notNull( govHydroIEEE2.getGovHydroIEEE2Id(), "UpdateGovHydroIEEE2Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a GovHydroIEEE2
	 */
    public void validate( DeleteGovHydroIEEE2Command govHydroIEEE2 ) throws Exception {
		Assert.notNull( govHydroIEEE2, "{commandAlias} should not be null" );
		Assert.notNull( govHydroIEEE2.getGovHydroIEEE2Id(), "DeleteGovHydroIEEE2Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a GovHydroIEEE2
	 */
	public void validate( GovHydroIEEE2FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GovHydroIEEE2FetchOneSummary should not be null" );
		Assert.notNull( summary.getGovHydroIEEE2Id(), "GovHydroIEEE2FetchOneSummary identifier should not be null" );
	}



}
