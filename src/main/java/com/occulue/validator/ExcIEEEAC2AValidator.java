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

public class ExcIEEEAC2AValidator {
		
	/**
	 * default constructor
	 */
	protected ExcIEEEAC2AValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcIEEEAC2AValidator getInstance() {
		return new ExcIEEEAC2AValidator();
	}
		
	/**
	 * handles creation validation for a ExcIEEEAC2A
	 */
	public void validate( CreateExcIEEEAC2ACommand excIEEEAC2A )throws Exception {
		Assert.notNull( excIEEEAC2A, "CreateExcIEEEAC2ACommand should not be null" );
//		Assert.isNull( excIEEEAC2A.getExcIEEEAC2AId(), "CreateExcIEEEAC2ACommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcIEEEAC2A
	 */
	public void validate( UpdateExcIEEEAC2ACommand excIEEEAC2A ) throws Exception {
		Assert.notNull( excIEEEAC2A, "UpdateExcIEEEAC2ACommand should not be null" );
		Assert.notNull( excIEEEAC2A.getExcIEEEAC2AId(), "UpdateExcIEEEAC2ACommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcIEEEAC2A
	 */
    public void validate( DeleteExcIEEEAC2ACommand excIEEEAC2A ) throws Exception {
		Assert.notNull( excIEEEAC2A, "{commandAlias} should not be null" );
		Assert.notNull( excIEEEAC2A.getExcIEEEAC2AId(), "DeleteExcIEEEAC2ACommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcIEEEAC2A
	 */
	public void validate( ExcIEEEAC2AFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcIEEEAC2AFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcIEEEAC2AId(), "ExcIEEEAC2AFetchOneSummary identifier should not be null" );
	}



}
