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

public class WindGenTurbineType3aIECValidator {
		
	/**
	 * default constructor
	 */
	protected WindGenTurbineType3aIECValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public WindGenTurbineType3aIECValidator getInstance() {
		return new WindGenTurbineType3aIECValidator();
	}
		
	/**
	 * handles creation validation for a WindGenTurbineType3aIEC
	 */
	public void validate( CreateWindGenTurbineType3aIECCommand windGenTurbineType3aIEC )throws Exception {
		Assert.notNull( windGenTurbineType3aIEC, "CreateWindGenTurbineType3aIECCommand should not be null" );
//		Assert.isNull( windGenTurbineType3aIEC.getWindGenTurbineType3aIECId(), "CreateWindGenTurbineType3aIECCommand identifier should be null" );
	}

	/**
	 * handles update validation for a WindGenTurbineType3aIEC
	 */
	public void validate( UpdateWindGenTurbineType3aIECCommand windGenTurbineType3aIEC ) throws Exception {
		Assert.notNull( windGenTurbineType3aIEC, "UpdateWindGenTurbineType3aIECCommand should not be null" );
		Assert.notNull( windGenTurbineType3aIEC.getWindGenTurbineType3aIECId(), "UpdateWindGenTurbineType3aIECCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a WindGenTurbineType3aIEC
	 */
    public void validate( DeleteWindGenTurbineType3aIECCommand windGenTurbineType3aIEC ) throws Exception {
		Assert.notNull( windGenTurbineType3aIEC, "{commandAlias} should not be null" );
		Assert.notNull( windGenTurbineType3aIEC.getWindGenTurbineType3aIECId(), "DeleteWindGenTurbineType3aIECCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a WindGenTurbineType3aIEC
	 */
	public void validate( WindGenTurbineType3aIECFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "WindGenTurbineType3aIECFetchOneSummary should not be null" );
		Assert.notNull( summary.getWindGenTurbineType3aIECId(), "WindGenTurbineType3aIECFetchOneSummary identifier should not be null" );
	}



}
