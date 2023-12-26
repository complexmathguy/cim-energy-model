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

public class FloatProxyValidator {
		
	/**
	 * default constructor
	 */
	protected FloatProxyValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public FloatProxyValidator getInstance() {
		return new FloatProxyValidator();
	}
		
	/**
	 * handles creation validation for a FloatProxy
	 */
	public void validate( CreateFloatProxyCommand floatProxy )throws Exception {
		Assert.notNull( floatProxy, "CreateFloatProxyCommand should not be null" );
//		Assert.isNull( floatProxy.getFloatProxyId(), "CreateFloatProxyCommand identifier should be null" );
	}

	/**
	 * handles update validation for a FloatProxy
	 */
	public void validate( UpdateFloatProxyCommand floatProxy ) throws Exception {
		Assert.notNull( floatProxy, "UpdateFloatProxyCommand should not be null" );
		Assert.notNull( floatProxy.getFloatProxyId(), "UpdateFloatProxyCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a FloatProxy
	 */
    public void validate( DeleteFloatProxyCommand floatProxy ) throws Exception {
		Assert.notNull( floatProxy, "{commandAlias} should not be null" );
		Assert.notNull( floatProxy.getFloatProxyId(), "DeleteFloatProxyCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a FloatProxy
	 */
	public void validate( FloatProxyFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "FloatProxyFetchOneSummary should not be null" );
		Assert.notNull( summary.getFloatProxyId(), "FloatProxyFetchOneSummary identifier should not be null" );
	}



}
