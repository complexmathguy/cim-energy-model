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

public class SwitchItValidator {
		
	/**
	 * default constructor
	 */
	protected SwitchItValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public SwitchItValidator getInstance() {
		return new SwitchItValidator();
	}
		
	/**
	 * handles creation validation for a SwitchIt
	 */
	public void validate( CreateSwitchItCommand switchIt )throws Exception {
		Assert.notNull( switchIt, "CreateSwitchItCommand should not be null" );
//		Assert.isNull( switchIt.getSwitchItId(), "CreateSwitchItCommand identifier should be null" );
	}

	/**
	 * handles update validation for a SwitchIt
	 */
	public void validate( UpdateSwitchItCommand switchIt ) throws Exception {
		Assert.notNull( switchIt, "UpdateSwitchItCommand should not be null" );
		Assert.notNull( switchIt.getSwitchItId(), "UpdateSwitchItCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a SwitchIt
	 */
    public void validate( DeleteSwitchItCommand switchIt ) throws Exception {
		Assert.notNull( switchIt, "{commandAlias} should not be null" );
		Assert.notNull( switchIt.getSwitchItId(), "DeleteSwitchItCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a SwitchIt
	 */
	public void validate( SwitchItFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "SwitchItFetchOneSummary should not be null" );
		Assert.notNull( summary.getSwitchItId(), "SwitchItFetchOneSummary identifier should not be null" );
	}



}
