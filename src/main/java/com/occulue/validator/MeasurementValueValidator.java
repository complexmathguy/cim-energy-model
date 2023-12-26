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

public class MeasurementValueValidator {
		
	/**
	 * default constructor
	 */
	protected MeasurementValueValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public MeasurementValueValidator getInstance() {
		return new MeasurementValueValidator();
	}
		
	/**
	 * handles creation validation for a MeasurementValue
	 */
	public void validate( CreateMeasurementValueCommand measurementValue )throws Exception {
		Assert.notNull( measurementValue, "CreateMeasurementValueCommand should not be null" );
//		Assert.isNull( measurementValue.getMeasurementValueId(), "CreateMeasurementValueCommand identifier should be null" );
	}

	/**
	 * handles update validation for a MeasurementValue
	 */
	public void validate( UpdateMeasurementValueCommand measurementValue ) throws Exception {
		Assert.notNull( measurementValue, "UpdateMeasurementValueCommand should not be null" );
		Assert.notNull( measurementValue.getMeasurementValueId(), "UpdateMeasurementValueCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a MeasurementValue
	 */
    public void validate( DeleteMeasurementValueCommand measurementValue ) throws Exception {
		Assert.notNull( measurementValue, "{commandAlias} should not be null" );
		Assert.notNull( measurementValue.getMeasurementValueId(), "DeleteMeasurementValueCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a MeasurementValue
	 */
	public void validate( MeasurementValueFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "MeasurementValueFetchOneSummary should not be null" );
		Assert.notNull( summary.getMeasurementValueId(), "MeasurementValueFetchOneSummary identifier should not be null" );
	}



}
