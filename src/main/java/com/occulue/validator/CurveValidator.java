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

public class CurveValidator {
		
	/**
	 * default constructor
	 */
	protected CurveValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public CurveValidator getInstance() {
		return new CurveValidator();
	}
		
	/**
	 * handles creation validation for a Curve
	 */
	public void validate( CreateCurveCommand curve )throws Exception {
		Assert.notNull( curve, "CreateCurveCommand should not be null" );
//		Assert.isNull( curve.getCurveId(), "CreateCurveCommand identifier should be null" );
	}

	/**
	 * handles update validation for a Curve
	 */
	public void validate( UpdateCurveCommand curve ) throws Exception {
		Assert.notNull( curve, "UpdateCurveCommand should not be null" );
		Assert.notNull( curve.getCurveId(), "UpdateCurveCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a Curve
	 */
    public void validate( DeleteCurveCommand curve ) throws Exception {
		Assert.notNull( curve, "{commandAlias} should not be null" );
		Assert.notNull( curve.getCurveId(), "DeleteCurveCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a Curve
	 */
	public void validate( CurveFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "CurveFetchOneSummary should not be null" );
		Assert.notNull( summary.getCurveId(), "CurveFetchOneSummary identifier should not be null" );
	}



}
