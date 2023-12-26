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

public class WindContCurrLimIECValidator {
		
	/**
	 * default constructor
	 */
	protected WindContCurrLimIECValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public WindContCurrLimIECValidator getInstance() {
		return new WindContCurrLimIECValidator();
	}
		
	/**
	 * handles creation validation for a WindContCurrLimIEC
	 */
	public void validate( CreateWindContCurrLimIECCommand windContCurrLimIEC )throws Exception {
		Assert.notNull( windContCurrLimIEC, "CreateWindContCurrLimIECCommand should not be null" );
//		Assert.isNull( windContCurrLimIEC.getWindContCurrLimIECId(), "CreateWindContCurrLimIECCommand identifier should be null" );
	}

	/**
	 * handles update validation for a WindContCurrLimIEC
	 */
	public void validate( UpdateWindContCurrLimIECCommand windContCurrLimIEC ) throws Exception {
		Assert.notNull( windContCurrLimIEC, "UpdateWindContCurrLimIECCommand should not be null" );
		Assert.notNull( windContCurrLimIEC.getWindContCurrLimIECId(), "UpdateWindContCurrLimIECCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a WindContCurrLimIEC
	 */
    public void validate( DeleteWindContCurrLimIECCommand windContCurrLimIEC ) throws Exception {
		Assert.notNull( windContCurrLimIEC, "{commandAlias} should not be null" );
		Assert.notNull( windContCurrLimIEC.getWindContCurrLimIECId(), "DeleteWindContCurrLimIECCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a WindContCurrLimIEC
	 */
	public void validate( WindContCurrLimIECFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "WindContCurrLimIECFetchOneSummary should not be null" );
		Assert.notNull( summary.getWindContCurrLimIECId(), "WindContCurrLimIECFetchOneSummary identifier should not be null" );
	}



}
