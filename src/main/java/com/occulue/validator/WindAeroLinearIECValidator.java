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

public class WindAeroLinearIECValidator {
		
	/**
	 * default constructor
	 */
	protected WindAeroLinearIECValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public WindAeroLinearIECValidator getInstance() {
		return new WindAeroLinearIECValidator();
	}
		
	/**
	 * handles creation validation for a WindAeroLinearIEC
	 */
	public void validate( CreateWindAeroLinearIECCommand windAeroLinearIEC )throws Exception {
		Assert.notNull( windAeroLinearIEC, "CreateWindAeroLinearIECCommand should not be null" );
//		Assert.isNull( windAeroLinearIEC.getWindAeroLinearIECId(), "CreateWindAeroLinearIECCommand identifier should be null" );
	}

	/**
	 * handles update validation for a WindAeroLinearIEC
	 */
	public void validate( UpdateWindAeroLinearIECCommand windAeroLinearIEC ) throws Exception {
		Assert.notNull( windAeroLinearIEC, "UpdateWindAeroLinearIECCommand should not be null" );
		Assert.notNull( windAeroLinearIEC.getWindAeroLinearIECId(), "UpdateWindAeroLinearIECCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a WindAeroLinearIEC
	 */
    public void validate( DeleteWindAeroLinearIECCommand windAeroLinearIEC ) throws Exception {
		Assert.notNull( windAeroLinearIEC, "{commandAlias} should not be null" );
		Assert.notNull( windAeroLinearIEC.getWindAeroLinearIECId(), "DeleteWindAeroLinearIECCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a WindAeroLinearIEC
	 */
	public void validate( WindAeroLinearIECFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "WindAeroLinearIECFetchOneSummary should not be null" );
		Assert.notNull( summary.getWindAeroLinearIECId(), "WindAeroLinearIECFetchOneSummary identifier should not be null" );
	}



}
