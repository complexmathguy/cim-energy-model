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

public class MutualCouplingValidator {
		
	/**
	 * default constructor
	 */
	protected MutualCouplingValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public MutualCouplingValidator getInstance() {
		return new MutualCouplingValidator();
	}
		
	/**
	 * handles creation validation for a MutualCoupling
	 */
	public void validate( CreateMutualCouplingCommand mutualCoupling )throws Exception {
		Assert.notNull( mutualCoupling, "CreateMutualCouplingCommand should not be null" );
//		Assert.isNull( mutualCoupling.getMutualCouplingId(), "CreateMutualCouplingCommand identifier should be null" );
	}

	/**
	 * handles update validation for a MutualCoupling
	 */
	public void validate( UpdateMutualCouplingCommand mutualCoupling ) throws Exception {
		Assert.notNull( mutualCoupling, "UpdateMutualCouplingCommand should not be null" );
		Assert.notNull( mutualCoupling.getMutualCouplingId(), "UpdateMutualCouplingCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a MutualCoupling
	 */
    public void validate( DeleteMutualCouplingCommand mutualCoupling ) throws Exception {
		Assert.notNull( mutualCoupling, "{commandAlias} should not be null" );
		Assert.notNull( mutualCoupling.getMutualCouplingId(), "DeleteMutualCouplingCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a MutualCoupling
	 */
	public void validate( MutualCouplingFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "MutualCouplingFetchOneSummary should not be null" );
		Assert.notNull( summary.getMutualCouplingId(), "MutualCouplingFetchOneSummary identifier should not be null" );
	}



}
