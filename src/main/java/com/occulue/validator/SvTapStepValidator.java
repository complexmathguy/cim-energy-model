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

public class SvTapStepValidator {
		
	/**
	 * default constructor
	 */
	protected SvTapStepValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public SvTapStepValidator getInstance() {
		return new SvTapStepValidator();
	}
		
	/**
	 * handles creation validation for a SvTapStep
	 */
	public void validate( CreateSvTapStepCommand svTapStep )throws Exception {
		Assert.notNull( svTapStep, "CreateSvTapStepCommand should not be null" );
//		Assert.isNull( svTapStep.getSvTapStepId(), "CreateSvTapStepCommand identifier should be null" );
	}

	/**
	 * handles update validation for a SvTapStep
	 */
	public void validate( UpdateSvTapStepCommand svTapStep ) throws Exception {
		Assert.notNull( svTapStep, "UpdateSvTapStepCommand should not be null" );
		Assert.notNull( svTapStep.getSvTapStepId(), "UpdateSvTapStepCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a SvTapStep
	 */
    public void validate( DeleteSvTapStepCommand svTapStep ) throws Exception {
		Assert.notNull( svTapStep, "{commandAlias} should not be null" );
		Assert.notNull( svTapStep.getSvTapStepId(), "DeleteSvTapStepCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a SvTapStep
	 */
	public void validate( SvTapStepFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "SvTapStepFetchOneSummary should not be null" );
		Assert.notNull( summary.getSvTapStepId(), "SvTapStepFetchOneSummary identifier should not be null" );
	}



}
