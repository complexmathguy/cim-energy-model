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

public class GovHydroPIDValidator {
		
	/**
	 * default constructor
	 */
	protected GovHydroPIDValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public GovHydroPIDValidator getInstance() {
		return new GovHydroPIDValidator();
	}
		
	/**
	 * handles creation validation for a GovHydroPID
	 */
	public void validate( CreateGovHydroPIDCommand govHydroPID )throws Exception {
		Assert.notNull( govHydroPID, "CreateGovHydroPIDCommand should not be null" );
//		Assert.isNull( govHydroPID.getGovHydroPIDId(), "CreateGovHydroPIDCommand identifier should be null" );
	}

	/**
	 * handles update validation for a GovHydroPID
	 */
	public void validate( UpdateGovHydroPIDCommand govHydroPID ) throws Exception {
		Assert.notNull( govHydroPID, "UpdateGovHydroPIDCommand should not be null" );
		Assert.notNull( govHydroPID.getGovHydroPIDId(), "UpdateGovHydroPIDCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a GovHydroPID
	 */
    public void validate( DeleteGovHydroPIDCommand govHydroPID ) throws Exception {
		Assert.notNull( govHydroPID, "{commandAlias} should not be null" );
		Assert.notNull( govHydroPID.getGovHydroPIDId(), "DeleteGovHydroPIDCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a GovHydroPID
	 */
	public void validate( GovHydroPIDFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GovHydroPIDFetchOneSummary should not be null" );
		Assert.notNull( summary.getGovHydroPIDId(), "GovHydroPIDFetchOneSummary identifier should not be null" );
	}



}
