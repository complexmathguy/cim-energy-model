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

public class SteadyStateHypothesisVersionValidator {
		
	/**
	 * default constructor
	 */
	protected SteadyStateHypothesisVersionValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public SteadyStateHypothesisVersionValidator getInstance() {
		return new SteadyStateHypothesisVersionValidator();
	}
		
	/**
	 * handles creation validation for a SteadyStateHypothesisVersion
	 */
	public void validate( CreateSteadyStateHypothesisVersionCommand steadyStateHypothesisVersion )throws Exception {
		Assert.notNull( steadyStateHypothesisVersion, "CreateSteadyStateHypothesisVersionCommand should not be null" );
//		Assert.isNull( steadyStateHypothesisVersion.getSteadyStateHypothesisVersionId(), "CreateSteadyStateHypothesisVersionCommand identifier should be null" );
	}

	/**
	 * handles update validation for a SteadyStateHypothesisVersion
	 */
	public void validate( UpdateSteadyStateHypothesisVersionCommand steadyStateHypothesisVersion ) throws Exception {
		Assert.notNull( steadyStateHypothesisVersion, "UpdateSteadyStateHypothesisVersionCommand should not be null" );
		Assert.notNull( steadyStateHypothesisVersion.getSteadyStateHypothesisVersionId(), "UpdateSteadyStateHypothesisVersionCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a SteadyStateHypothesisVersion
	 */
    public void validate( DeleteSteadyStateHypothesisVersionCommand steadyStateHypothesisVersion ) throws Exception {
		Assert.notNull( steadyStateHypothesisVersion, "{commandAlias} should not be null" );
		Assert.notNull( steadyStateHypothesisVersion.getSteadyStateHypothesisVersionId(), "DeleteSteadyStateHypothesisVersionCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a SteadyStateHypothesisVersion
	 */
	public void validate( SteadyStateHypothesisVersionFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "SteadyStateHypothesisVersionFetchOneSummary should not be null" );
		Assert.notNull( summary.getSteadyStateHypothesisVersionId(), "SteadyStateHypothesisVersionFetchOneSummary identifier should not be null" );
	}



}
