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

public class LoadUserDefinedValidator {
		
	/**
	 * default constructor
	 */
	protected LoadUserDefinedValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public LoadUserDefinedValidator getInstance() {
		return new LoadUserDefinedValidator();
	}
		
	/**
	 * handles creation validation for a LoadUserDefined
	 */
	public void validate( CreateLoadUserDefinedCommand loadUserDefined )throws Exception {
		Assert.notNull( loadUserDefined, "CreateLoadUserDefinedCommand should not be null" );
//		Assert.isNull( loadUserDefined.getLoadUserDefinedId(), "CreateLoadUserDefinedCommand identifier should be null" );
	}

	/**
	 * handles update validation for a LoadUserDefined
	 */
	public void validate( UpdateLoadUserDefinedCommand loadUserDefined ) throws Exception {
		Assert.notNull( loadUserDefined, "UpdateLoadUserDefinedCommand should not be null" );
		Assert.notNull( loadUserDefined.getLoadUserDefinedId(), "UpdateLoadUserDefinedCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a LoadUserDefined
	 */
    public void validate( DeleteLoadUserDefinedCommand loadUserDefined ) throws Exception {
		Assert.notNull( loadUserDefined, "{commandAlias} should not be null" );
		Assert.notNull( loadUserDefined.getLoadUserDefinedId(), "DeleteLoadUserDefinedCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a LoadUserDefined
	 */
	public void validate( LoadUserDefinedFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "LoadUserDefinedFetchOneSummary should not be null" );
		Assert.notNull( summary.getLoadUserDefinedId(), "LoadUserDefinedFetchOneSummary identifier should not be null" );
	}



}
