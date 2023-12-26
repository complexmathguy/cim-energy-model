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

public class OperationalLimitSetValidator {
		
	/**
	 * default constructor
	 */
	protected OperationalLimitSetValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public OperationalLimitSetValidator getInstance() {
		return new OperationalLimitSetValidator();
	}
		
	/**
	 * handles creation validation for a OperationalLimitSet
	 */
	public void validate( CreateOperationalLimitSetCommand operationalLimitSet )throws Exception {
		Assert.notNull( operationalLimitSet, "CreateOperationalLimitSetCommand should not be null" );
//		Assert.isNull( operationalLimitSet.getOperationalLimitSetId(), "CreateOperationalLimitSetCommand identifier should be null" );
	}

	/**
	 * handles update validation for a OperationalLimitSet
	 */
	public void validate( UpdateOperationalLimitSetCommand operationalLimitSet ) throws Exception {
		Assert.notNull( operationalLimitSet, "UpdateOperationalLimitSetCommand should not be null" );
		Assert.notNull( operationalLimitSet.getOperationalLimitSetId(), "UpdateOperationalLimitSetCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a OperationalLimitSet
	 */
    public void validate( DeleteOperationalLimitSetCommand operationalLimitSet ) throws Exception {
		Assert.notNull( operationalLimitSet, "{commandAlias} should not be null" );
		Assert.notNull( operationalLimitSet.getOperationalLimitSetId(), "DeleteOperationalLimitSetCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a OperationalLimitSet
	 */
	public void validate( OperationalLimitSetFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "OperationalLimitSetFetchOneSummary should not be null" );
		Assert.notNull( summary.getOperationalLimitSetId(), "OperationalLimitSetFetchOneSummary identifier should not be null" );
	}



}
