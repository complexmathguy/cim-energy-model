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

public class DCDisconnectorValidator {
		
	/**
	 * default constructor
	 */
	protected DCDisconnectorValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public DCDisconnectorValidator getInstance() {
		return new DCDisconnectorValidator();
	}
		
	/**
	 * handles creation validation for a DCDisconnector
	 */
	public void validate( CreateDCDisconnectorCommand dCDisconnector )throws Exception {
		Assert.notNull( dCDisconnector, "CreateDCDisconnectorCommand should not be null" );
//		Assert.isNull( dCDisconnector.getDCDisconnectorId(), "CreateDCDisconnectorCommand identifier should be null" );
	}

	/**
	 * handles update validation for a DCDisconnector
	 */
	public void validate( UpdateDCDisconnectorCommand dCDisconnector ) throws Exception {
		Assert.notNull( dCDisconnector, "UpdateDCDisconnectorCommand should not be null" );
		Assert.notNull( dCDisconnector.getDCDisconnectorId(), "UpdateDCDisconnectorCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a DCDisconnector
	 */
    public void validate( DeleteDCDisconnectorCommand dCDisconnector ) throws Exception {
		Assert.notNull( dCDisconnector, "{commandAlias} should not be null" );
		Assert.notNull( dCDisconnector.getDCDisconnectorId(), "DeleteDCDisconnectorCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a DCDisconnector
	 */
	public void validate( DCDisconnectorFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "DCDisconnectorFetchOneSummary should not be null" );
		Assert.notNull( summary.getDCDisconnectorId(), "DCDisconnectorFetchOneSummary identifier should not be null" );
	}



}
