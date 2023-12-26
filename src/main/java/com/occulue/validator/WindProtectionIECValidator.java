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

public class WindProtectionIECValidator {
		
	/**
	 * default constructor
	 */
	protected WindProtectionIECValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public WindProtectionIECValidator getInstance() {
		return new WindProtectionIECValidator();
	}
		
	/**
	 * handles creation validation for a WindProtectionIEC
	 */
	public void validate( CreateWindProtectionIECCommand windProtectionIEC )throws Exception {
		Assert.notNull( windProtectionIEC, "CreateWindProtectionIECCommand should not be null" );
//		Assert.isNull( windProtectionIEC.getWindProtectionIECId(), "CreateWindProtectionIECCommand identifier should be null" );
	}

	/**
	 * handles update validation for a WindProtectionIEC
	 */
	public void validate( UpdateWindProtectionIECCommand windProtectionIEC ) throws Exception {
		Assert.notNull( windProtectionIEC, "UpdateWindProtectionIECCommand should not be null" );
		Assert.notNull( windProtectionIEC.getWindProtectionIECId(), "UpdateWindProtectionIECCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a WindProtectionIEC
	 */
    public void validate( DeleteWindProtectionIECCommand windProtectionIEC ) throws Exception {
		Assert.notNull( windProtectionIEC, "{commandAlias} should not be null" );
		Assert.notNull( windProtectionIEC.getWindProtectionIECId(), "DeleteWindProtectionIECCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a WindProtectionIEC
	 */
	public void validate( WindProtectionIECFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "WindProtectionIECFetchOneSummary should not be null" );
		Assert.notNull( summary.getWindProtectionIECId(), "WindProtectionIECFetchOneSummary identifier should not be null" );
	}



}
