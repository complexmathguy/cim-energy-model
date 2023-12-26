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

public class DCSwitchValidator {
		
	/**
	 * default constructor
	 */
	protected DCSwitchValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public DCSwitchValidator getInstance() {
		return new DCSwitchValidator();
	}
		
	/**
	 * handles creation validation for a DCSwitch
	 */
	public void validate( CreateDCSwitchCommand dCSwitch )throws Exception {
		Assert.notNull( dCSwitch, "CreateDCSwitchCommand should not be null" );
//		Assert.isNull( dCSwitch.getDCSwitchId(), "CreateDCSwitchCommand identifier should be null" );
	}

	/**
	 * handles update validation for a DCSwitch
	 */
	public void validate( UpdateDCSwitchCommand dCSwitch ) throws Exception {
		Assert.notNull( dCSwitch, "UpdateDCSwitchCommand should not be null" );
		Assert.notNull( dCSwitch.getDCSwitchId(), "UpdateDCSwitchCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a DCSwitch
	 */
    public void validate( DeleteDCSwitchCommand dCSwitch ) throws Exception {
		Assert.notNull( dCSwitch, "{commandAlias} should not be null" );
		Assert.notNull( dCSwitch.getDCSwitchId(), "DeleteDCSwitchCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a DCSwitch
	 */
	public void validate( DCSwitchFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "DCSwitchFetchOneSummary should not be null" );
		Assert.notNull( summary.getDCSwitchId(), "DCSwitchFetchOneSummary identifier should not be null" );
	}



}
