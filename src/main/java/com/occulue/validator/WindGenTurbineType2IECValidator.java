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

public class WindGenTurbineType2IECValidator {
		
	/**
	 * default constructor
	 */
	protected WindGenTurbineType2IECValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public WindGenTurbineType2IECValidator getInstance() {
		return new WindGenTurbineType2IECValidator();
	}
		
	/**
	 * handles creation validation for a WindGenTurbineType2IEC
	 */
	public void validate( CreateWindGenTurbineType2IECCommand windGenTurbineType2IEC )throws Exception {
		Assert.notNull( windGenTurbineType2IEC, "CreateWindGenTurbineType2IECCommand should not be null" );
//		Assert.isNull( windGenTurbineType2IEC.getWindGenTurbineType2IECId(), "CreateWindGenTurbineType2IECCommand identifier should be null" );
	}

	/**
	 * handles update validation for a WindGenTurbineType2IEC
	 */
	public void validate( UpdateWindGenTurbineType2IECCommand windGenTurbineType2IEC ) throws Exception {
		Assert.notNull( windGenTurbineType2IEC, "UpdateWindGenTurbineType2IECCommand should not be null" );
		Assert.notNull( windGenTurbineType2IEC.getWindGenTurbineType2IECId(), "UpdateWindGenTurbineType2IECCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a WindGenTurbineType2IEC
	 */
    public void validate( DeleteWindGenTurbineType2IECCommand windGenTurbineType2IEC ) throws Exception {
		Assert.notNull( windGenTurbineType2IEC, "{commandAlias} should not be null" );
		Assert.notNull( windGenTurbineType2IEC.getWindGenTurbineType2IECId(), "DeleteWindGenTurbineType2IECCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a WindGenTurbineType2IEC
	 */
	public void validate( WindGenTurbineType2IECFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "WindGenTurbineType2IECFetchOneSummary should not be null" );
		Assert.notNull( summary.getWindGenTurbineType2IECId(), "WindGenTurbineType2IECFetchOneSummary identifier should not be null" );
	}



}
