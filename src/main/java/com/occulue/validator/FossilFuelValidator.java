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

public class FossilFuelValidator {
		
	/**
	 * default constructor
	 */
	protected FossilFuelValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public FossilFuelValidator getInstance() {
		return new FossilFuelValidator();
	}
		
	/**
	 * handles creation validation for a FossilFuel
	 */
	public void validate( CreateFossilFuelCommand fossilFuel )throws Exception {
		Assert.notNull( fossilFuel, "CreateFossilFuelCommand should not be null" );
//		Assert.isNull( fossilFuel.getFossilFuelId(), "CreateFossilFuelCommand identifier should be null" );
	}

	/**
	 * handles update validation for a FossilFuel
	 */
	public void validate( UpdateFossilFuelCommand fossilFuel ) throws Exception {
		Assert.notNull( fossilFuel, "UpdateFossilFuelCommand should not be null" );
		Assert.notNull( fossilFuel.getFossilFuelId(), "UpdateFossilFuelCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a FossilFuel
	 */
    public void validate( DeleteFossilFuelCommand fossilFuel ) throws Exception {
		Assert.notNull( fossilFuel, "{commandAlias} should not be null" );
		Assert.notNull( fossilFuel.getFossilFuelId(), "DeleteFossilFuelCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a FossilFuel
	 */
	public void validate( FossilFuelFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "FossilFuelFetchOneSummary should not be null" );
		Assert.notNull( summary.getFossilFuelId(), "FossilFuelFetchOneSummary identifier should not be null" );
	}



}
