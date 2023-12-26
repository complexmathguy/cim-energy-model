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

public class MeasurementValueQualityValidator {
		
	/**
	 * default constructor
	 */
	protected MeasurementValueQualityValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public MeasurementValueQualityValidator getInstance() {
		return new MeasurementValueQualityValidator();
	}
		
	/**
	 * handles creation validation for a MeasurementValueQuality
	 */
	public void validate( CreateMeasurementValueQualityCommand measurementValueQuality )throws Exception {
		Assert.notNull( measurementValueQuality, "CreateMeasurementValueQualityCommand should not be null" );
//		Assert.isNull( measurementValueQuality.getMeasurementValueQualityId(), "CreateMeasurementValueQualityCommand identifier should be null" );
	}

	/**
	 * handles update validation for a MeasurementValueQuality
	 */
	public void validate( UpdateMeasurementValueQualityCommand measurementValueQuality ) throws Exception {
		Assert.notNull( measurementValueQuality, "UpdateMeasurementValueQualityCommand should not be null" );
		Assert.notNull( measurementValueQuality.getMeasurementValueQualityId(), "UpdateMeasurementValueQualityCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a MeasurementValueQuality
	 */
    public void validate( DeleteMeasurementValueQualityCommand measurementValueQuality ) throws Exception {
		Assert.notNull( measurementValueQuality, "{commandAlias} should not be null" );
		Assert.notNull( measurementValueQuality.getMeasurementValueQualityId(), "DeleteMeasurementValueQualityCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a MeasurementValueQuality
	 */
	public void validate( MeasurementValueQualityFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "MeasurementValueQualityFetchOneSummary should not be null" );
		Assert.notNull( summary.getMeasurementValueQualityId(), "MeasurementValueQualityFetchOneSummary identifier should not be null" );
	}



}
