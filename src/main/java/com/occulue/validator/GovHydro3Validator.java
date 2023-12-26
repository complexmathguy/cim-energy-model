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

public class GovHydro3Validator {
		
	/**
	 * default constructor
	 */
	protected GovHydro3Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public GovHydro3Validator getInstance() {
		return new GovHydro3Validator();
	}
		
	/**
	 * handles creation validation for a GovHydro3
	 */
	public void validate( CreateGovHydro3Command govHydro3 )throws Exception {
		Assert.notNull( govHydro3, "CreateGovHydro3Command should not be null" );
//		Assert.isNull( govHydro3.getGovHydro3Id(), "CreateGovHydro3Command identifier should be null" );
	}

	/**
	 * handles update validation for a GovHydro3
	 */
	public void validate( UpdateGovHydro3Command govHydro3 ) throws Exception {
		Assert.notNull( govHydro3, "UpdateGovHydro3Command should not be null" );
		Assert.notNull( govHydro3.getGovHydro3Id(), "UpdateGovHydro3Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a GovHydro3
	 */
    public void validate( DeleteGovHydro3Command govHydro3 ) throws Exception {
		Assert.notNull( govHydro3, "{commandAlias} should not be null" );
		Assert.notNull( govHydro3.getGovHydro3Id(), "DeleteGovHydro3Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a GovHydro3
	 */
	public void validate( GovHydro3FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GovHydro3FetchOneSummary should not be null" );
		Assert.notNull( summary.getGovHydro3Id(), "GovHydro3FetchOneSummary identifier should not be null" );
	}



}
