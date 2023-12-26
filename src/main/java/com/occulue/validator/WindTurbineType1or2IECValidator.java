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

public class WindTurbineType1or2IECValidator {
		
	/**
	 * default constructor
	 */
	protected WindTurbineType1or2IECValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public WindTurbineType1or2IECValidator getInstance() {
		return new WindTurbineType1or2IECValidator();
	}
		
	/**
	 * handles creation validation for a WindTurbineType1or2IEC
	 */
	public void validate( CreateWindTurbineType1or2IECCommand windTurbineType1or2IEC )throws Exception {
		Assert.notNull( windTurbineType1or2IEC, "CreateWindTurbineType1or2IECCommand should not be null" );
//		Assert.isNull( windTurbineType1or2IEC.getWindTurbineType1or2IECId(), "CreateWindTurbineType1or2IECCommand identifier should be null" );
	}

	/**
	 * handles update validation for a WindTurbineType1or2IEC
	 */
	public void validate( UpdateWindTurbineType1or2IECCommand windTurbineType1or2IEC ) throws Exception {
		Assert.notNull( windTurbineType1or2IEC, "UpdateWindTurbineType1or2IECCommand should not be null" );
		Assert.notNull( windTurbineType1or2IEC.getWindTurbineType1or2IECId(), "UpdateWindTurbineType1or2IECCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a WindTurbineType1or2IEC
	 */
    public void validate( DeleteWindTurbineType1or2IECCommand windTurbineType1or2IEC ) throws Exception {
		Assert.notNull( windTurbineType1or2IEC, "{commandAlias} should not be null" );
		Assert.notNull( windTurbineType1or2IEC.getWindTurbineType1or2IECId(), "DeleteWindTurbineType1or2IECCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a WindTurbineType1or2IEC
	 */
	public void validate( WindTurbineType1or2IECFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "WindTurbineType1or2IECFetchOneSummary should not be null" );
		Assert.notNull( summary.getWindTurbineType1or2IECId(), "WindTurbineType1or2IECFetchOneSummary identifier should not be null" );
	}



}
