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

public class ExcIEEEDC3AValidator {
		
	/**
	 * default constructor
	 */
	protected ExcIEEEDC3AValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcIEEEDC3AValidator getInstance() {
		return new ExcIEEEDC3AValidator();
	}
		
	/**
	 * handles creation validation for a ExcIEEEDC3A
	 */
	public void validate( CreateExcIEEEDC3ACommand excIEEEDC3A )throws Exception {
		Assert.notNull( excIEEEDC3A, "CreateExcIEEEDC3ACommand should not be null" );
//		Assert.isNull( excIEEEDC3A.getExcIEEEDC3AId(), "CreateExcIEEEDC3ACommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcIEEEDC3A
	 */
	public void validate( UpdateExcIEEEDC3ACommand excIEEEDC3A ) throws Exception {
		Assert.notNull( excIEEEDC3A, "UpdateExcIEEEDC3ACommand should not be null" );
		Assert.notNull( excIEEEDC3A.getExcIEEEDC3AId(), "UpdateExcIEEEDC3ACommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcIEEEDC3A
	 */
    public void validate( DeleteExcIEEEDC3ACommand excIEEEDC3A ) throws Exception {
		Assert.notNull( excIEEEDC3A, "{commandAlias} should not be null" );
		Assert.notNull( excIEEEDC3A.getExcIEEEDC3AId(), "DeleteExcIEEEDC3ACommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcIEEEDC3A
	 */
	public void validate( ExcIEEEDC3AFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcIEEEDC3AFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcIEEEDC3AId(), "ExcIEEEDC3AFetchOneSummary identifier should not be null" );
	}



}
