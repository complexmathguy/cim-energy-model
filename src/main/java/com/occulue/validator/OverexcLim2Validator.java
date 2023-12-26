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

public class OverexcLim2Validator {
		
	/**
	 * default constructor
	 */
	protected OverexcLim2Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public OverexcLim2Validator getInstance() {
		return new OverexcLim2Validator();
	}
		
	/**
	 * handles creation validation for a OverexcLim2
	 */
	public void validate( CreateOverexcLim2Command overexcLim2 )throws Exception {
		Assert.notNull( overexcLim2, "CreateOverexcLim2Command should not be null" );
//		Assert.isNull( overexcLim2.getOverexcLim2Id(), "CreateOverexcLim2Command identifier should be null" );
	}

	/**
	 * handles update validation for a OverexcLim2
	 */
	public void validate( UpdateOverexcLim2Command overexcLim2 ) throws Exception {
		Assert.notNull( overexcLim2, "UpdateOverexcLim2Command should not be null" );
		Assert.notNull( overexcLim2.getOverexcLim2Id(), "UpdateOverexcLim2Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a OverexcLim2
	 */
    public void validate( DeleteOverexcLim2Command overexcLim2 ) throws Exception {
		Assert.notNull( overexcLim2, "{commandAlias} should not be null" );
		Assert.notNull( overexcLim2.getOverexcLim2Id(), "DeleteOverexcLim2Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a OverexcLim2
	 */
	public void validate( OverexcLim2FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "OverexcLim2FetchOneSummary should not be null" );
		Assert.notNull( summary.getOverexcLim2Id(), "OverexcLim2FetchOneSummary identifier should not be null" );
	}



}
