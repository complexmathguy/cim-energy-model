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

public class VAdjIEEEValidator {
		
	/**
	 * default constructor
	 */
	protected VAdjIEEEValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public VAdjIEEEValidator getInstance() {
		return new VAdjIEEEValidator();
	}
		
	/**
	 * handles creation validation for a VAdjIEEE
	 */
	public void validate( CreateVAdjIEEECommand vAdjIEEE )throws Exception {
		Assert.notNull( vAdjIEEE, "CreateVAdjIEEECommand should not be null" );
//		Assert.isNull( vAdjIEEE.getVAdjIEEEId(), "CreateVAdjIEEECommand identifier should be null" );
	}

	/**
	 * handles update validation for a VAdjIEEE
	 */
	public void validate( UpdateVAdjIEEECommand vAdjIEEE ) throws Exception {
		Assert.notNull( vAdjIEEE, "UpdateVAdjIEEECommand should not be null" );
		Assert.notNull( vAdjIEEE.getVAdjIEEEId(), "UpdateVAdjIEEECommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a VAdjIEEE
	 */
    public void validate( DeleteVAdjIEEECommand vAdjIEEE ) throws Exception {
		Assert.notNull( vAdjIEEE, "{commandAlias} should not be null" );
		Assert.notNull( vAdjIEEE.getVAdjIEEEId(), "DeleteVAdjIEEECommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a VAdjIEEE
	 */
	public void validate( VAdjIEEEFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "VAdjIEEEFetchOneSummary should not be null" );
		Assert.notNull( summary.getVAdjIEEEId(), "VAdjIEEEFetchOneSummary identifier should not be null" );
	}



}
