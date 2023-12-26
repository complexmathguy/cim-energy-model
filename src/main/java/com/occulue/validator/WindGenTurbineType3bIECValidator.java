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

public class WindGenTurbineType3bIECValidator {
		
	/**
	 * default constructor
	 */
	protected WindGenTurbineType3bIECValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public WindGenTurbineType3bIECValidator getInstance() {
		return new WindGenTurbineType3bIECValidator();
	}
		
	/**
	 * handles creation validation for a WindGenTurbineType3bIEC
	 */
	public void validate( CreateWindGenTurbineType3bIECCommand windGenTurbineType3bIEC )throws Exception {
		Assert.notNull( windGenTurbineType3bIEC, "CreateWindGenTurbineType3bIECCommand should not be null" );
//		Assert.isNull( windGenTurbineType3bIEC.getWindGenTurbineType3bIECId(), "CreateWindGenTurbineType3bIECCommand identifier should be null" );
	}

	/**
	 * handles update validation for a WindGenTurbineType3bIEC
	 */
	public void validate( UpdateWindGenTurbineType3bIECCommand windGenTurbineType3bIEC ) throws Exception {
		Assert.notNull( windGenTurbineType3bIEC, "UpdateWindGenTurbineType3bIECCommand should not be null" );
		Assert.notNull( windGenTurbineType3bIEC.getWindGenTurbineType3bIECId(), "UpdateWindGenTurbineType3bIECCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a WindGenTurbineType3bIEC
	 */
    public void validate( DeleteWindGenTurbineType3bIECCommand windGenTurbineType3bIEC ) throws Exception {
		Assert.notNull( windGenTurbineType3bIEC, "{commandAlias} should not be null" );
		Assert.notNull( windGenTurbineType3bIEC.getWindGenTurbineType3bIECId(), "DeleteWindGenTurbineType3bIECCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a WindGenTurbineType3bIEC
	 */
	public void validate( WindGenTurbineType3bIECFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "WindGenTurbineType3bIECFetchOneSummary should not be null" );
		Assert.notNull( summary.getWindGenTurbineType3bIECId(), "WindGenTurbineType3bIECFetchOneSummary identifier should not be null" );
	}



}
