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

public class TapChangerValidator {
		
	/**
	 * default constructor
	 */
	protected TapChangerValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public TapChangerValidator getInstance() {
		return new TapChangerValidator();
	}
		
	/**
	 * handles creation validation for a TapChanger
	 */
	public void validate( CreateTapChangerCommand tapChanger )throws Exception {
		Assert.notNull( tapChanger, "CreateTapChangerCommand should not be null" );
//		Assert.isNull( tapChanger.getTapChangerId(), "CreateTapChangerCommand identifier should be null" );
	}

	/**
	 * handles update validation for a TapChanger
	 */
	public void validate( UpdateTapChangerCommand tapChanger ) throws Exception {
		Assert.notNull( tapChanger, "UpdateTapChangerCommand should not be null" );
		Assert.notNull( tapChanger.getTapChangerId(), "UpdateTapChangerCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a TapChanger
	 */
    public void validate( DeleteTapChangerCommand tapChanger ) throws Exception {
		Assert.notNull( tapChanger, "{commandAlias} should not be null" );
		Assert.notNull( tapChanger.getTapChangerId(), "DeleteTapChangerCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a TapChanger
	 */
	public void validate( TapChangerFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "TapChangerFetchOneSummary should not be null" );
		Assert.notNull( summary.getTapChangerId(), "TapChangerFetchOneSummary identifier should not be null" );
	}



}
