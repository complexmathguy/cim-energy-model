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

public class WindPitchContEmulIECValidator {
		
	/**
	 * default constructor
	 */
	protected WindPitchContEmulIECValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public WindPitchContEmulIECValidator getInstance() {
		return new WindPitchContEmulIECValidator();
	}
		
	/**
	 * handles creation validation for a WindPitchContEmulIEC
	 */
	public void validate( CreateWindPitchContEmulIECCommand windPitchContEmulIEC )throws Exception {
		Assert.notNull( windPitchContEmulIEC, "CreateWindPitchContEmulIECCommand should not be null" );
//		Assert.isNull( windPitchContEmulIEC.getWindPitchContEmulIECId(), "CreateWindPitchContEmulIECCommand identifier should be null" );
	}

	/**
	 * handles update validation for a WindPitchContEmulIEC
	 */
	public void validate( UpdateWindPitchContEmulIECCommand windPitchContEmulIEC ) throws Exception {
		Assert.notNull( windPitchContEmulIEC, "UpdateWindPitchContEmulIECCommand should not be null" );
		Assert.notNull( windPitchContEmulIEC.getWindPitchContEmulIECId(), "UpdateWindPitchContEmulIECCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a WindPitchContEmulIEC
	 */
    public void validate( DeleteWindPitchContEmulIECCommand windPitchContEmulIEC ) throws Exception {
		Assert.notNull( windPitchContEmulIEC, "{commandAlias} should not be null" );
		Assert.notNull( windPitchContEmulIEC.getWindPitchContEmulIECId(), "DeleteWindPitchContEmulIECCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a WindPitchContEmulIEC
	 */
	public void validate( WindPitchContEmulIECFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "WindPitchContEmulIECFetchOneSummary should not be null" );
		Assert.notNull( summary.getWindPitchContEmulIECId(), "WindPitchContEmulIECFetchOneSummary identifier should not be null" );
	}



}
