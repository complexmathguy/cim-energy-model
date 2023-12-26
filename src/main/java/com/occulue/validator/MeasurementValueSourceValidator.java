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

public class MeasurementValueSourceValidator {
		
	/**
	 * default constructor
	 */
	protected MeasurementValueSourceValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public MeasurementValueSourceValidator getInstance() {
		return new MeasurementValueSourceValidator();
	}
		
	/**
	 * handles creation validation for a MeasurementValueSource
	 */
	public void validate( CreateMeasurementValueSourceCommand measurementValueSource )throws Exception {
		Assert.notNull( measurementValueSource, "CreateMeasurementValueSourceCommand should not be null" );
//		Assert.isNull( measurementValueSource.getMeasurementValueSourceId(), "CreateMeasurementValueSourceCommand identifier should be null" );
	}

	/**
	 * handles update validation for a MeasurementValueSource
	 */
	public void validate( UpdateMeasurementValueSourceCommand measurementValueSource ) throws Exception {
		Assert.notNull( measurementValueSource, "UpdateMeasurementValueSourceCommand should not be null" );
		Assert.notNull( measurementValueSource.getMeasurementValueSourceId(), "UpdateMeasurementValueSourceCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a MeasurementValueSource
	 */
    public void validate( DeleteMeasurementValueSourceCommand measurementValueSource ) throws Exception {
		Assert.notNull( measurementValueSource, "{commandAlias} should not be null" );
		Assert.notNull( measurementValueSource.getMeasurementValueSourceId(), "DeleteMeasurementValueSourceCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a MeasurementValueSource
	 */
	public void validate( MeasurementValueSourceFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "MeasurementValueSourceFetchOneSummary should not be null" );
		Assert.notNull( summary.getMeasurementValueSourceId(), "MeasurementValueSourceFetchOneSummary identifier should not be null" );
	}



}
