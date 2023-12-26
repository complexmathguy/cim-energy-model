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

public class SolarGeneratingUnitValidator {
		
	/**
	 * default constructor
	 */
	protected SolarGeneratingUnitValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public SolarGeneratingUnitValidator getInstance() {
		return new SolarGeneratingUnitValidator();
	}
		
	/**
	 * handles creation validation for a SolarGeneratingUnit
	 */
	public void validate( CreateSolarGeneratingUnitCommand solarGeneratingUnit )throws Exception {
		Assert.notNull( solarGeneratingUnit, "CreateSolarGeneratingUnitCommand should not be null" );
//		Assert.isNull( solarGeneratingUnit.getSolarGeneratingUnitId(), "CreateSolarGeneratingUnitCommand identifier should be null" );
	}

	/**
	 * handles update validation for a SolarGeneratingUnit
	 */
	public void validate( UpdateSolarGeneratingUnitCommand solarGeneratingUnit ) throws Exception {
		Assert.notNull( solarGeneratingUnit, "UpdateSolarGeneratingUnitCommand should not be null" );
		Assert.notNull( solarGeneratingUnit.getSolarGeneratingUnitId(), "UpdateSolarGeneratingUnitCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a SolarGeneratingUnit
	 */
    public void validate( DeleteSolarGeneratingUnitCommand solarGeneratingUnit ) throws Exception {
		Assert.notNull( solarGeneratingUnit, "{commandAlias} should not be null" );
		Assert.notNull( solarGeneratingUnit.getSolarGeneratingUnitId(), "DeleteSolarGeneratingUnitCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a SolarGeneratingUnit
	 */
	public void validate( SolarGeneratingUnitFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "SolarGeneratingUnitFetchOneSummary should not be null" );
		Assert.notNull( summary.getSolarGeneratingUnitId(), "SolarGeneratingUnitFetchOneSummary identifier should not be null" );
	}



}
