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

public class IntegerProxyValidator {
		
	/**
	 * default constructor
	 */
	protected IntegerProxyValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public IntegerProxyValidator getInstance() {
		return new IntegerProxyValidator();
	}
		
	/**
	 * handles creation validation for a IntegerProxy
	 */
	public void validate( CreateIntegerProxyCommand integerProxy )throws Exception {
		Assert.notNull( integerProxy, "CreateIntegerProxyCommand should not be null" );
//		Assert.isNull( integerProxy.getIntegerProxyId(), "CreateIntegerProxyCommand identifier should be null" );
	}

	/**
	 * handles update validation for a IntegerProxy
	 */
	public void validate( UpdateIntegerProxyCommand integerProxy ) throws Exception {
		Assert.notNull( integerProxy, "UpdateIntegerProxyCommand should not be null" );
		Assert.notNull( integerProxy.getIntegerProxyId(), "UpdateIntegerProxyCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a IntegerProxy
	 */
    public void validate( DeleteIntegerProxyCommand integerProxy ) throws Exception {
		Assert.notNull( integerProxy, "{commandAlias} should not be null" );
		Assert.notNull( integerProxy.getIntegerProxyId(), "DeleteIntegerProxyCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a IntegerProxy
	 */
	public void validate( IntegerProxyFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "IntegerProxyFetchOneSummary should not be null" );
		Assert.notNull( summary.getIntegerProxyId(), "IntegerProxyFetchOneSummary identifier should not be null" );
	}



}
