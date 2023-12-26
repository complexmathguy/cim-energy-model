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

public class WindContRotorRIECValidator {
		
	/**
	 * default constructor
	 */
	protected WindContRotorRIECValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public WindContRotorRIECValidator getInstance() {
		return new WindContRotorRIECValidator();
	}
		
	/**
	 * handles creation validation for a WindContRotorRIEC
	 */
	public void validate( CreateWindContRotorRIECCommand windContRotorRIEC )throws Exception {
		Assert.notNull( windContRotorRIEC, "CreateWindContRotorRIECCommand should not be null" );
//		Assert.isNull( windContRotorRIEC.getWindContRotorRIECId(), "CreateWindContRotorRIECCommand identifier should be null" );
	}

	/**
	 * handles update validation for a WindContRotorRIEC
	 */
	public void validate( UpdateWindContRotorRIECCommand windContRotorRIEC ) throws Exception {
		Assert.notNull( windContRotorRIEC, "UpdateWindContRotorRIECCommand should not be null" );
		Assert.notNull( windContRotorRIEC.getWindContRotorRIECId(), "UpdateWindContRotorRIECCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a WindContRotorRIEC
	 */
    public void validate( DeleteWindContRotorRIECCommand windContRotorRIEC ) throws Exception {
		Assert.notNull( windContRotorRIEC, "{commandAlias} should not be null" );
		Assert.notNull( windContRotorRIEC.getWindContRotorRIECId(), "DeleteWindContRotorRIECCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a WindContRotorRIEC
	 */
	public void validate( WindContRotorRIECFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "WindContRotorRIECFetchOneSummary should not be null" );
		Assert.notNull( summary.getWindContRotorRIECId(), "WindContRotorRIECFetchOneSummary identifier should not be null" );
	}



}
