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

public class VsCapabilityCurveValidator {
		
	/**
	 * default constructor
	 */
	protected VsCapabilityCurveValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public VsCapabilityCurveValidator getInstance() {
		return new VsCapabilityCurveValidator();
	}
		
	/**
	 * handles creation validation for a VsCapabilityCurve
	 */
	public void validate( CreateVsCapabilityCurveCommand vsCapabilityCurve )throws Exception {
		Assert.notNull( vsCapabilityCurve, "CreateVsCapabilityCurveCommand should not be null" );
//		Assert.isNull( vsCapabilityCurve.getVsCapabilityCurveId(), "CreateVsCapabilityCurveCommand identifier should be null" );
	}

	/**
	 * handles update validation for a VsCapabilityCurve
	 */
	public void validate( UpdateVsCapabilityCurveCommand vsCapabilityCurve ) throws Exception {
		Assert.notNull( vsCapabilityCurve, "UpdateVsCapabilityCurveCommand should not be null" );
		Assert.notNull( vsCapabilityCurve.getVsCapabilityCurveId(), "UpdateVsCapabilityCurveCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a VsCapabilityCurve
	 */
    public void validate( DeleteVsCapabilityCurveCommand vsCapabilityCurve ) throws Exception {
		Assert.notNull( vsCapabilityCurve, "{commandAlias} should not be null" );
		Assert.notNull( vsCapabilityCurve.getVsCapabilityCurveId(), "DeleteVsCapabilityCurveCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a VsCapabilityCurve
	 */
	public void validate( VsCapabilityCurveFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "VsCapabilityCurveFetchOneSummary should not be null" );
		Assert.notNull( summary.getVsCapabilityCurveId(), "VsCapabilityCurveFetchOneSummary identifier should not be null" );
	}



}
