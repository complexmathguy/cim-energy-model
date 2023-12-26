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

public class RatioTapChangerValidator {
		
	/**
	 * default constructor
	 */
	protected RatioTapChangerValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public RatioTapChangerValidator getInstance() {
		return new RatioTapChangerValidator();
	}
		
	/**
	 * handles creation validation for a RatioTapChanger
	 */
	public void validate( CreateRatioTapChangerCommand ratioTapChanger )throws Exception {
		Assert.notNull( ratioTapChanger, "CreateRatioTapChangerCommand should not be null" );
//		Assert.isNull( ratioTapChanger.getRatioTapChangerId(), "CreateRatioTapChangerCommand identifier should be null" );
	}

	/**
	 * handles update validation for a RatioTapChanger
	 */
	public void validate( UpdateRatioTapChangerCommand ratioTapChanger ) throws Exception {
		Assert.notNull( ratioTapChanger, "UpdateRatioTapChangerCommand should not be null" );
		Assert.notNull( ratioTapChanger.getRatioTapChangerId(), "UpdateRatioTapChangerCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a RatioTapChanger
	 */
    public void validate( DeleteRatioTapChangerCommand ratioTapChanger ) throws Exception {
		Assert.notNull( ratioTapChanger, "{commandAlias} should not be null" );
		Assert.notNull( ratioTapChanger.getRatioTapChangerId(), "DeleteRatioTapChangerCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a RatioTapChanger
	 */
	public void validate( RatioTapChangerFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "RatioTapChangerFetchOneSummary should not be null" );
		Assert.notNull( summary.getRatioTapChangerId(), "RatioTapChangerFetchOneSummary identifier should not be null" );
	}



}
