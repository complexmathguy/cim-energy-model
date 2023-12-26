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

public class UnderexcitationLimiterUserDefinedValidator {
		
	/**
	 * default constructor
	 */
	protected UnderexcitationLimiterUserDefinedValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public UnderexcitationLimiterUserDefinedValidator getInstance() {
		return new UnderexcitationLimiterUserDefinedValidator();
	}
		
	/**
	 * handles creation validation for a UnderexcitationLimiterUserDefined
	 */
	public void validate( CreateUnderexcitationLimiterUserDefinedCommand underexcitationLimiterUserDefined )throws Exception {
		Assert.notNull( underexcitationLimiterUserDefined, "CreateUnderexcitationLimiterUserDefinedCommand should not be null" );
//		Assert.isNull( underexcitationLimiterUserDefined.getUnderexcitationLimiterUserDefinedId(), "CreateUnderexcitationLimiterUserDefinedCommand identifier should be null" );
	}

	/**
	 * handles update validation for a UnderexcitationLimiterUserDefined
	 */
	public void validate( UpdateUnderexcitationLimiterUserDefinedCommand underexcitationLimiterUserDefined ) throws Exception {
		Assert.notNull( underexcitationLimiterUserDefined, "UpdateUnderexcitationLimiterUserDefinedCommand should not be null" );
		Assert.notNull( underexcitationLimiterUserDefined.getUnderexcitationLimiterUserDefinedId(), "UpdateUnderexcitationLimiterUserDefinedCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a UnderexcitationLimiterUserDefined
	 */
    public void validate( DeleteUnderexcitationLimiterUserDefinedCommand underexcitationLimiterUserDefined ) throws Exception {
		Assert.notNull( underexcitationLimiterUserDefined, "{commandAlias} should not be null" );
		Assert.notNull( underexcitationLimiterUserDefined.getUnderexcitationLimiterUserDefinedId(), "DeleteUnderexcitationLimiterUserDefinedCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a UnderexcitationLimiterUserDefined
	 */
	public void validate( UnderexcitationLimiterUserDefinedFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "UnderexcitationLimiterUserDefinedFetchOneSummary should not be null" );
		Assert.notNull( summary.getUnderexcitationLimiterUserDefinedId(), "UnderexcitationLimiterUserDefinedFetchOneSummary identifier should not be null" );
	}



}
