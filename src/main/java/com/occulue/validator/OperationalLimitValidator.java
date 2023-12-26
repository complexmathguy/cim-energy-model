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

public class OperationalLimitValidator {
		
	/**
	 * default constructor
	 */
	protected OperationalLimitValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public OperationalLimitValidator getInstance() {
		return new OperationalLimitValidator();
	}
		
	/**
	 * handles creation validation for a OperationalLimit
	 */
	public void validate( CreateOperationalLimitCommand operationalLimit )throws Exception {
		Assert.notNull( operationalLimit, "CreateOperationalLimitCommand should not be null" );
//		Assert.isNull( operationalLimit.getOperationalLimitId(), "CreateOperationalLimitCommand identifier should be null" );
	}

	/**
	 * handles update validation for a OperationalLimit
	 */
	public void validate( UpdateOperationalLimitCommand operationalLimit ) throws Exception {
		Assert.notNull( operationalLimit, "UpdateOperationalLimitCommand should not be null" );
		Assert.notNull( operationalLimit.getOperationalLimitId(), "UpdateOperationalLimitCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a OperationalLimit
	 */
    public void validate( DeleteOperationalLimitCommand operationalLimit ) throws Exception {
		Assert.notNull( operationalLimit, "{commandAlias} should not be null" );
		Assert.notNull( operationalLimit.getOperationalLimitId(), "DeleteOperationalLimitCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a OperationalLimit
	 */
	public void validate( OperationalLimitFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "OperationalLimitFetchOneSummary should not be null" );
		Assert.notNull( summary.getOperationalLimitId(), "OperationalLimitFetchOneSummary identifier should not be null" );
	}



}
