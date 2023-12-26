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

public class GovHydroWPIDValidator {
		
	/**
	 * default constructor
	 */
	protected GovHydroWPIDValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public GovHydroWPIDValidator getInstance() {
		return new GovHydroWPIDValidator();
	}
		
	/**
	 * handles creation validation for a GovHydroWPID
	 */
	public void validate( CreateGovHydroWPIDCommand govHydroWPID )throws Exception {
		Assert.notNull( govHydroWPID, "CreateGovHydroWPIDCommand should not be null" );
//		Assert.isNull( govHydroWPID.getGovHydroWPIDId(), "CreateGovHydroWPIDCommand identifier should be null" );
	}

	/**
	 * handles update validation for a GovHydroWPID
	 */
	public void validate( UpdateGovHydroWPIDCommand govHydroWPID ) throws Exception {
		Assert.notNull( govHydroWPID, "UpdateGovHydroWPIDCommand should not be null" );
		Assert.notNull( govHydroWPID.getGovHydroWPIDId(), "UpdateGovHydroWPIDCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a GovHydroWPID
	 */
    public void validate( DeleteGovHydroWPIDCommand govHydroWPID ) throws Exception {
		Assert.notNull( govHydroWPID, "{commandAlias} should not be null" );
		Assert.notNull( govHydroWPID.getGovHydroWPIDId(), "DeleteGovHydroWPIDCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a GovHydroWPID
	 */
	public void validate( GovHydroWPIDFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GovHydroWPIDFetchOneSummary should not be null" );
		Assert.notNull( summary.getGovHydroWPIDId(), "GovHydroWPIDFetchOneSummary identifier should not be null" );
	}



}
