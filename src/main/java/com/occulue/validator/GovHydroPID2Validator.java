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

public class GovHydroPID2Validator {
		
	/**
	 * default constructor
	 */
	protected GovHydroPID2Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public GovHydroPID2Validator getInstance() {
		return new GovHydroPID2Validator();
	}
		
	/**
	 * handles creation validation for a GovHydroPID2
	 */
	public void validate( CreateGovHydroPID2Command govHydroPID2 )throws Exception {
		Assert.notNull( govHydroPID2, "CreateGovHydroPID2Command should not be null" );
//		Assert.isNull( govHydroPID2.getGovHydroPID2Id(), "CreateGovHydroPID2Command identifier should be null" );
	}

	/**
	 * handles update validation for a GovHydroPID2
	 */
	public void validate( UpdateGovHydroPID2Command govHydroPID2 ) throws Exception {
		Assert.notNull( govHydroPID2, "UpdateGovHydroPID2Command should not be null" );
		Assert.notNull( govHydroPID2.getGovHydroPID2Id(), "UpdateGovHydroPID2Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a GovHydroPID2
	 */
    public void validate( DeleteGovHydroPID2Command govHydroPID2 ) throws Exception {
		Assert.notNull( govHydroPID2, "{commandAlias} should not be null" );
		Assert.notNull( govHydroPID2.getGovHydroPID2Id(), "DeleteGovHydroPID2Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a GovHydroPID2
	 */
	public void validate( GovHydroPID2FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GovHydroPID2FetchOneSummary should not be null" );
		Assert.notNull( summary.getGovHydroPID2Id(), "GovHydroPID2FetchOneSummary identifier should not be null" );
	}



}
