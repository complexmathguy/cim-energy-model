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

public class SeriesCompensatorValidator {
		
	/**
	 * default constructor
	 */
	protected SeriesCompensatorValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public SeriesCompensatorValidator getInstance() {
		return new SeriesCompensatorValidator();
	}
		
	/**
	 * handles creation validation for a SeriesCompensator
	 */
	public void validate( CreateSeriesCompensatorCommand seriesCompensator )throws Exception {
		Assert.notNull( seriesCompensator, "CreateSeriesCompensatorCommand should not be null" );
//		Assert.isNull( seriesCompensator.getSeriesCompensatorId(), "CreateSeriesCompensatorCommand identifier should be null" );
	}

	/**
	 * handles update validation for a SeriesCompensator
	 */
	public void validate( UpdateSeriesCompensatorCommand seriesCompensator ) throws Exception {
		Assert.notNull( seriesCompensator, "UpdateSeriesCompensatorCommand should not be null" );
		Assert.notNull( seriesCompensator.getSeriesCompensatorId(), "UpdateSeriesCompensatorCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a SeriesCompensator
	 */
    public void validate( DeleteSeriesCompensatorCommand seriesCompensator ) throws Exception {
		Assert.notNull( seriesCompensator, "{commandAlias} should not be null" );
		Assert.notNull( seriesCompensator.getSeriesCompensatorId(), "DeleteSeriesCompensatorCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a SeriesCompensator
	 */
	public void validate( SeriesCompensatorFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "SeriesCompensatorFetchOneSummary should not be null" );
		Assert.notNull( summary.getSeriesCompensatorId(), "SeriesCompensatorFetchOneSummary identifier should not be null" );
	}



}
