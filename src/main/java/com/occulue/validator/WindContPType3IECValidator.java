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

public class WindContPType3IECValidator {
		
	/**
	 * default constructor
	 */
	protected WindContPType3IECValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public WindContPType3IECValidator getInstance() {
		return new WindContPType3IECValidator();
	}
		
	/**
	 * handles creation validation for a WindContPType3IEC
	 */
	public void validate( CreateWindContPType3IECCommand windContPType3IEC )throws Exception {
		Assert.notNull( windContPType3IEC, "CreateWindContPType3IECCommand should not be null" );
//		Assert.isNull( windContPType3IEC.getWindContPType3IECId(), "CreateWindContPType3IECCommand identifier should be null" );
	}

	/**
	 * handles update validation for a WindContPType3IEC
	 */
	public void validate( UpdateWindContPType3IECCommand windContPType3IEC ) throws Exception {
		Assert.notNull( windContPType3IEC, "UpdateWindContPType3IECCommand should not be null" );
		Assert.notNull( windContPType3IEC.getWindContPType3IECId(), "UpdateWindContPType3IECCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a WindContPType3IEC
	 */
    public void validate( DeleteWindContPType3IECCommand windContPType3IEC ) throws Exception {
		Assert.notNull( windContPType3IEC, "{commandAlias} should not be null" );
		Assert.notNull( windContPType3IEC.getWindContPType3IECId(), "DeleteWindContPType3IECCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a WindContPType3IEC
	 */
	public void validate( WindContPType3IECFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "WindContPType3IECFetchOneSummary should not be null" );
		Assert.notNull( summary.getWindContPType3IECId(), "WindContPType3IECFetchOneSummary identifier should not be null" );
	}



}
