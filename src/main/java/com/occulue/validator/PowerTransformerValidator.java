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

public class PowerTransformerValidator {
		
	/**
	 * default constructor
	 */
	protected PowerTransformerValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public PowerTransformerValidator getInstance() {
		return new PowerTransformerValidator();
	}
		
	/**
	 * handles creation validation for a PowerTransformer
	 */
	public void validate( CreatePowerTransformerCommand powerTransformer )throws Exception {
		Assert.notNull( powerTransformer, "CreatePowerTransformerCommand should not be null" );
//		Assert.isNull( powerTransformer.getPowerTransformerId(), "CreatePowerTransformerCommand identifier should be null" );
	}

	/**
	 * handles update validation for a PowerTransformer
	 */
	public void validate( UpdatePowerTransformerCommand powerTransformer ) throws Exception {
		Assert.notNull( powerTransformer, "UpdatePowerTransformerCommand should not be null" );
		Assert.notNull( powerTransformer.getPowerTransformerId(), "UpdatePowerTransformerCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a PowerTransformer
	 */
    public void validate( DeletePowerTransformerCommand powerTransformer ) throws Exception {
		Assert.notNull( powerTransformer, "{commandAlias} should not be null" );
		Assert.notNull( powerTransformer.getPowerTransformerId(), "DeletePowerTransformerCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a PowerTransformer
	 */
	public void validate( PowerTransformerFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "PowerTransformerFetchOneSummary should not be null" );
		Assert.notNull( summary.getPowerTransformerId(), "PowerTransformerFetchOneSummary identifier should not be null" );
	}



}
