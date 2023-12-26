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

public class ReactivePowerValidator {
		
	/**
	 * default constructor
	 */
	protected ReactivePowerValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ReactivePowerValidator getInstance() {
		return new ReactivePowerValidator();
	}
		
	/**
	 * handles creation validation for a ReactivePower
	 */
	public void validate( CreateReactivePowerCommand reactivePower )throws Exception {
		Assert.notNull( reactivePower, "CreateReactivePowerCommand should not be null" );
//		Assert.isNull( reactivePower.getReactivePowerId(), "CreateReactivePowerCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ReactivePower
	 */
	public void validate( UpdateReactivePowerCommand reactivePower ) throws Exception {
		Assert.notNull( reactivePower, "UpdateReactivePowerCommand should not be null" );
		Assert.notNull( reactivePower.getReactivePowerId(), "UpdateReactivePowerCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ReactivePower
	 */
    public void validate( DeleteReactivePowerCommand reactivePower ) throws Exception {
		Assert.notNull( reactivePower, "{commandAlias} should not be null" );
		Assert.notNull( reactivePower.getReactivePowerId(), "DeleteReactivePowerCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ReactivePower
	 */
	public void validate( ReactivePowerFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ReactivePowerFetchOneSummary should not be null" );
		Assert.notNull( summary.getReactivePowerId(), "ReactivePowerFetchOneSummary identifier should not be null" );
	}



}
