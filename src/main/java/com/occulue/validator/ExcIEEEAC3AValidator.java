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

public class ExcIEEEAC3AValidator {
		
	/**
	 * default constructor
	 */
	protected ExcIEEEAC3AValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcIEEEAC3AValidator getInstance() {
		return new ExcIEEEAC3AValidator();
	}
		
	/**
	 * handles creation validation for a ExcIEEEAC3A
	 */
	public void validate( CreateExcIEEEAC3ACommand excIEEEAC3A )throws Exception {
		Assert.notNull( excIEEEAC3A, "CreateExcIEEEAC3ACommand should not be null" );
//		Assert.isNull( excIEEEAC3A.getExcIEEEAC3AId(), "CreateExcIEEEAC3ACommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcIEEEAC3A
	 */
	public void validate( UpdateExcIEEEAC3ACommand excIEEEAC3A ) throws Exception {
		Assert.notNull( excIEEEAC3A, "UpdateExcIEEEAC3ACommand should not be null" );
		Assert.notNull( excIEEEAC3A.getExcIEEEAC3AId(), "UpdateExcIEEEAC3ACommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcIEEEAC3A
	 */
    public void validate( DeleteExcIEEEAC3ACommand excIEEEAC3A ) throws Exception {
		Assert.notNull( excIEEEAC3A, "{commandAlias} should not be null" );
		Assert.notNull( excIEEEAC3A.getExcIEEEAC3AId(), "DeleteExcIEEEAC3ACommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcIEEEAC3A
	 */
	public void validate( ExcIEEEAC3AFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcIEEEAC3AFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcIEEEAC3AId(), "ExcIEEEAC3AFetchOneSummary identifier should not be null" );
	}



}
