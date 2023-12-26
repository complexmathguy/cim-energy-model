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

public class HydroPumpValidator {
		
	/**
	 * default constructor
	 */
	protected HydroPumpValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public HydroPumpValidator getInstance() {
		return new HydroPumpValidator();
	}
		
	/**
	 * handles creation validation for a HydroPump
	 */
	public void validate( CreateHydroPumpCommand hydroPump )throws Exception {
		Assert.notNull( hydroPump, "CreateHydroPumpCommand should not be null" );
//		Assert.isNull( hydroPump.getHydroPumpId(), "CreateHydroPumpCommand identifier should be null" );
	}

	/**
	 * handles update validation for a HydroPump
	 */
	public void validate( UpdateHydroPumpCommand hydroPump ) throws Exception {
		Assert.notNull( hydroPump, "UpdateHydroPumpCommand should not be null" );
		Assert.notNull( hydroPump.getHydroPumpId(), "UpdateHydroPumpCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a HydroPump
	 */
    public void validate( DeleteHydroPumpCommand hydroPump ) throws Exception {
		Assert.notNull( hydroPump, "{commandAlias} should not be null" );
		Assert.notNull( hydroPump.getHydroPumpId(), "DeleteHydroPumpCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a HydroPump
	 */
	public void validate( HydroPumpFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "HydroPumpFetchOneSummary should not be null" );
		Assert.notNull( summary.getHydroPumpId(), "HydroPumpFetchOneSummary identifier should not be null" );
	}



}
