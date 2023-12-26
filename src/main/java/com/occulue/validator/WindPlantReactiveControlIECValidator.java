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

public class WindPlantReactiveControlIECValidator {
		
	/**
	 * default constructor
	 */
	protected WindPlantReactiveControlIECValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public WindPlantReactiveControlIECValidator getInstance() {
		return new WindPlantReactiveControlIECValidator();
	}
		
	/**
	 * handles creation validation for a WindPlantReactiveControlIEC
	 */
	public void validate( CreateWindPlantReactiveControlIECCommand windPlantReactiveControlIEC )throws Exception {
		Assert.notNull( windPlantReactiveControlIEC, "CreateWindPlantReactiveControlIECCommand should not be null" );
//		Assert.isNull( windPlantReactiveControlIEC.getWindPlantReactiveControlIECId(), "CreateWindPlantReactiveControlIECCommand identifier should be null" );
	}

	/**
	 * handles update validation for a WindPlantReactiveControlIEC
	 */
	public void validate( UpdateWindPlantReactiveControlIECCommand windPlantReactiveControlIEC ) throws Exception {
		Assert.notNull( windPlantReactiveControlIEC, "UpdateWindPlantReactiveControlIECCommand should not be null" );
		Assert.notNull( windPlantReactiveControlIEC.getWindPlantReactiveControlIECId(), "UpdateWindPlantReactiveControlIECCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a WindPlantReactiveControlIEC
	 */
    public void validate( DeleteWindPlantReactiveControlIECCommand windPlantReactiveControlIEC ) throws Exception {
		Assert.notNull( windPlantReactiveControlIEC, "{commandAlias} should not be null" );
		Assert.notNull( windPlantReactiveControlIEC.getWindPlantReactiveControlIECId(), "DeleteWindPlantReactiveControlIECCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a WindPlantReactiveControlIEC
	 */
	public void validate( WindPlantReactiveControlIECFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "WindPlantReactiveControlIECFetchOneSummary should not be null" );
		Assert.notNull( summary.getWindPlantReactiveControlIECId(), "WindPlantReactiveControlIECFetchOneSummary identifier should not be null" );
	}



}
