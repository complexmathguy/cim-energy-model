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

public class ControlAreaGeneratingUnitValidator {
		
	/**
	 * default constructor
	 */
	protected ControlAreaGeneratingUnitValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ControlAreaGeneratingUnitValidator getInstance() {
		return new ControlAreaGeneratingUnitValidator();
	}
		
	/**
	 * handles creation validation for a ControlAreaGeneratingUnit
	 */
	public void validate( CreateControlAreaGeneratingUnitCommand controlAreaGeneratingUnit )throws Exception {
		Assert.notNull( controlAreaGeneratingUnit, "CreateControlAreaGeneratingUnitCommand should not be null" );
//		Assert.isNull( controlAreaGeneratingUnit.getControlAreaGeneratingUnitId(), "CreateControlAreaGeneratingUnitCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ControlAreaGeneratingUnit
	 */
	public void validate( UpdateControlAreaGeneratingUnitCommand controlAreaGeneratingUnit ) throws Exception {
		Assert.notNull( controlAreaGeneratingUnit, "UpdateControlAreaGeneratingUnitCommand should not be null" );
		Assert.notNull( controlAreaGeneratingUnit.getControlAreaGeneratingUnitId(), "UpdateControlAreaGeneratingUnitCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ControlAreaGeneratingUnit
	 */
    public void validate( DeleteControlAreaGeneratingUnitCommand controlAreaGeneratingUnit ) throws Exception {
		Assert.notNull( controlAreaGeneratingUnit, "{commandAlias} should not be null" );
		Assert.notNull( controlAreaGeneratingUnit.getControlAreaGeneratingUnitId(), "DeleteControlAreaGeneratingUnitCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ControlAreaGeneratingUnit
	 */
	public void validate( ControlAreaGeneratingUnitFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ControlAreaGeneratingUnitFetchOneSummary should not be null" );
		Assert.notNull( summary.getControlAreaGeneratingUnitId(), "ControlAreaGeneratingUnitFetchOneSummary identifier should not be null" );
	}



}
