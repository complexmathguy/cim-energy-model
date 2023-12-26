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

public class DateProxyValidator {
		
	/**
	 * default constructor
	 */
	protected DateProxyValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public DateProxyValidator getInstance() {
		return new DateProxyValidator();
	}
		
	/**
	 * handles creation validation for a DateProxy
	 */
	public void validate( CreateDateProxyCommand dateProxy )throws Exception {
		Assert.notNull( dateProxy, "CreateDateProxyCommand should not be null" );
//		Assert.isNull( dateProxy.getDateProxyId(), "CreateDateProxyCommand identifier should be null" );
	}

	/**
	 * handles update validation for a DateProxy
	 */
	public void validate( UpdateDateProxyCommand dateProxy ) throws Exception {
		Assert.notNull( dateProxy, "UpdateDateProxyCommand should not be null" );
		Assert.notNull( dateProxy.getDateProxyId(), "UpdateDateProxyCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a DateProxy
	 */
    public void validate( DeleteDateProxyCommand dateProxy ) throws Exception {
		Assert.notNull( dateProxy, "{commandAlias} should not be null" );
		Assert.notNull( dateProxy.getDateProxyId(), "DeleteDateProxyCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a DateProxy
	 */
	public void validate( DateProxyFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "DateProxyFetchOneSummary should not be null" );
		Assert.notNull( summary.getDateProxyId(), "DateProxyFetchOneSummary identifier should not be null" );
	}



}
