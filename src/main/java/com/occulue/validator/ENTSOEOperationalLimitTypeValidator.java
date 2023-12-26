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

public class ENTSOEOperationalLimitTypeValidator {
		
	/**
	 * default constructor
	 */
	protected ENTSOEOperationalLimitTypeValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ENTSOEOperationalLimitTypeValidator getInstance() {
		return new ENTSOEOperationalLimitTypeValidator();
	}
		
	/**
	 * handles creation validation for a ENTSOEOperationalLimitType
	 */
	public void validate( CreateENTSOEOperationalLimitTypeCommand eNTSOEOperationalLimitType )throws Exception {
		Assert.notNull( eNTSOEOperationalLimitType, "CreateENTSOEOperationalLimitTypeCommand should not be null" );
//		Assert.isNull( eNTSOEOperationalLimitType.getENTSOEOperationalLimitTypeId(), "CreateENTSOEOperationalLimitTypeCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ENTSOEOperationalLimitType
	 */
	public void validate( UpdateENTSOEOperationalLimitTypeCommand eNTSOEOperationalLimitType ) throws Exception {
		Assert.notNull( eNTSOEOperationalLimitType, "UpdateENTSOEOperationalLimitTypeCommand should not be null" );
		Assert.notNull( eNTSOEOperationalLimitType.getENTSOEOperationalLimitTypeId(), "UpdateENTSOEOperationalLimitTypeCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ENTSOEOperationalLimitType
	 */
    public void validate( DeleteENTSOEOperationalLimitTypeCommand eNTSOEOperationalLimitType ) throws Exception {
		Assert.notNull( eNTSOEOperationalLimitType, "{commandAlias} should not be null" );
		Assert.notNull( eNTSOEOperationalLimitType.getENTSOEOperationalLimitTypeId(), "DeleteENTSOEOperationalLimitTypeCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ENTSOEOperationalLimitType
	 */
	public void validate( ENTSOEOperationalLimitTypeFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ENTSOEOperationalLimitTypeFetchOneSummary should not be null" );
		Assert.notNull( summary.getENTSOEOperationalLimitTypeId(), "ENTSOEOperationalLimitTypeFetchOneSummary identifier should not be null" );
	}



}
