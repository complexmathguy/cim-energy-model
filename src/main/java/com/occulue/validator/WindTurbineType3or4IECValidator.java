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

public class WindTurbineType3or4IECValidator {
		
	/**
	 * default constructor
	 */
	protected WindTurbineType3or4IECValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public WindTurbineType3or4IECValidator getInstance() {
		return new WindTurbineType3or4IECValidator();
	}
		
	/**
	 * handles creation validation for a WindTurbineType3or4IEC
	 */
	public void validate( CreateWindTurbineType3or4IECCommand windTurbineType3or4IEC )throws Exception {
		Assert.notNull( windTurbineType3or4IEC, "CreateWindTurbineType3or4IECCommand should not be null" );
//		Assert.isNull( windTurbineType3or4IEC.getWindTurbineType3or4IECId(), "CreateWindTurbineType3or4IECCommand identifier should be null" );
	}

	/**
	 * handles update validation for a WindTurbineType3or4IEC
	 */
	public void validate( UpdateWindTurbineType3or4IECCommand windTurbineType3or4IEC ) throws Exception {
		Assert.notNull( windTurbineType3or4IEC, "UpdateWindTurbineType3or4IECCommand should not be null" );
		Assert.notNull( windTurbineType3or4IEC.getWindTurbineType3or4IECId(), "UpdateWindTurbineType3or4IECCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a WindTurbineType3or4IEC
	 */
    public void validate( DeleteWindTurbineType3or4IECCommand windTurbineType3or4IEC ) throws Exception {
		Assert.notNull( windTurbineType3or4IEC, "{commandAlias} should not be null" );
		Assert.notNull( windTurbineType3or4IEC.getWindTurbineType3or4IECId(), "DeleteWindTurbineType3or4IECCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a WindTurbineType3or4IEC
	 */
	public void validate( WindTurbineType3or4IECFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "WindTurbineType3or4IECFetchOneSummary should not be null" );
		Assert.notNull( summary.getWindTurbineType3or4IECId(), "WindTurbineType3or4IECFetchOneSummary identifier should not be null" );
	}



}
