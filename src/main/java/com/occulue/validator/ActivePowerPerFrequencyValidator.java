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

public class ActivePowerPerFrequencyValidator {
		
	/**
	 * default constructor
	 */
	protected ActivePowerPerFrequencyValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ActivePowerPerFrequencyValidator getInstance() {
		return new ActivePowerPerFrequencyValidator();
	}
		
	/**
	 * handles creation validation for a ActivePowerPerFrequency
	 */
	public void validate( CreateActivePowerPerFrequencyCommand activePowerPerFrequency )throws Exception {
		Assert.notNull( activePowerPerFrequency, "CreateActivePowerPerFrequencyCommand should not be null" );
//		Assert.isNull( activePowerPerFrequency.getActivePowerPerFrequencyId(), "CreateActivePowerPerFrequencyCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ActivePowerPerFrequency
	 */
	public void validate( UpdateActivePowerPerFrequencyCommand activePowerPerFrequency ) throws Exception {
		Assert.notNull( activePowerPerFrequency, "UpdateActivePowerPerFrequencyCommand should not be null" );
		Assert.notNull( activePowerPerFrequency.getActivePowerPerFrequencyId(), "UpdateActivePowerPerFrequencyCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ActivePowerPerFrequency
	 */
    public void validate( DeleteActivePowerPerFrequencyCommand activePowerPerFrequency ) throws Exception {
		Assert.notNull( activePowerPerFrequency, "{commandAlias} should not be null" );
		Assert.notNull( activePowerPerFrequency.getActivePowerPerFrequencyId(), "DeleteActivePowerPerFrequencyCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ActivePowerPerFrequency
	 */
	public void validate( ActivePowerPerFrequencyFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ActivePowerPerFrequencyFetchOneSummary should not be null" );
		Assert.notNull( summary.getActivePowerPerFrequencyId(), "ActivePowerPerFrequencyFetchOneSummary identifier should not be null" );
	}



}
