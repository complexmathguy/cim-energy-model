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

public class WindPlantUserDefinedValidator {
		
	/**
	 * default constructor
	 */
	protected WindPlantUserDefinedValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public WindPlantUserDefinedValidator getInstance() {
		return new WindPlantUserDefinedValidator();
	}
		
	/**
	 * handles creation validation for a WindPlantUserDefined
	 */
	public void validate( CreateWindPlantUserDefinedCommand windPlantUserDefined )throws Exception {
		Assert.notNull( windPlantUserDefined, "CreateWindPlantUserDefinedCommand should not be null" );
//		Assert.isNull( windPlantUserDefined.getWindPlantUserDefinedId(), "CreateWindPlantUserDefinedCommand identifier should be null" );
	}

	/**
	 * handles update validation for a WindPlantUserDefined
	 */
	public void validate( UpdateWindPlantUserDefinedCommand windPlantUserDefined ) throws Exception {
		Assert.notNull( windPlantUserDefined, "UpdateWindPlantUserDefinedCommand should not be null" );
		Assert.notNull( windPlantUserDefined.getWindPlantUserDefinedId(), "UpdateWindPlantUserDefinedCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a WindPlantUserDefined
	 */
    public void validate( DeleteWindPlantUserDefinedCommand windPlantUserDefined ) throws Exception {
		Assert.notNull( windPlantUserDefined, "{commandAlias} should not be null" );
		Assert.notNull( windPlantUserDefined.getWindPlantUserDefinedId(), "DeleteWindPlantUserDefinedCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a WindPlantUserDefined
	 */
	public void validate( WindPlantUserDefinedFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "WindPlantUserDefinedFetchOneSummary should not be null" );
		Assert.notNull( summary.getWindPlantUserDefinedId(), "WindPlantUserDefinedFetchOneSummary identifier should not be null" );
	}



}
