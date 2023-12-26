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

public class ExcIEEEAC1AValidator {
		
	/**
	 * default constructor
	 */
	protected ExcIEEEAC1AValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcIEEEAC1AValidator getInstance() {
		return new ExcIEEEAC1AValidator();
	}
		
	/**
	 * handles creation validation for a ExcIEEEAC1A
	 */
	public void validate( CreateExcIEEEAC1ACommand excIEEEAC1A )throws Exception {
		Assert.notNull( excIEEEAC1A, "CreateExcIEEEAC1ACommand should not be null" );
//		Assert.isNull( excIEEEAC1A.getExcIEEEAC1AId(), "CreateExcIEEEAC1ACommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcIEEEAC1A
	 */
	public void validate( UpdateExcIEEEAC1ACommand excIEEEAC1A ) throws Exception {
		Assert.notNull( excIEEEAC1A, "UpdateExcIEEEAC1ACommand should not be null" );
		Assert.notNull( excIEEEAC1A.getExcIEEEAC1AId(), "UpdateExcIEEEAC1ACommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcIEEEAC1A
	 */
    public void validate( DeleteExcIEEEAC1ACommand excIEEEAC1A ) throws Exception {
		Assert.notNull( excIEEEAC1A, "{commandAlias} should not be null" );
		Assert.notNull( excIEEEAC1A.getExcIEEEAC1AId(), "DeleteExcIEEEAC1ACommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcIEEEAC1A
	 */
	public void validate( ExcIEEEAC1AFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcIEEEAC1AFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcIEEEAC1AId(), "ExcIEEEAC1AFetchOneSummary identifier should not be null" );
	}



}
