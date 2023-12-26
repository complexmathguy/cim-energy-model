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

public class OperationalLimitTypeValidator {
		
	/**
	 * default constructor
	 */
	protected OperationalLimitTypeValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public OperationalLimitTypeValidator getInstance() {
		return new OperationalLimitTypeValidator();
	}
		
	/**
	 * handles creation validation for a OperationalLimitType
	 */
	public void validate( CreateOperationalLimitTypeCommand operationalLimitType )throws Exception {
		Assert.notNull( operationalLimitType, "CreateOperationalLimitTypeCommand should not be null" );
//		Assert.isNull( operationalLimitType.getOperationalLimitTypeId(), "CreateOperationalLimitTypeCommand identifier should be null" );
	}

	/**
	 * handles update validation for a OperationalLimitType
	 */
	public void validate( UpdateOperationalLimitTypeCommand operationalLimitType ) throws Exception {
		Assert.notNull( operationalLimitType, "UpdateOperationalLimitTypeCommand should not be null" );
		Assert.notNull( operationalLimitType.getOperationalLimitTypeId(), "UpdateOperationalLimitTypeCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a OperationalLimitType
	 */
    public void validate( DeleteOperationalLimitTypeCommand operationalLimitType ) throws Exception {
		Assert.notNull( operationalLimitType, "{commandAlias} should not be null" );
		Assert.notNull( operationalLimitType.getOperationalLimitTypeId(), "DeleteOperationalLimitTypeCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a OperationalLimitType
	 */
	public void validate( OperationalLimitTypeFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "OperationalLimitTypeFetchOneSummary should not be null" );
		Assert.notNull( summary.getOperationalLimitTypeId(), "OperationalLimitTypeFetchOneSummary identifier should not be null" );
	}



}
