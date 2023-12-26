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

public class DCGroundValidator {
		
	/**
	 * default constructor
	 */
	protected DCGroundValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public DCGroundValidator getInstance() {
		return new DCGroundValidator();
	}
		
	/**
	 * handles creation validation for a DCGround
	 */
	public void validate( CreateDCGroundCommand dCGround )throws Exception {
		Assert.notNull( dCGround, "CreateDCGroundCommand should not be null" );
//		Assert.isNull( dCGround.getDCGroundId(), "CreateDCGroundCommand identifier should be null" );
	}

	/**
	 * handles update validation for a DCGround
	 */
	public void validate( UpdateDCGroundCommand dCGround ) throws Exception {
		Assert.notNull( dCGround, "UpdateDCGroundCommand should not be null" );
		Assert.notNull( dCGround.getDCGroundId(), "UpdateDCGroundCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a DCGround
	 */
    public void validate( DeleteDCGroundCommand dCGround ) throws Exception {
		Assert.notNull( dCGround, "{commandAlias} should not be null" );
		Assert.notNull( dCGround.getDCGroundId(), "DeleteDCGroundCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a DCGround
	 */
	public void validate( DCGroundFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "DCGroundFetchOneSummary should not be null" );
		Assert.notNull( summary.getDCGroundId(), "DCGroundFetchOneSummary identifier should not be null" );
	}



}
