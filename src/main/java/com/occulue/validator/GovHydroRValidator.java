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

public class GovHydroRValidator {
		
	/**
	 * default constructor
	 */
	protected GovHydroRValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public GovHydroRValidator getInstance() {
		return new GovHydroRValidator();
	}
		
	/**
	 * handles creation validation for a GovHydroR
	 */
	public void validate( CreateGovHydroRCommand govHydroR )throws Exception {
		Assert.notNull( govHydroR, "CreateGovHydroRCommand should not be null" );
//		Assert.isNull( govHydroR.getGovHydroRId(), "CreateGovHydroRCommand identifier should be null" );
	}

	/**
	 * handles update validation for a GovHydroR
	 */
	public void validate( UpdateGovHydroRCommand govHydroR ) throws Exception {
		Assert.notNull( govHydroR, "UpdateGovHydroRCommand should not be null" );
		Assert.notNull( govHydroR.getGovHydroRId(), "UpdateGovHydroRCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a GovHydroR
	 */
    public void validate( DeleteGovHydroRCommand govHydroR ) throws Exception {
		Assert.notNull( govHydroR, "{commandAlias} should not be null" );
		Assert.notNull( govHydroR.getGovHydroRId(), "DeleteGovHydroRCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a GovHydroR
	 */
	public void validate( GovHydroRFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GovHydroRFetchOneSummary should not be null" );
		Assert.notNull( summary.getGovHydroRId(), "GovHydroRFetchOneSummary identifier should not be null" );
	}



}
