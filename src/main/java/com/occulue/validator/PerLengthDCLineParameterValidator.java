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

public class PerLengthDCLineParameterValidator {
		
	/**
	 * default constructor
	 */
	protected PerLengthDCLineParameterValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public PerLengthDCLineParameterValidator getInstance() {
		return new PerLengthDCLineParameterValidator();
	}
		
	/**
	 * handles creation validation for a PerLengthDCLineParameter
	 */
	public void validate( CreatePerLengthDCLineParameterCommand perLengthDCLineParameter )throws Exception {
		Assert.notNull( perLengthDCLineParameter, "CreatePerLengthDCLineParameterCommand should not be null" );
//		Assert.isNull( perLengthDCLineParameter.getPerLengthDCLineParameterId(), "CreatePerLengthDCLineParameterCommand identifier should be null" );
	}

	/**
	 * handles update validation for a PerLengthDCLineParameter
	 */
	public void validate( UpdatePerLengthDCLineParameterCommand perLengthDCLineParameter ) throws Exception {
		Assert.notNull( perLengthDCLineParameter, "UpdatePerLengthDCLineParameterCommand should not be null" );
		Assert.notNull( perLengthDCLineParameter.getPerLengthDCLineParameterId(), "UpdatePerLengthDCLineParameterCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a PerLengthDCLineParameter
	 */
    public void validate( DeletePerLengthDCLineParameterCommand perLengthDCLineParameter ) throws Exception {
		Assert.notNull( perLengthDCLineParameter, "{commandAlias} should not be null" );
		Assert.notNull( perLengthDCLineParameter.getPerLengthDCLineParameterId(), "DeletePerLengthDCLineParameterCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a PerLengthDCLineParameter
	 */
	public void validate( PerLengthDCLineParameterFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "PerLengthDCLineParameterFetchOneSummary should not be null" );
		Assert.notNull( summary.getPerLengthDCLineParameterId(), "PerLengthDCLineParameterFetchOneSummary identifier should not be null" );
	}



}
