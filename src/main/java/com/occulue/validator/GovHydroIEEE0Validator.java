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

public class GovHydroIEEE0Validator {
		
	/**
	 * default constructor
	 */
	protected GovHydroIEEE0Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public GovHydroIEEE0Validator getInstance() {
		return new GovHydroIEEE0Validator();
	}
		
	/**
	 * handles creation validation for a GovHydroIEEE0
	 */
	public void validate( CreateGovHydroIEEE0Command govHydroIEEE0 )throws Exception {
		Assert.notNull( govHydroIEEE0, "CreateGovHydroIEEE0Command should not be null" );
//		Assert.isNull( govHydroIEEE0.getGovHydroIEEE0Id(), "CreateGovHydroIEEE0Command identifier should be null" );
	}

	/**
	 * handles update validation for a GovHydroIEEE0
	 */
	public void validate( UpdateGovHydroIEEE0Command govHydroIEEE0 ) throws Exception {
		Assert.notNull( govHydroIEEE0, "UpdateGovHydroIEEE0Command should not be null" );
		Assert.notNull( govHydroIEEE0.getGovHydroIEEE0Id(), "UpdateGovHydroIEEE0Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a GovHydroIEEE0
	 */
    public void validate( DeleteGovHydroIEEE0Command govHydroIEEE0 ) throws Exception {
		Assert.notNull( govHydroIEEE0, "{commandAlias} should not be null" );
		Assert.notNull( govHydroIEEE0.getGovHydroIEEE0Id(), "DeleteGovHydroIEEE0Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a GovHydroIEEE0
	 */
	public void validate( GovHydroIEEE0FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GovHydroIEEE0FetchOneSummary should not be null" );
		Assert.notNull( summary.getGovHydroIEEE0Id(), "GovHydroIEEE0FetchOneSummary identifier should not be null" );
	}



}
