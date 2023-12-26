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

public class RegulatingCondEqValidator {
		
	/**
	 * default constructor
	 */
	protected RegulatingCondEqValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public RegulatingCondEqValidator getInstance() {
		return new RegulatingCondEqValidator();
	}
		
	/**
	 * handles creation validation for a RegulatingCondEq
	 */
	public void validate( CreateRegulatingCondEqCommand regulatingCondEq )throws Exception {
		Assert.notNull( regulatingCondEq, "CreateRegulatingCondEqCommand should not be null" );
//		Assert.isNull( regulatingCondEq.getRegulatingCondEqId(), "CreateRegulatingCondEqCommand identifier should be null" );
	}

	/**
	 * handles update validation for a RegulatingCondEq
	 */
	public void validate( UpdateRegulatingCondEqCommand regulatingCondEq ) throws Exception {
		Assert.notNull( regulatingCondEq, "UpdateRegulatingCondEqCommand should not be null" );
		Assert.notNull( regulatingCondEq.getRegulatingCondEqId(), "UpdateRegulatingCondEqCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a RegulatingCondEq
	 */
    public void validate( DeleteRegulatingCondEqCommand regulatingCondEq ) throws Exception {
		Assert.notNull( regulatingCondEq, "{commandAlias} should not be null" );
		Assert.notNull( regulatingCondEq.getRegulatingCondEqId(), "DeleteRegulatingCondEqCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a RegulatingCondEq
	 */
	public void validate( RegulatingCondEqFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "RegulatingCondEqFetchOneSummary should not be null" );
		Assert.notNull( summary.getRegulatingCondEqId(), "RegulatingCondEqFetchOneSummary identifier should not be null" );
	}



}
