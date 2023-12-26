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

public class WindMechIECValidator {
		
	/**
	 * default constructor
	 */
	protected WindMechIECValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public WindMechIECValidator getInstance() {
		return new WindMechIECValidator();
	}
		
	/**
	 * handles creation validation for a WindMechIEC
	 */
	public void validate( CreateWindMechIECCommand windMechIEC )throws Exception {
		Assert.notNull( windMechIEC, "CreateWindMechIECCommand should not be null" );
//		Assert.isNull( windMechIEC.getWindMechIECId(), "CreateWindMechIECCommand identifier should be null" );
	}

	/**
	 * handles update validation for a WindMechIEC
	 */
	public void validate( UpdateWindMechIECCommand windMechIEC ) throws Exception {
		Assert.notNull( windMechIEC, "UpdateWindMechIECCommand should not be null" );
		Assert.notNull( windMechIEC.getWindMechIECId(), "UpdateWindMechIECCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a WindMechIEC
	 */
    public void validate( DeleteWindMechIECCommand windMechIEC ) throws Exception {
		Assert.notNull( windMechIEC, "{commandAlias} should not be null" );
		Assert.notNull( windMechIEC.getWindMechIECId(), "DeleteWindMechIECCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a WindMechIEC
	 */
	public void validate( WindMechIECFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "WindMechIECFetchOneSummary should not be null" );
		Assert.notNull( summary.getWindMechIECId(), "WindMechIECFetchOneSummary identifier should not be null" );
	}



}
