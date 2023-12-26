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

public class WindGeneratingUnitValidator {
		
	/**
	 * default constructor
	 */
	protected WindGeneratingUnitValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public WindGeneratingUnitValidator getInstance() {
		return new WindGeneratingUnitValidator();
	}
		
	/**
	 * handles creation validation for a WindGeneratingUnit
	 */
	public void validate( CreateWindGeneratingUnitCommand windGeneratingUnit )throws Exception {
		Assert.notNull( windGeneratingUnit, "CreateWindGeneratingUnitCommand should not be null" );
//		Assert.isNull( windGeneratingUnit.getWindGeneratingUnitId(), "CreateWindGeneratingUnitCommand identifier should be null" );
	}

	/**
	 * handles update validation for a WindGeneratingUnit
	 */
	public void validate( UpdateWindGeneratingUnitCommand windGeneratingUnit ) throws Exception {
		Assert.notNull( windGeneratingUnit, "UpdateWindGeneratingUnitCommand should not be null" );
		Assert.notNull( windGeneratingUnit.getWindGeneratingUnitId(), "UpdateWindGeneratingUnitCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a WindGeneratingUnit
	 */
    public void validate( DeleteWindGeneratingUnitCommand windGeneratingUnit ) throws Exception {
		Assert.notNull( windGeneratingUnit, "{commandAlias} should not be null" );
		Assert.notNull( windGeneratingUnit.getWindGeneratingUnitId(), "DeleteWindGeneratingUnitCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a WindGeneratingUnit
	 */
	public void validate( WindGeneratingUnitFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "WindGeneratingUnitFetchOneSummary should not be null" );
		Assert.notNull( summary.getWindGeneratingUnitId(), "WindGeneratingUnitFetchOneSummary identifier should not be null" );
	}



}
