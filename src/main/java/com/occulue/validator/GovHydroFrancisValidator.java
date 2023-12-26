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

public class GovHydroFrancisValidator {
		
	/**
	 * default constructor
	 */
	protected GovHydroFrancisValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public GovHydroFrancisValidator getInstance() {
		return new GovHydroFrancisValidator();
	}
		
	/**
	 * handles creation validation for a GovHydroFrancis
	 */
	public void validate( CreateGovHydroFrancisCommand govHydroFrancis )throws Exception {
		Assert.notNull( govHydroFrancis, "CreateGovHydroFrancisCommand should not be null" );
//		Assert.isNull( govHydroFrancis.getGovHydroFrancisId(), "CreateGovHydroFrancisCommand identifier should be null" );
	}

	/**
	 * handles update validation for a GovHydroFrancis
	 */
	public void validate( UpdateGovHydroFrancisCommand govHydroFrancis ) throws Exception {
		Assert.notNull( govHydroFrancis, "UpdateGovHydroFrancisCommand should not be null" );
		Assert.notNull( govHydroFrancis.getGovHydroFrancisId(), "UpdateGovHydroFrancisCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a GovHydroFrancis
	 */
    public void validate( DeleteGovHydroFrancisCommand govHydroFrancis ) throws Exception {
		Assert.notNull( govHydroFrancis, "{commandAlias} should not be null" );
		Assert.notNull( govHydroFrancis.getGovHydroFrancisId(), "DeleteGovHydroFrancisCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a GovHydroFrancis
	 */
	public void validate( GovHydroFrancisFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GovHydroFrancisFetchOneSummary should not be null" );
		Assert.notNull( summary.getGovHydroFrancisId(), "GovHydroFrancisFetchOneSummary identifier should not be null" );
	}



}
