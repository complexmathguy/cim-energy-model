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

public class WindContPitchAngleIECValidator {
		
	/**
	 * default constructor
	 */
	protected WindContPitchAngleIECValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public WindContPitchAngleIECValidator getInstance() {
		return new WindContPitchAngleIECValidator();
	}
		
	/**
	 * handles creation validation for a WindContPitchAngleIEC
	 */
	public void validate( CreateWindContPitchAngleIECCommand windContPitchAngleIEC )throws Exception {
		Assert.notNull( windContPitchAngleIEC, "CreateWindContPitchAngleIECCommand should not be null" );
//		Assert.isNull( windContPitchAngleIEC.getWindContPitchAngleIECId(), "CreateWindContPitchAngleIECCommand identifier should be null" );
	}

	/**
	 * handles update validation for a WindContPitchAngleIEC
	 */
	public void validate( UpdateWindContPitchAngleIECCommand windContPitchAngleIEC ) throws Exception {
		Assert.notNull( windContPitchAngleIEC, "UpdateWindContPitchAngleIECCommand should not be null" );
		Assert.notNull( windContPitchAngleIEC.getWindContPitchAngleIECId(), "UpdateWindContPitchAngleIECCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a WindContPitchAngleIEC
	 */
    public void validate( DeleteWindContPitchAngleIECCommand windContPitchAngleIEC ) throws Exception {
		Assert.notNull( windContPitchAngleIEC, "{commandAlias} should not be null" );
		Assert.notNull( windContPitchAngleIEC.getWindContPitchAngleIECId(), "DeleteWindContPitchAngleIECCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a WindContPitchAngleIEC
	 */
	public void validate( WindContPitchAngleIECFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "WindContPitchAngleIECFetchOneSummary should not be null" );
		Assert.notNull( summary.getWindContPitchAngleIECId(), "WindContPitchAngleIECFetchOneSummary identifier should not be null" );
	}



}
