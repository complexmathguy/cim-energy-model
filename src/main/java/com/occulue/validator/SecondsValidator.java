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

public class SecondsValidator {
		
	/**
	 * default constructor
	 */
	protected SecondsValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public SecondsValidator getInstance() {
		return new SecondsValidator();
	}
		
	/**
	 * handles creation validation for a Seconds
	 */
	public void validate( CreateSecondsCommand seconds )throws Exception {
		Assert.notNull( seconds, "CreateSecondsCommand should not be null" );
//		Assert.isNull( seconds.getSecondsId(), "CreateSecondsCommand identifier should be null" );
	}

	/**
	 * handles update validation for a Seconds
	 */
	public void validate( UpdateSecondsCommand seconds ) throws Exception {
		Assert.notNull( seconds, "UpdateSecondsCommand should not be null" );
		Assert.notNull( seconds.getSecondsId(), "UpdateSecondsCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a Seconds
	 */
    public void validate( DeleteSecondsCommand seconds ) throws Exception {
		Assert.notNull( seconds, "{commandAlias} should not be null" );
		Assert.notNull( seconds.getSecondsId(), "DeleteSecondsCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a Seconds
	 */
	public void validate( SecondsFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "SecondsFetchOneSummary should not be null" );
		Assert.notNull( summary.getSecondsId(), "SecondsFetchOneSummary identifier should not be null" );
	}



}
