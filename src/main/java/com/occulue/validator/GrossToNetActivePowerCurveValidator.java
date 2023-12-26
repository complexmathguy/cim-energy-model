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

public class GrossToNetActivePowerCurveValidator {
		
	/**
	 * default constructor
	 */
	protected GrossToNetActivePowerCurveValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public GrossToNetActivePowerCurveValidator getInstance() {
		return new GrossToNetActivePowerCurveValidator();
	}
		
	/**
	 * handles creation validation for a GrossToNetActivePowerCurve
	 */
	public void validate( CreateGrossToNetActivePowerCurveCommand grossToNetActivePowerCurve )throws Exception {
		Assert.notNull( grossToNetActivePowerCurve, "CreateGrossToNetActivePowerCurveCommand should not be null" );
//		Assert.isNull( grossToNetActivePowerCurve.getGrossToNetActivePowerCurveId(), "CreateGrossToNetActivePowerCurveCommand identifier should be null" );
	}

	/**
	 * handles update validation for a GrossToNetActivePowerCurve
	 */
	public void validate( UpdateGrossToNetActivePowerCurveCommand grossToNetActivePowerCurve ) throws Exception {
		Assert.notNull( grossToNetActivePowerCurve, "UpdateGrossToNetActivePowerCurveCommand should not be null" );
		Assert.notNull( grossToNetActivePowerCurve.getGrossToNetActivePowerCurveId(), "UpdateGrossToNetActivePowerCurveCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a GrossToNetActivePowerCurve
	 */
    public void validate( DeleteGrossToNetActivePowerCurveCommand grossToNetActivePowerCurve ) throws Exception {
		Assert.notNull( grossToNetActivePowerCurve, "{commandAlias} should not be null" );
		Assert.notNull( grossToNetActivePowerCurve.getGrossToNetActivePowerCurveId(), "DeleteGrossToNetActivePowerCurveCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a GrossToNetActivePowerCurve
	 */
	public void validate( GrossToNetActivePowerCurveFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GrossToNetActivePowerCurveFetchOneSummary should not be null" );
		Assert.notNull( summary.getGrossToNetActivePowerCurveId(), "GrossToNetActivePowerCurveFetchOneSummary identifier should not be null" );
	}



}
