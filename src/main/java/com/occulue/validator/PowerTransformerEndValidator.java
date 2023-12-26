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

public class PowerTransformerEndValidator {
		
	/**
	 * default constructor
	 */
	protected PowerTransformerEndValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public PowerTransformerEndValidator getInstance() {
		return new PowerTransformerEndValidator();
	}
		
	/**
	 * handles creation validation for a PowerTransformerEnd
	 */
	public void validate( CreatePowerTransformerEndCommand powerTransformerEnd )throws Exception {
		Assert.notNull( powerTransformerEnd, "CreatePowerTransformerEndCommand should not be null" );
//		Assert.isNull( powerTransformerEnd.getPowerTransformerEndId(), "CreatePowerTransformerEndCommand identifier should be null" );
	}

	/**
	 * handles update validation for a PowerTransformerEnd
	 */
	public void validate( UpdatePowerTransformerEndCommand powerTransformerEnd ) throws Exception {
		Assert.notNull( powerTransformerEnd, "UpdatePowerTransformerEndCommand should not be null" );
		Assert.notNull( powerTransformerEnd.getPowerTransformerEndId(), "UpdatePowerTransformerEndCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a PowerTransformerEnd
	 */
    public void validate( DeletePowerTransformerEndCommand powerTransformerEnd ) throws Exception {
		Assert.notNull( powerTransformerEnd, "{commandAlias} should not be null" );
		Assert.notNull( powerTransformerEnd.getPowerTransformerEndId(), "DeletePowerTransformerEndCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a PowerTransformerEnd
	 */
	public void validate( PowerTransformerEndFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "PowerTransformerEndFetchOneSummary should not be null" );
		Assert.notNull( summary.getPowerTransformerEndId(), "PowerTransformerEndFetchOneSummary identifier should not be null" );
	}



}
