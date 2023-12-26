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

public class WindContQIECValidator {
		
	/**
	 * default constructor
	 */
	protected WindContQIECValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public WindContQIECValidator getInstance() {
		return new WindContQIECValidator();
	}
		
	/**
	 * handles creation validation for a WindContQIEC
	 */
	public void validate( CreateWindContQIECCommand windContQIEC )throws Exception {
		Assert.notNull( windContQIEC, "CreateWindContQIECCommand should not be null" );
//		Assert.isNull( windContQIEC.getWindContQIECId(), "CreateWindContQIECCommand identifier should be null" );
	}

	/**
	 * handles update validation for a WindContQIEC
	 */
	public void validate( UpdateWindContQIECCommand windContQIEC ) throws Exception {
		Assert.notNull( windContQIEC, "UpdateWindContQIECCommand should not be null" );
		Assert.notNull( windContQIEC.getWindContQIECId(), "UpdateWindContQIECCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a WindContQIEC
	 */
    public void validate( DeleteWindContQIECCommand windContQIEC ) throws Exception {
		Assert.notNull( windContQIEC, "{commandAlias} should not be null" );
		Assert.notNull( windContQIEC.getWindContQIECId(), "DeleteWindContQIECCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a WindContQIEC
	 */
	public void validate( WindContQIECFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "WindContQIECFetchOneSummary should not be null" );
		Assert.notNull( summary.getWindContQIECId(), "WindContQIECFetchOneSummary identifier should not be null" );
	}



}
