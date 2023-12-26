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

public class ExcIEEEAC4AValidator {
		
	/**
	 * default constructor
	 */
	protected ExcIEEEAC4AValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcIEEEAC4AValidator getInstance() {
		return new ExcIEEEAC4AValidator();
	}
		
	/**
	 * handles creation validation for a ExcIEEEAC4A
	 */
	public void validate( CreateExcIEEEAC4ACommand excIEEEAC4A )throws Exception {
		Assert.notNull( excIEEEAC4A, "CreateExcIEEEAC4ACommand should not be null" );
//		Assert.isNull( excIEEEAC4A.getExcIEEEAC4AId(), "CreateExcIEEEAC4ACommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcIEEEAC4A
	 */
	public void validate( UpdateExcIEEEAC4ACommand excIEEEAC4A ) throws Exception {
		Assert.notNull( excIEEEAC4A, "UpdateExcIEEEAC4ACommand should not be null" );
		Assert.notNull( excIEEEAC4A.getExcIEEEAC4AId(), "UpdateExcIEEEAC4ACommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcIEEEAC4A
	 */
    public void validate( DeleteExcIEEEAC4ACommand excIEEEAC4A ) throws Exception {
		Assert.notNull( excIEEEAC4A, "{commandAlias} should not be null" );
		Assert.notNull( excIEEEAC4A.getExcIEEEAC4AId(), "DeleteExcIEEEAC4ACommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcIEEEAC4A
	 */
	public void validate( ExcIEEEAC4AFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcIEEEAC4AFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcIEEEAC4AId(), "ExcIEEEAC4AFetchOneSummary identifier should not be null" );
	}



}
