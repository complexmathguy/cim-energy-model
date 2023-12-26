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

public class TemperatureValidator {
		
	/**
	 * default constructor
	 */
	protected TemperatureValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public TemperatureValidator getInstance() {
		return new TemperatureValidator();
	}
		
	/**
	 * handles creation validation for a Temperature
	 */
	public void validate( CreateTemperatureCommand temperature )throws Exception {
		Assert.notNull( temperature, "CreateTemperatureCommand should not be null" );
//		Assert.isNull( temperature.getTemperatureId(), "CreateTemperatureCommand identifier should be null" );
	}

	/**
	 * handles update validation for a Temperature
	 */
	public void validate( UpdateTemperatureCommand temperature ) throws Exception {
		Assert.notNull( temperature, "UpdateTemperatureCommand should not be null" );
		Assert.notNull( temperature.getTemperatureId(), "UpdateTemperatureCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a Temperature
	 */
    public void validate( DeleteTemperatureCommand temperature ) throws Exception {
		Assert.notNull( temperature, "{commandAlias} should not be null" );
		Assert.notNull( temperature.getTemperatureId(), "DeleteTemperatureCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a Temperature
	 */
	public void validate( TemperatureFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "TemperatureFetchOneSummary should not be null" );
		Assert.notNull( summary.getTemperatureId(), "TemperatureFetchOneSummary identifier should not be null" );
	}



}
