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

public class WindGenTurbineType3IECValidator {
		
	/**
	 * default constructor
	 */
	protected WindGenTurbineType3IECValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public WindGenTurbineType3IECValidator getInstance() {
		return new WindGenTurbineType3IECValidator();
	}
		
	/**
	 * handles creation validation for a WindGenTurbineType3IEC
	 */
	public void validate( CreateWindGenTurbineType3IECCommand windGenTurbineType3IEC )throws Exception {
		Assert.notNull( windGenTurbineType3IEC, "CreateWindGenTurbineType3IECCommand should not be null" );
//		Assert.isNull( windGenTurbineType3IEC.getWindGenTurbineType3IECId(), "CreateWindGenTurbineType3IECCommand identifier should be null" );
	}

	/**
	 * handles update validation for a WindGenTurbineType3IEC
	 */
	public void validate( UpdateWindGenTurbineType3IECCommand windGenTurbineType3IEC ) throws Exception {
		Assert.notNull( windGenTurbineType3IEC, "UpdateWindGenTurbineType3IECCommand should not be null" );
		Assert.notNull( windGenTurbineType3IEC.getWindGenTurbineType3IECId(), "UpdateWindGenTurbineType3IECCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a WindGenTurbineType3IEC
	 */
    public void validate( DeleteWindGenTurbineType3IECCommand windGenTurbineType3IEC ) throws Exception {
		Assert.notNull( windGenTurbineType3IEC, "{commandAlias} should not be null" );
		Assert.notNull( windGenTurbineType3IEC.getWindGenTurbineType3IECId(), "DeleteWindGenTurbineType3IECCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a WindGenTurbineType3IEC
	 */
	public void validate( WindGenTurbineType3IECFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "WindGenTurbineType3IECFetchOneSummary should not be null" );
		Assert.notNull( summary.getWindGenTurbineType3IECId(), "WindGenTurbineType3IECFetchOneSummary identifier should not be null" );
	}



}
