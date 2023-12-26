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

public class ExcSCRXValidator {
		
	/**
	 * default constructor
	 */
	protected ExcSCRXValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcSCRXValidator getInstance() {
		return new ExcSCRXValidator();
	}
		
	/**
	 * handles creation validation for a ExcSCRX
	 */
	public void validate( CreateExcSCRXCommand excSCRX )throws Exception {
		Assert.notNull( excSCRX, "CreateExcSCRXCommand should not be null" );
//		Assert.isNull( excSCRX.getExcSCRXId(), "CreateExcSCRXCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcSCRX
	 */
	public void validate( UpdateExcSCRXCommand excSCRX ) throws Exception {
		Assert.notNull( excSCRX, "UpdateExcSCRXCommand should not be null" );
		Assert.notNull( excSCRX.getExcSCRXId(), "UpdateExcSCRXCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcSCRX
	 */
    public void validate( DeleteExcSCRXCommand excSCRX ) throws Exception {
		Assert.notNull( excSCRX, "{commandAlias} should not be null" );
		Assert.notNull( excSCRX.getExcSCRXId(), "DeleteExcSCRXCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcSCRX
	 */
	public void validate( ExcSCRXFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcSCRXFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcSCRXId(), "ExcSCRXFetchOneSummary identifier should not be null" );
	}



}
