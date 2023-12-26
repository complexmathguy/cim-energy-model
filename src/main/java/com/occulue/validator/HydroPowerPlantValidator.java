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

public class HydroPowerPlantValidator {
		
	/**
	 * default constructor
	 */
	protected HydroPowerPlantValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public HydroPowerPlantValidator getInstance() {
		return new HydroPowerPlantValidator();
	}
		
	/**
	 * handles creation validation for a HydroPowerPlant
	 */
	public void validate( CreateHydroPowerPlantCommand hydroPowerPlant )throws Exception {
		Assert.notNull( hydroPowerPlant, "CreateHydroPowerPlantCommand should not be null" );
//		Assert.isNull( hydroPowerPlant.getHydroPowerPlantId(), "CreateHydroPowerPlantCommand identifier should be null" );
	}

	/**
	 * handles update validation for a HydroPowerPlant
	 */
	public void validate( UpdateHydroPowerPlantCommand hydroPowerPlant ) throws Exception {
		Assert.notNull( hydroPowerPlant, "UpdateHydroPowerPlantCommand should not be null" );
		Assert.notNull( hydroPowerPlant.getHydroPowerPlantId(), "UpdateHydroPowerPlantCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a HydroPowerPlant
	 */
    public void validate( DeleteHydroPowerPlantCommand hydroPowerPlant ) throws Exception {
		Assert.notNull( hydroPowerPlant, "{commandAlias} should not be null" );
		Assert.notNull( hydroPowerPlant.getHydroPowerPlantId(), "DeleteHydroPowerPlantCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a HydroPowerPlant
	 */
	public void validate( HydroPowerPlantFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "HydroPowerPlantFetchOneSummary should not be null" );
		Assert.notNull( summary.getHydroPowerPlantId(), "HydroPowerPlantFetchOneSummary identifier should not be null" );
	}



}
