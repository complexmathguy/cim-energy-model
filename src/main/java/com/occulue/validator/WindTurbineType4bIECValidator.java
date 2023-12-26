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

public class WindTurbineType4bIECValidator {
		
	/**
	 * default constructor
	 */
	protected WindTurbineType4bIECValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public WindTurbineType4bIECValidator getInstance() {
		return new WindTurbineType4bIECValidator();
	}
		
	/**
	 * handles creation validation for a WindTurbineType4bIEC
	 */
	public void validate( CreateWindTurbineType4bIECCommand windTurbineType4bIEC )throws Exception {
		Assert.notNull( windTurbineType4bIEC, "CreateWindTurbineType4bIECCommand should not be null" );
//		Assert.isNull( windTurbineType4bIEC.getWindTurbineType4bIECId(), "CreateWindTurbineType4bIECCommand identifier should be null" );
	}

	/**
	 * handles update validation for a WindTurbineType4bIEC
	 */
	public void validate( UpdateWindTurbineType4bIECCommand windTurbineType4bIEC ) throws Exception {
		Assert.notNull( windTurbineType4bIEC, "UpdateWindTurbineType4bIECCommand should not be null" );
		Assert.notNull( windTurbineType4bIEC.getWindTurbineType4bIECId(), "UpdateWindTurbineType4bIECCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a WindTurbineType4bIEC
	 */
    public void validate( DeleteWindTurbineType4bIECCommand windTurbineType4bIEC ) throws Exception {
		Assert.notNull( windTurbineType4bIEC, "{commandAlias} should not be null" );
		Assert.notNull( windTurbineType4bIEC.getWindTurbineType4bIECId(), "DeleteWindTurbineType4bIECCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a WindTurbineType4bIEC
	 */
	public void validate( WindTurbineType4bIECFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "WindTurbineType4bIECFetchOneSummary should not be null" );
		Assert.notNull( summary.getWindTurbineType4bIECId(), "WindTurbineType4bIECFetchOneSummary identifier should not be null" );
	}



}
