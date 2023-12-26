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

public class GovHydroWEHValidator {
		
	/**
	 * default constructor
	 */
	protected GovHydroWEHValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public GovHydroWEHValidator getInstance() {
		return new GovHydroWEHValidator();
	}
		
	/**
	 * handles creation validation for a GovHydroWEH
	 */
	public void validate( CreateGovHydroWEHCommand govHydroWEH )throws Exception {
		Assert.notNull( govHydroWEH, "CreateGovHydroWEHCommand should not be null" );
//		Assert.isNull( govHydroWEH.getGovHydroWEHId(), "CreateGovHydroWEHCommand identifier should be null" );
	}

	/**
	 * handles update validation for a GovHydroWEH
	 */
	public void validate( UpdateGovHydroWEHCommand govHydroWEH ) throws Exception {
		Assert.notNull( govHydroWEH, "UpdateGovHydroWEHCommand should not be null" );
		Assert.notNull( govHydroWEH.getGovHydroWEHId(), "UpdateGovHydroWEHCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a GovHydroWEH
	 */
    public void validate( DeleteGovHydroWEHCommand govHydroWEH ) throws Exception {
		Assert.notNull( govHydroWEH, "{commandAlias} should not be null" );
		Assert.notNull( govHydroWEH.getGovHydroWEHId(), "DeleteGovHydroWEHCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a GovHydroWEH
	 */
	public void validate( GovHydroWEHFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GovHydroWEHFetchOneSummary should not be null" );
		Assert.notNull( summary.getGovHydroWEHId(), "GovHydroWEHFetchOneSummary identifier should not be null" );
	}



}
