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

public class HydroGeneratingUnitValidator {
		
	/**
	 * default constructor
	 */
	protected HydroGeneratingUnitValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public HydroGeneratingUnitValidator getInstance() {
		return new HydroGeneratingUnitValidator();
	}
		
	/**
	 * handles creation validation for a HydroGeneratingUnit
	 */
	public void validate( CreateHydroGeneratingUnitCommand hydroGeneratingUnit )throws Exception {
		Assert.notNull( hydroGeneratingUnit, "CreateHydroGeneratingUnitCommand should not be null" );
//		Assert.isNull( hydroGeneratingUnit.getHydroGeneratingUnitId(), "CreateHydroGeneratingUnitCommand identifier should be null" );
	}

	/**
	 * handles update validation for a HydroGeneratingUnit
	 */
	public void validate( UpdateHydroGeneratingUnitCommand hydroGeneratingUnit ) throws Exception {
		Assert.notNull( hydroGeneratingUnit, "UpdateHydroGeneratingUnitCommand should not be null" );
		Assert.notNull( hydroGeneratingUnit.getHydroGeneratingUnitId(), "UpdateHydroGeneratingUnitCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a HydroGeneratingUnit
	 */
    public void validate( DeleteHydroGeneratingUnitCommand hydroGeneratingUnit ) throws Exception {
		Assert.notNull( hydroGeneratingUnit, "{commandAlias} should not be null" );
		Assert.notNull( hydroGeneratingUnit.getHydroGeneratingUnitId(), "DeleteHydroGeneratingUnitCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a HydroGeneratingUnit
	 */
	public void validate( HydroGeneratingUnitFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "HydroGeneratingUnitFetchOneSummary should not be null" );
		Assert.notNull( summary.getHydroGeneratingUnitId(), "HydroGeneratingUnitFetchOneSummary identifier should not be null" );
	}



}
