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

public class DCChopperValidator {
		
	/**
	 * default constructor
	 */
	protected DCChopperValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public DCChopperValidator getInstance() {
		return new DCChopperValidator();
	}
		
	/**
	 * handles creation validation for a DCChopper
	 */
	public void validate( CreateDCChopperCommand dCChopper )throws Exception {
		Assert.notNull( dCChopper, "CreateDCChopperCommand should not be null" );
//		Assert.isNull( dCChopper.getDCChopperId(), "CreateDCChopperCommand identifier should be null" );
	}

	/**
	 * handles update validation for a DCChopper
	 */
	public void validate( UpdateDCChopperCommand dCChopper ) throws Exception {
		Assert.notNull( dCChopper, "UpdateDCChopperCommand should not be null" );
		Assert.notNull( dCChopper.getDCChopperId(), "UpdateDCChopperCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a DCChopper
	 */
    public void validate( DeleteDCChopperCommand dCChopper ) throws Exception {
		Assert.notNull( dCChopper, "{commandAlias} should not be null" );
		Assert.notNull( dCChopper.getDCChopperId(), "DeleteDCChopperCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a DCChopper
	 */
	public void validate( DCChopperFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "DCChopperFetchOneSummary should not be null" );
		Assert.notNull( summary.getDCChopperId(), "DCChopperFetchOneSummary identifier should not be null" );
	}



}
