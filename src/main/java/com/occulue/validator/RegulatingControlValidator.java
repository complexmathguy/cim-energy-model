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

public class RegulatingControlValidator {
		
	/**
	 * default constructor
	 */
	protected RegulatingControlValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public RegulatingControlValidator getInstance() {
		return new RegulatingControlValidator();
	}
		
	/**
	 * handles creation validation for a RegulatingControl
	 */
	public void validate( CreateRegulatingControlCommand regulatingControl )throws Exception {
		Assert.notNull( regulatingControl, "CreateRegulatingControlCommand should not be null" );
//		Assert.isNull( regulatingControl.getRegulatingControlId(), "CreateRegulatingControlCommand identifier should be null" );
	}

	/**
	 * handles update validation for a RegulatingControl
	 */
	public void validate( UpdateRegulatingControlCommand regulatingControl ) throws Exception {
		Assert.notNull( regulatingControl, "UpdateRegulatingControlCommand should not be null" );
		Assert.notNull( regulatingControl.getRegulatingControlId(), "UpdateRegulatingControlCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a RegulatingControl
	 */
    public void validate( DeleteRegulatingControlCommand regulatingControl ) throws Exception {
		Assert.notNull( regulatingControl, "{commandAlias} should not be null" );
		Assert.notNull( regulatingControl.getRegulatingControlId(), "DeleteRegulatingControlCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a RegulatingControl
	 */
	public void validate( RegulatingControlFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "RegulatingControlFetchOneSummary should not be null" );
		Assert.notNull( summary.getRegulatingControlId(), "RegulatingControlFetchOneSummary identifier should not be null" );
	}



}
