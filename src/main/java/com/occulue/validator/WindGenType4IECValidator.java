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

public class WindGenType4IECValidator {
		
	/**
	 * default constructor
	 */
	protected WindGenType4IECValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public WindGenType4IECValidator getInstance() {
		return new WindGenType4IECValidator();
	}
		
	/**
	 * handles creation validation for a WindGenType4IEC
	 */
	public void validate( CreateWindGenType4IECCommand windGenType4IEC )throws Exception {
		Assert.notNull( windGenType4IEC, "CreateWindGenType4IECCommand should not be null" );
//		Assert.isNull( windGenType4IEC.getWindGenType4IECId(), "CreateWindGenType4IECCommand identifier should be null" );
	}

	/**
	 * handles update validation for a WindGenType4IEC
	 */
	public void validate( UpdateWindGenType4IECCommand windGenType4IEC ) throws Exception {
		Assert.notNull( windGenType4IEC, "UpdateWindGenType4IECCommand should not be null" );
		Assert.notNull( windGenType4IEC.getWindGenType4IECId(), "UpdateWindGenType4IECCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a WindGenType4IEC
	 */
    public void validate( DeleteWindGenType4IECCommand windGenType4IEC ) throws Exception {
		Assert.notNull( windGenType4IEC, "{commandAlias} should not be null" );
		Assert.notNull( windGenType4IEC.getWindGenType4IECId(), "DeleteWindGenType4IECCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a WindGenType4IEC
	 */
	public void validate( WindGenType4IECFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "WindGenType4IECFetchOneSummary should not be null" );
		Assert.notNull( summary.getWindGenType4IECId(), "WindGenType4IECFetchOneSummary identifier should not be null" );
	}



}
