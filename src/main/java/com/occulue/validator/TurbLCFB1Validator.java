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

public class TurbLCFB1Validator {
		
	/**
	 * default constructor
	 */
	protected TurbLCFB1Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public TurbLCFB1Validator getInstance() {
		return new TurbLCFB1Validator();
	}
		
	/**
	 * handles creation validation for a TurbLCFB1
	 */
	public void validate( CreateTurbLCFB1Command turbLCFB1 )throws Exception {
		Assert.notNull( turbLCFB1, "CreateTurbLCFB1Command should not be null" );
//		Assert.isNull( turbLCFB1.getTurbLCFB1Id(), "CreateTurbLCFB1Command identifier should be null" );
	}

	/**
	 * handles update validation for a TurbLCFB1
	 */
	public void validate( UpdateTurbLCFB1Command turbLCFB1 ) throws Exception {
		Assert.notNull( turbLCFB1, "UpdateTurbLCFB1Command should not be null" );
		Assert.notNull( turbLCFB1.getTurbLCFB1Id(), "UpdateTurbLCFB1Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a TurbLCFB1
	 */
    public void validate( DeleteTurbLCFB1Command turbLCFB1 ) throws Exception {
		Assert.notNull( turbLCFB1, "{commandAlias} should not be null" );
		Assert.notNull( turbLCFB1.getTurbLCFB1Id(), "DeleteTurbLCFB1Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a TurbLCFB1
	 */
	public void validate( TurbLCFB1FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "TurbLCFB1FetchOneSummary should not be null" );
		Assert.notNull( summary.getTurbLCFB1Id(), "TurbLCFB1FetchOneSummary identifier should not be null" );
	}



}
