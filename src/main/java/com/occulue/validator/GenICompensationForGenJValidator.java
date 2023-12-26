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

public class GenICompensationForGenJValidator {
		
	/**
	 * default constructor
	 */
	protected GenICompensationForGenJValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public GenICompensationForGenJValidator getInstance() {
		return new GenICompensationForGenJValidator();
	}
		
	/**
	 * handles creation validation for a GenICompensationForGenJ
	 */
	public void validate( CreateGenICompensationForGenJCommand genICompensationForGenJ )throws Exception {
		Assert.notNull( genICompensationForGenJ, "CreateGenICompensationForGenJCommand should not be null" );
//		Assert.isNull( genICompensationForGenJ.getGenICompensationForGenJId(), "CreateGenICompensationForGenJCommand identifier should be null" );
	}

	/**
	 * handles update validation for a GenICompensationForGenJ
	 */
	public void validate( UpdateGenICompensationForGenJCommand genICompensationForGenJ ) throws Exception {
		Assert.notNull( genICompensationForGenJ, "UpdateGenICompensationForGenJCommand should not be null" );
		Assert.notNull( genICompensationForGenJ.getGenICompensationForGenJId(), "UpdateGenICompensationForGenJCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a GenICompensationForGenJ
	 */
    public void validate( DeleteGenICompensationForGenJCommand genICompensationForGenJ ) throws Exception {
		Assert.notNull( genICompensationForGenJ, "{commandAlias} should not be null" );
		Assert.notNull( genICompensationForGenJ.getGenICompensationForGenJId(), "DeleteGenICompensationForGenJCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a GenICompensationForGenJ
	 */
	public void validate( GenICompensationForGenJFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GenICompensationForGenJFetchOneSummary should not be null" );
		Assert.notNull( summary.getGenICompensationForGenJId(), "GenICompensationForGenJFetchOneSummary identifier should not be null" );
	}



}
