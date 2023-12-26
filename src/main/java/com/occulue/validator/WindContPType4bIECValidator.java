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

public class WindContPType4bIECValidator {
		
	/**
	 * default constructor
	 */
	protected WindContPType4bIECValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public WindContPType4bIECValidator getInstance() {
		return new WindContPType4bIECValidator();
	}
		
	/**
	 * handles creation validation for a WindContPType4bIEC
	 */
	public void validate( CreateWindContPType4bIECCommand windContPType4bIEC )throws Exception {
		Assert.notNull( windContPType4bIEC, "CreateWindContPType4bIECCommand should not be null" );
//		Assert.isNull( windContPType4bIEC.getWindContPType4bIECId(), "CreateWindContPType4bIECCommand identifier should be null" );
	}

	/**
	 * handles update validation for a WindContPType4bIEC
	 */
	public void validate( UpdateWindContPType4bIECCommand windContPType4bIEC ) throws Exception {
		Assert.notNull( windContPType4bIEC, "UpdateWindContPType4bIECCommand should not be null" );
		Assert.notNull( windContPType4bIEC.getWindContPType4bIECId(), "UpdateWindContPType4bIECCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a WindContPType4bIEC
	 */
    public void validate( DeleteWindContPType4bIECCommand windContPType4bIEC ) throws Exception {
		Assert.notNull( windContPType4bIEC, "{commandAlias} should not be null" );
		Assert.notNull( windContPType4bIEC.getWindContPType4bIECId(), "DeleteWindContPType4bIECCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a WindContPType4bIEC
	 */
	public void validate( WindContPType4bIECFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "WindContPType4bIECFetchOneSummary should not be null" );
		Assert.notNull( summary.getWindContPType4bIECId(), "WindContPType4bIECFetchOneSummary identifier should not be null" );
	}



}
