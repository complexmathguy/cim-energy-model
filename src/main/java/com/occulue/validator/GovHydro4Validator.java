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

public class GovHydro4Validator {
		
	/**
	 * default constructor
	 */
	protected GovHydro4Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public GovHydro4Validator getInstance() {
		return new GovHydro4Validator();
	}
		
	/**
	 * handles creation validation for a GovHydro4
	 */
	public void validate( CreateGovHydro4Command govHydro4 )throws Exception {
		Assert.notNull( govHydro4, "CreateGovHydro4Command should not be null" );
//		Assert.isNull( govHydro4.getGovHydro4Id(), "CreateGovHydro4Command identifier should be null" );
	}

	/**
	 * handles update validation for a GovHydro4
	 */
	public void validate( UpdateGovHydro4Command govHydro4 ) throws Exception {
		Assert.notNull( govHydro4, "UpdateGovHydro4Command should not be null" );
		Assert.notNull( govHydro4.getGovHydro4Id(), "UpdateGovHydro4Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a GovHydro4
	 */
    public void validate( DeleteGovHydro4Command govHydro4 ) throws Exception {
		Assert.notNull( govHydro4, "{commandAlias} should not be null" );
		Assert.notNull( govHydro4.getGovHydro4Id(), "DeleteGovHydro4Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a GovHydro4
	 */
	public void validate( GovHydro4FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GovHydro4FetchOneSummary should not be null" );
		Assert.notNull( summary.getGovHydro4Id(), "GovHydro4FetchOneSummary identifier should not be null" );
	}



}
