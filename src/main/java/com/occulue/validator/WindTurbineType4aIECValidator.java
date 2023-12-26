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

public class WindTurbineType4aIECValidator {
		
	/**
	 * default constructor
	 */
	protected WindTurbineType4aIECValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public WindTurbineType4aIECValidator getInstance() {
		return new WindTurbineType4aIECValidator();
	}
		
	/**
	 * handles creation validation for a WindTurbineType4aIEC
	 */
	public void validate( CreateWindTurbineType4aIECCommand windTurbineType4aIEC )throws Exception {
		Assert.notNull( windTurbineType4aIEC, "CreateWindTurbineType4aIECCommand should not be null" );
//		Assert.isNull( windTurbineType4aIEC.getWindTurbineType4aIECId(), "CreateWindTurbineType4aIECCommand identifier should be null" );
	}

	/**
	 * handles update validation for a WindTurbineType4aIEC
	 */
	public void validate( UpdateWindTurbineType4aIECCommand windTurbineType4aIEC ) throws Exception {
		Assert.notNull( windTurbineType4aIEC, "UpdateWindTurbineType4aIECCommand should not be null" );
		Assert.notNull( windTurbineType4aIEC.getWindTurbineType4aIECId(), "UpdateWindTurbineType4aIECCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a WindTurbineType4aIEC
	 */
    public void validate( DeleteWindTurbineType4aIECCommand windTurbineType4aIEC ) throws Exception {
		Assert.notNull( windTurbineType4aIEC, "{commandAlias} should not be null" );
		Assert.notNull( windTurbineType4aIEC.getWindTurbineType4aIECId(), "DeleteWindTurbineType4aIECCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a WindTurbineType4aIEC
	 */
	public void validate( WindTurbineType4aIECFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "WindTurbineType4aIECFetchOneSummary should not be null" );
		Assert.notNull( summary.getWindTurbineType4aIECId(), "WindTurbineType4aIECFetchOneSummary identifier should not be null" );
	}



}
