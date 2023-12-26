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

public class DiscontinuousExcitationControlUserDefinedValidator {
		
	/**
	 * default constructor
	 */
	protected DiscontinuousExcitationControlUserDefinedValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public DiscontinuousExcitationControlUserDefinedValidator getInstance() {
		return new DiscontinuousExcitationControlUserDefinedValidator();
	}
		
	/**
	 * handles creation validation for a DiscontinuousExcitationControlUserDefined
	 */
	public void validate( CreateDiscontinuousExcitationControlUserDefinedCommand discontinuousExcitationControlUserDefined )throws Exception {
		Assert.notNull( discontinuousExcitationControlUserDefined, "CreateDiscontinuousExcitationControlUserDefinedCommand should not be null" );
//		Assert.isNull( discontinuousExcitationControlUserDefined.getDiscontinuousExcitationControlUserDefinedId(), "CreateDiscontinuousExcitationControlUserDefinedCommand identifier should be null" );
	}

	/**
	 * handles update validation for a DiscontinuousExcitationControlUserDefined
	 */
	public void validate( UpdateDiscontinuousExcitationControlUserDefinedCommand discontinuousExcitationControlUserDefined ) throws Exception {
		Assert.notNull( discontinuousExcitationControlUserDefined, "UpdateDiscontinuousExcitationControlUserDefinedCommand should not be null" );
		Assert.notNull( discontinuousExcitationControlUserDefined.getDiscontinuousExcitationControlUserDefinedId(), "UpdateDiscontinuousExcitationControlUserDefinedCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a DiscontinuousExcitationControlUserDefined
	 */
    public void validate( DeleteDiscontinuousExcitationControlUserDefinedCommand discontinuousExcitationControlUserDefined ) throws Exception {
		Assert.notNull( discontinuousExcitationControlUserDefined, "{commandAlias} should not be null" );
		Assert.notNull( discontinuousExcitationControlUserDefined.getDiscontinuousExcitationControlUserDefinedId(), "DeleteDiscontinuousExcitationControlUserDefinedCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a DiscontinuousExcitationControlUserDefined
	 */
	public void validate( DiscontinuousExcitationControlUserDefinedFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "DiscontinuousExcitationControlUserDefinedFetchOneSummary should not be null" );
		Assert.notNull( summary.getDiscontinuousExcitationControlUserDefinedId(), "DiscontinuousExcitationControlUserDefinedFetchOneSummary identifier should not be null" );
	}



}
