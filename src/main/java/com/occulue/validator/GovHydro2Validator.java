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

public class GovHydro2Validator {
		
	/**
	 * default constructor
	 */
	protected GovHydro2Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public GovHydro2Validator getInstance() {
		return new GovHydro2Validator();
	}
		
	/**
	 * handles creation validation for a GovHydro2
	 */
	public void validate( CreateGovHydro2Command govHydro2 )throws Exception {
		Assert.notNull( govHydro2, "CreateGovHydro2Command should not be null" );
//		Assert.isNull( govHydro2.getGovHydro2Id(), "CreateGovHydro2Command identifier should be null" );
	}

	/**
	 * handles update validation for a GovHydro2
	 */
	public void validate( UpdateGovHydro2Command govHydro2 ) throws Exception {
		Assert.notNull( govHydro2, "UpdateGovHydro2Command should not be null" );
		Assert.notNull( govHydro2.getGovHydro2Id(), "UpdateGovHydro2Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a GovHydro2
	 */
    public void validate( DeleteGovHydro2Command govHydro2 ) throws Exception {
		Assert.notNull( govHydro2, "{commandAlias} should not be null" );
		Assert.notNull( govHydro2.getGovHydro2Id(), "DeleteGovHydro2Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a GovHydro2
	 */
	public void validate( GovHydro2FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GovHydro2FetchOneSummary should not be null" );
		Assert.notNull( summary.getGovHydro2Id(), "GovHydro2FetchOneSummary identifier should not be null" );
	}



}
