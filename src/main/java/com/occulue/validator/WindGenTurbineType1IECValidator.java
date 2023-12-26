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

public class WindGenTurbineType1IECValidator {
		
	/**
	 * default constructor
	 */
	protected WindGenTurbineType1IECValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public WindGenTurbineType1IECValidator getInstance() {
		return new WindGenTurbineType1IECValidator();
	}
		
	/**
	 * handles creation validation for a WindGenTurbineType1IEC
	 */
	public void validate( CreateWindGenTurbineType1IECCommand windGenTurbineType1IEC )throws Exception {
		Assert.notNull( windGenTurbineType1IEC, "CreateWindGenTurbineType1IECCommand should not be null" );
//		Assert.isNull( windGenTurbineType1IEC.getWindGenTurbineType1IECId(), "CreateWindGenTurbineType1IECCommand identifier should be null" );
	}

	/**
	 * handles update validation for a WindGenTurbineType1IEC
	 */
	public void validate( UpdateWindGenTurbineType1IECCommand windGenTurbineType1IEC ) throws Exception {
		Assert.notNull( windGenTurbineType1IEC, "UpdateWindGenTurbineType1IECCommand should not be null" );
		Assert.notNull( windGenTurbineType1IEC.getWindGenTurbineType1IECId(), "UpdateWindGenTurbineType1IECCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a WindGenTurbineType1IEC
	 */
    public void validate( DeleteWindGenTurbineType1IECCommand windGenTurbineType1IEC ) throws Exception {
		Assert.notNull( windGenTurbineType1IEC, "{commandAlias} should not be null" );
		Assert.notNull( windGenTurbineType1IEC.getWindGenTurbineType1IECId(), "DeleteWindGenTurbineType1IECCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a WindGenTurbineType1IEC
	 */
	public void validate( WindGenTurbineType1IECFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "WindGenTurbineType1IECFetchOneSummary should not be null" );
		Assert.notNull( summary.getWindGenTurbineType1IECId(), "WindGenTurbineType1IECFetchOneSummary identifier should not be null" );
	}



}
