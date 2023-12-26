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

public class ReactiveCapabilityCurveValidator {
		
	/**
	 * default constructor
	 */
	protected ReactiveCapabilityCurveValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ReactiveCapabilityCurveValidator getInstance() {
		return new ReactiveCapabilityCurveValidator();
	}
		
	/**
	 * handles creation validation for a ReactiveCapabilityCurve
	 */
	public void validate( CreateReactiveCapabilityCurveCommand reactiveCapabilityCurve )throws Exception {
		Assert.notNull( reactiveCapabilityCurve, "CreateReactiveCapabilityCurveCommand should not be null" );
//		Assert.isNull( reactiveCapabilityCurve.getReactiveCapabilityCurveId(), "CreateReactiveCapabilityCurveCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ReactiveCapabilityCurve
	 */
	public void validate( UpdateReactiveCapabilityCurveCommand reactiveCapabilityCurve ) throws Exception {
		Assert.notNull( reactiveCapabilityCurve, "UpdateReactiveCapabilityCurveCommand should not be null" );
		Assert.notNull( reactiveCapabilityCurve.getReactiveCapabilityCurveId(), "UpdateReactiveCapabilityCurveCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ReactiveCapabilityCurve
	 */
    public void validate( DeleteReactiveCapabilityCurveCommand reactiveCapabilityCurve ) throws Exception {
		Assert.notNull( reactiveCapabilityCurve, "{commandAlias} should not be null" );
		Assert.notNull( reactiveCapabilityCurve.getReactiveCapabilityCurveId(), "DeleteReactiveCapabilityCurveCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ReactiveCapabilityCurve
	 */
	public void validate( ReactiveCapabilityCurveFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ReactiveCapabilityCurveFetchOneSummary should not be null" );
		Assert.notNull( summary.getReactiveCapabilityCurveId(), "ReactiveCapabilityCurveFetchOneSummary identifier should not be null" );
	}



}
