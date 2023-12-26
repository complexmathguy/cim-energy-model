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

public class StaticVarCompensatorValidator {
		
	/**
	 * default constructor
	 */
	protected StaticVarCompensatorValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public StaticVarCompensatorValidator getInstance() {
		return new StaticVarCompensatorValidator();
	}
		
	/**
	 * handles creation validation for a StaticVarCompensator
	 */
	public void validate( CreateStaticVarCompensatorCommand staticVarCompensator )throws Exception {
		Assert.notNull( staticVarCompensator, "CreateStaticVarCompensatorCommand should not be null" );
//		Assert.isNull( staticVarCompensator.getStaticVarCompensatorId(), "CreateStaticVarCompensatorCommand identifier should be null" );
	}

	/**
	 * handles update validation for a StaticVarCompensator
	 */
	public void validate( UpdateStaticVarCompensatorCommand staticVarCompensator ) throws Exception {
		Assert.notNull( staticVarCompensator, "UpdateStaticVarCompensatorCommand should not be null" );
		Assert.notNull( staticVarCompensator.getStaticVarCompensatorId(), "UpdateStaticVarCompensatorCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a StaticVarCompensator
	 */
    public void validate( DeleteStaticVarCompensatorCommand staticVarCompensator ) throws Exception {
		Assert.notNull( staticVarCompensator, "{commandAlias} should not be null" );
		Assert.notNull( staticVarCompensator.getStaticVarCompensatorId(), "DeleteStaticVarCompensatorCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a StaticVarCompensator
	 */
	public void validate( StaticVarCompensatorFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "StaticVarCompensatorFetchOneSummary should not be null" );
		Assert.notNull( summary.getStaticVarCompensatorId(), "StaticVarCompensatorFetchOneSummary identifier should not be null" );
	}



}
