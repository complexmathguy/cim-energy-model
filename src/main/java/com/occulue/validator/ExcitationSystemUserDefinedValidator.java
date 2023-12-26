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

public class ExcitationSystemUserDefinedValidator {
		
	/**
	 * default constructor
	 */
	protected ExcitationSystemUserDefinedValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcitationSystemUserDefinedValidator getInstance() {
		return new ExcitationSystemUserDefinedValidator();
	}
		
	/**
	 * handles creation validation for a ExcitationSystemUserDefined
	 */
	public void validate( CreateExcitationSystemUserDefinedCommand excitationSystemUserDefined )throws Exception {
		Assert.notNull( excitationSystemUserDefined, "CreateExcitationSystemUserDefinedCommand should not be null" );
//		Assert.isNull( excitationSystemUserDefined.getExcitationSystemUserDefinedId(), "CreateExcitationSystemUserDefinedCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcitationSystemUserDefined
	 */
	public void validate( UpdateExcitationSystemUserDefinedCommand excitationSystemUserDefined ) throws Exception {
		Assert.notNull( excitationSystemUserDefined, "UpdateExcitationSystemUserDefinedCommand should not be null" );
		Assert.notNull( excitationSystemUserDefined.getExcitationSystemUserDefinedId(), "UpdateExcitationSystemUserDefinedCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcitationSystemUserDefined
	 */
    public void validate( DeleteExcitationSystemUserDefinedCommand excitationSystemUserDefined ) throws Exception {
		Assert.notNull( excitationSystemUserDefined, "{commandAlias} should not be null" );
		Assert.notNull( excitationSystemUserDefined.getExcitationSystemUserDefinedId(), "DeleteExcitationSystemUserDefinedCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcitationSystemUserDefined
	 */
	public void validate( ExcitationSystemUserDefinedFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcitationSystemUserDefinedFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcitationSystemUserDefinedId(), "ExcitationSystemUserDefinedFetchOneSummary identifier should not be null" );
	}



}
