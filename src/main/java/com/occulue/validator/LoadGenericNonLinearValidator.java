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

public class LoadGenericNonLinearValidator {
		
	/**
	 * default constructor
	 */
	protected LoadGenericNonLinearValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public LoadGenericNonLinearValidator getInstance() {
		return new LoadGenericNonLinearValidator();
	}
		
	/**
	 * handles creation validation for a LoadGenericNonLinear
	 */
	public void validate( CreateLoadGenericNonLinearCommand loadGenericNonLinear )throws Exception {
		Assert.notNull( loadGenericNonLinear, "CreateLoadGenericNonLinearCommand should not be null" );
//		Assert.isNull( loadGenericNonLinear.getLoadGenericNonLinearId(), "CreateLoadGenericNonLinearCommand identifier should be null" );
	}

	/**
	 * handles update validation for a LoadGenericNonLinear
	 */
	public void validate( UpdateLoadGenericNonLinearCommand loadGenericNonLinear ) throws Exception {
		Assert.notNull( loadGenericNonLinear, "UpdateLoadGenericNonLinearCommand should not be null" );
		Assert.notNull( loadGenericNonLinear.getLoadGenericNonLinearId(), "UpdateLoadGenericNonLinearCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a LoadGenericNonLinear
	 */
    public void validate( DeleteLoadGenericNonLinearCommand loadGenericNonLinear ) throws Exception {
		Assert.notNull( loadGenericNonLinear, "{commandAlias} should not be null" );
		Assert.notNull( loadGenericNonLinear.getLoadGenericNonLinearId(), "DeleteLoadGenericNonLinearCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a LoadGenericNonLinear
	 */
	public void validate( LoadGenericNonLinearFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "LoadGenericNonLinearFetchOneSummary should not be null" );
		Assert.notNull( summary.getLoadGenericNonLinearId(), "LoadGenericNonLinearFetchOneSummary identifier should not be null" );
	}



}
