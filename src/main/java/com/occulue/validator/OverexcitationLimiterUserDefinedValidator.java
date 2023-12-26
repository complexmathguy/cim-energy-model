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

public class OverexcitationLimiterUserDefinedValidator {
		
	/**
	 * default constructor
	 */
	protected OverexcitationLimiterUserDefinedValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public OverexcitationLimiterUserDefinedValidator getInstance() {
		return new OverexcitationLimiterUserDefinedValidator();
	}
		
	/**
	 * handles creation validation for a OverexcitationLimiterUserDefined
	 */
	public void validate( CreateOverexcitationLimiterUserDefinedCommand overexcitationLimiterUserDefined )throws Exception {
		Assert.notNull( overexcitationLimiterUserDefined, "CreateOverexcitationLimiterUserDefinedCommand should not be null" );
//		Assert.isNull( overexcitationLimiterUserDefined.getOverexcitationLimiterUserDefinedId(), "CreateOverexcitationLimiterUserDefinedCommand identifier should be null" );
	}

	/**
	 * handles update validation for a OverexcitationLimiterUserDefined
	 */
	public void validate( UpdateOverexcitationLimiterUserDefinedCommand overexcitationLimiterUserDefined ) throws Exception {
		Assert.notNull( overexcitationLimiterUserDefined, "UpdateOverexcitationLimiterUserDefinedCommand should not be null" );
		Assert.notNull( overexcitationLimiterUserDefined.getOverexcitationLimiterUserDefinedId(), "UpdateOverexcitationLimiterUserDefinedCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a OverexcitationLimiterUserDefined
	 */
    public void validate( DeleteOverexcitationLimiterUserDefinedCommand overexcitationLimiterUserDefined ) throws Exception {
		Assert.notNull( overexcitationLimiterUserDefined, "{commandAlias} should not be null" );
		Assert.notNull( overexcitationLimiterUserDefined.getOverexcitationLimiterUserDefinedId(), "DeleteOverexcitationLimiterUserDefinedCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a OverexcitationLimiterUserDefined
	 */
	public void validate( OverexcitationLimiterUserDefinedFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "OverexcitationLimiterUserDefinedFetchOneSummary should not be null" );
		Assert.notNull( summary.getOverexcitationLimiterUserDefinedId(), "OverexcitationLimiterUserDefinedFetchOneSummary identifier should not be null" );
	}



}
