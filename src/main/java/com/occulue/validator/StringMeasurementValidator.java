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

public class StringMeasurementValidator {
		
	/**
	 * default constructor
	 */
	protected StringMeasurementValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public StringMeasurementValidator getInstance() {
		return new StringMeasurementValidator();
	}
		
	/**
	 * handles creation validation for a StringMeasurement
	 */
	public void validate( CreateStringMeasurementCommand stringMeasurement )throws Exception {
		Assert.notNull( stringMeasurement, "CreateStringMeasurementCommand should not be null" );
//		Assert.isNull( stringMeasurement.getStringMeasurementId(), "CreateStringMeasurementCommand identifier should be null" );
	}

	/**
	 * handles update validation for a StringMeasurement
	 */
	public void validate( UpdateStringMeasurementCommand stringMeasurement ) throws Exception {
		Assert.notNull( stringMeasurement, "UpdateStringMeasurementCommand should not be null" );
		Assert.notNull( stringMeasurement.getStringMeasurementId(), "UpdateStringMeasurementCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a StringMeasurement
	 */
    public void validate( DeleteStringMeasurementCommand stringMeasurement ) throws Exception {
		Assert.notNull( stringMeasurement, "{commandAlias} should not be null" );
		Assert.notNull( stringMeasurement.getStringMeasurementId(), "DeleteStringMeasurementCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a StringMeasurement
	 */
	public void validate( StringMeasurementFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "StringMeasurementFetchOneSummary should not be null" );
		Assert.notNull( summary.getStringMeasurementId(), "StringMeasurementFetchOneSummary identifier should not be null" );
	}



}
