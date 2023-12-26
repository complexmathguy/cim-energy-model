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

public class GeneratingUnitValidator {
		
	/**
	 * default constructor
	 */
	protected GeneratingUnitValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public GeneratingUnitValidator getInstance() {
		return new GeneratingUnitValidator();
	}
		
	/**
	 * handles creation validation for a GeneratingUnit
	 */
	public void validate( CreateGeneratingUnitCommand generatingUnit )throws Exception {
		Assert.notNull( generatingUnit, "CreateGeneratingUnitCommand should not be null" );
//		Assert.isNull( generatingUnit.getGeneratingUnitId(), "CreateGeneratingUnitCommand identifier should be null" );
	}

	/**
	 * handles update validation for a GeneratingUnit
	 */
	public void validate( UpdateGeneratingUnitCommand generatingUnit ) throws Exception {
		Assert.notNull( generatingUnit, "UpdateGeneratingUnitCommand should not be null" );
		Assert.notNull( generatingUnit.getGeneratingUnitId(), "UpdateGeneratingUnitCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a GeneratingUnit
	 */
    public void validate( DeleteGeneratingUnitCommand generatingUnit ) throws Exception {
		Assert.notNull( generatingUnit, "{commandAlias} should not be null" );
		Assert.notNull( generatingUnit.getGeneratingUnitId(), "DeleteGeneratingUnitCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a GeneratingUnit
	 */
	public void validate( GeneratingUnitFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GeneratingUnitFetchOneSummary should not be null" );
		Assert.notNull( summary.getGeneratingUnitId(), "GeneratingUnitFetchOneSummary identifier should not be null" );
	}



}
