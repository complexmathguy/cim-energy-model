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

public class GovHydro1Validator {
		
	/**
	 * default constructor
	 */
	protected GovHydro1Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public GovHydro1Validator getInstance() {
		return new GovHydro1Validator();
	}
		
	/**
	 * handles creation validation for a GovHydro1
	 */
	public void validate( CreateGovHydro1Command govHydro1 )throws Exception {
		Assert.notNull( govHydro1, "CreateGovHydro1Command should not be null" );
//		Assert.isNull( govHydro1.getGovHydro1Id(), "CreateGovHydro1Command identifier should be null" );
	}

	/**
	 * handles update validation for a GovHydro1
	 */
	public void validate( UpdateGovHydro1Command govHydro1 ) throws Exception {
		Assert.notNull( govHydro1, "UpdateGovHydro1Command should not be null" );
		Assert.notNull( govHydro1.getGovHydro1Id(), "UpdateGovHydro1Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a GovHydro1
	 */
    public void validate( DeleteGovHydro1Command govHydro1 ) throws Exception {
		Assert.notNull( govHydro1, "{commandAlias} should not be null" );
		Assert.notNull( govHydro1.getGovHydro1Id(), "DeleteGovHydro1Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a GovHydro1
	 */
	public void validate( GovHydro1FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GovHydro1FetchOneSummary should not be null" );
		Assert.notNull( summary.getGovHydro1Id(), "GovHydro1FetchOneSummary identifier should not be null" );
	}



}
