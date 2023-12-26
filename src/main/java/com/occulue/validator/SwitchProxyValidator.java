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

public class SwitchProxyValidator {
		
	/**
	 * default constructor
	 */
	protected SwitchProxyValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public SwitchProxyValidator getInstance() {
		return new SwitchProxyValidator();
	}
		
	/**
	 * handles creation validation for a SwitchProxy
	 */
	public void validate( CreateSwitchProxyCommand switchProxy )throws Exception {
		Assert.notNull( switchProxy, "CreateSwitchProxyCommand should not be null" );
//		Assert.isNull( switchProxy.getSwitchProxyId(), "CreateSwitchProxyCommand identifier should be null" );
	}

	/**
	 * handles update validation for a SwitchProxy
	 */
	public void validate( UpdateSwitchProxyCommand switchProxy ) throws Exception {
		Assert.notNull( switchProxy, "UpdateSwitchProxyCommand should not be null" );
		Assert.notNull( switchProxy.getSwitchProxyId(), "UpdateSwitchProxyCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a SwitchProxy
	 */
    public void validate( DeleteSwitchProxyCommand switchProxy ) throws Exception {
		Assert.notNull( switchProxy, "{commandAlias} should not be null" );
		Assert.notNull( switchProxy.getSwitchProxyId(), "DeleteSwitchProxyCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a SwitchProxy
	 */
	public void validate( SwitchProxyFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "SwitchProxyFetchOneSummary should not be null" );
		Assert.notNull( summary.getSwitchProxyId(), "SwitchProxyFetchOneSummary identifier should not be null" );
	}



}
