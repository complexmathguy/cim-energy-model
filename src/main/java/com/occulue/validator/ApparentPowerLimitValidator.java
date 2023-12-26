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

public class ApparentPowerLimitValidator {
		
	/**
	 * default constructor
	 */
	protected ApparentPowerLimitValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ApparentPowerLimitValidator getInstance() {
		return new ApparentPowerLimitValidator();
	}
		
	/**
	 * handles creation validation for a ApparentPowerLimit
	 */
	public void validate( CreateApparentPowerLimitCommand apparentPowerLimit )throws Exception {
		Assert.notNull( apparentPowerLimit, "CreateApparentPowerLimitCommand should not be null" );
//		Assert.isNull( apparentPowerLimit.getApparentPowerLimitId(), "CreateApparentPowerLimitCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ApparentPowerLimit
	 */
	public void validate( UpdateApparentPowerLimitCommand apparentPowerLimit ) throws Exception {
		Assert.notNull( apparentPowerLimit, "UpdateApparentPowerLimitCommand should not be null" );
		Assert.notNull( apparentPowerLimit.getApparentPowerLimitId(), "UpdateApparentPowerLimitCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ApparentPowerLimit
	 */
    public void validate( DeleteApparentPowerLimitCommand apparentPowerLimit ) throws Exception {
		Assert.notNull( apparentPowerLimit, "{commandAlias} should not be null" );
		Assert.notNull( apparentPowerLimit.getApparentPowerLimitId(), "DeleteApparentPowerLimitCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ApparentPowerLimit
	 */
	public void validate( ApparentPowerLimitFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ApparentPowerLimitFetchOneSummary should not be null" );
		Assert.notNull( summary.getApparentPowerLimitId(), "ApparentPowerLimitFetchOneSummary identifier should not be null" );
	}



}
