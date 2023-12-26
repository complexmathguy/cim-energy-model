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

public class DisconnectorValidator {
		
	/**
	 * default constructor
	 */
	protected DisconnectorValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public DisconnectorValidator getInstance() {
		return new DisconnectorValidator();
	}
		
	/**
	 * handles creation validation for a Disconnector
	 */
	public void validate( CreateDisconnectorCommand disconnector )throws Exception {
		Assert.notNull( disconnector, "CreateDisconnectorCommand should not be null" );
//		Assert.isNull( disconnector.getDisconnectorId(), "CreateDisconnectorCommand identifier should be null" );
	}

	/**
	 * handles update validation for a Disconnector
	 */
	public void validate( UpdateDisconnectorCommand disconnector ) throws Exception {
		Assert.notNull( disconnector, "UpdateDisconnectorCommand should not be null" );
		Assert.notNull( disconnector.getDisconnectorId(), "UpdateDisconnectorCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a Disconnector
	 */
    public void validate( DeleteDisconnectorCommand disconnector ) throws Exception {
		Assert.notNull( disconnector, "{commandAlias} should not be null" );
		Assert.notNull( disconnector.getDisconnectorId(), "DeleteDisconnectorCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a Disconnector
	 */
	public void validate( DisconnectorFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "DisconnectorFetchOneSummary should not be null" );
		Assert.notNull( summary.getDisconnectorId(), "DisconnectorFetchOneSummary identifier should not be null" );
	}



}
