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

public class TapChangerControlValidator {
		
	/**
	 * default constructor
	 */
	protected TapChangerControlValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public TapChangerControlValidator getInstance() {
		return new TapChangerControlValidator();
	}
		
	/**
	 * handles creation validation for a TapChangerControl
	 */
	public void validate( CreateTapChangerControlCommand tapChangerControl )throws Exception {
		Assert.notNull( tapChangerControl, "CreateTapChangerControlCommand should not be null" );
//		Assert.isNull( tapChangerControl.getTapChangerControlId(), "CreateTapChangerControlCommand identifier should be null" );
	}

	/**
	 * handles update validation for a TapChangerControl
	 */
	public void validate( UpdateTapChangerControlCommand tapChangerControl ) throws Exception {
		Assert.notNull( tapChangerControl, "UpdateTapChangerControlCommand should not be null" );
		Assert.notNull( tapChangerControl.getTapChangerControlId(), "UpdateTapChangerControlCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a TapChangerControl
	 */
    public void validate( DeleteTapChangerControlCommand tapChangerControl ) throws Exception {
		Assert.notNull( tapChangerControl, "{commandAlias} should not be null" );
		Assert.notNull( tapChangerControl.getTapChangerControlId(), "DeleteTapChangerControlCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a TapChangerControl
	 */
	public void validate( TapChangerControlFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "TapChangerControlFetchOneSummary should not be null" );
		Assert.notNull( summary.getTapChangerControlId(), "TapChangerControlFetchOneSummary identifier should not be null" );
	}



}
