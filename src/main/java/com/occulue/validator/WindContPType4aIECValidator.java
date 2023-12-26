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

public class WindContPType4aIECValidator {
		
	/**
	 * default constructor
	 */
	protected WindContPType4aIECValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public WindContPType4aIECValidator getInstance() {
		return new WindContPType4aIECValidator();
	}
		
	/**
	 * handles creation validation for a WindContPType4aIEC
	 */
	public void validate( CreateWindContPType4aIECCommand windContPType4aIEC )throws Exception {
		Assert.notNull( windContPType4aIEC, "CreateWindContPType4aIECCommand should not be null" );
//		Assert.isNull( windContPType4aIEC.getWindContPType4aIECId(), "CreateWindContPType4aIECCommand identifier should be null" );
	}

	/**
	 * handles update validation for a WindContPType4aIEC
	 */
	public void validate( UpdateWindContPType4aIECCommand windContPType4aIEC ) throws Exception {
		Assert.notNull( windContPType4aIEC, "UpdateWindContPType4aIECCommand should not be null" );
		Assert.notNull( windContPType4aIEC.getWindContPType4aIECId(), "UpdateWindContPType4aIECCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a WindContPType4aIEC
	 */
    public void validate( DeleteWindContPType4aIECCommand windContPType4aIEC ) throws Exception {
		Assert.notNull( windContPType4aIEC, "{commandAlias} should not be null" );
		Assert.notNull( windContPType4aIEC.getWindContPType4aIECId(), "DeleteWindContPType4aIECCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a WindContPType4aIEC
	 */
	public void validate( WindContPType4aIECFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "WindContPType4aIECFetchOneSummary should not be null" );
		Assert.notNull( summary.getWindContPType4aIECId(), "WindContPType4aIECFetchOneSummary identifier should not be null" );
	}



}
