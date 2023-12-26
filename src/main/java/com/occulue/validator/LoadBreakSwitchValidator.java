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

public class LoadBreakSwitchValidator {
		
	/**
	 * default constructor
	 */
	protected LoadBreakSwitchValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public LoadBreakSwitchValidator getInstance() {
		return new LoadBreakSwitchValidator();
	}
		
	/**
	 * handles creation validation for a LoadBreakSwitch
	 */
	public void validate( CreateLoadBreakSwitchCommand loadBreakSwitch )throws Exception {
		Assert.notNull( loadBreakSwitch, "CreateLoadBreakSwitchCommand should not be null" );
//		Assert.isNull( loadBreakSwitch.getLoadBreakSwitchId(), "CreateLoadBreakSwitchCommand identifier should be null" );
	}

	/**
	 * handles update validation for a LoadBreakSwitch
	 */
	public void validate( UpdateLoadBreakSwitchCommand loadBreakSwitch ) throws Exception {
		Assert.notNull( loadBreakSwitch, "UpdateLoadBreakSwitchCommand should not be null" );
		Assert.notNull( loadBreakSwitch.getLoadBreakSwitchId(), "UpdateLoadBreakSwitchCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a LoadBreakSwitch
	 */
    public void validate( DeleteLoadBreakSwitchCommand loadBreakSwitch ) throws Exception {
		Assert.notNull( loadBreakSwitch, "{commandAlias} should not be null" );
		Assert.notNull( loadBreakSwitch.getLoadBreakSwitchId(), "DeleteLoadBreakSwitchCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a LoadBreakSwitch
	 */
	public void validate( LoadBreakSwitchFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "LoadBreakSwitchFetchOneSummary should not be null" );
		Assert.notNull( summary.getLoadBreakSwitchId(), "LoadBreakSwitchFetchOneSummary identifier should not be null" );
	}



}
