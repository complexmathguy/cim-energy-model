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

public class GovHydroDDValidator {
		
	/**
	 * default constructor
	 */
	protected GovHydroDDValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public GovHydroDDValidator getInstance() {
		return new GovHydroDDValidator();
	}
		
	/**
	 * handles creation validation for a GovHydroDD
	 */
	public void validate( CreateGovHydroDDCommand govHydroDD )throws Exception {
		Assert.notNull( govHydroDD, "CreateGovHydroDDCommand should not be null" );
//		Assert.isNull( govHydroDD.getGovHydroDDId(), "CreateGovHydroDDCommand identifier should be null" );
	}

	/**
	 * handles update validation for a GovHydroDD
	 */
	public void validate( UpdateGovHydroDDCommand govHydroDD ) throws Exception {
		Assert.notNull( govHydroDD, "UpdateGovHydroDDCommand should not be null" );
		Assert.notNull( govHydroDD.getGovHydroDDId(), "UpdateGovHydroDDCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a GovHydroDD
	 */
    public void validate( DeleteGovHydroDDCommand govHydroDD ) throws Exception {
		Assert.notNull( govHydroDD, "{commandAlias} should not be null" );
		Assert.notNull( govHydroDD.getGovHydroDDId(), "DeleteGovHydroDDCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a GovHydroDD
	 */
	public void validate( GovHydroDDFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GovHydroDDFetchOneSummary should not be null" );
		Assert.notNull( summary.getGovHydroDDId(), "GovHydroDDFetchOneSummary identifier should not be null" );
	}



}
