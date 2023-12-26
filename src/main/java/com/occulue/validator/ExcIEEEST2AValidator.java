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

public class ExcIEEEST2AValidator {
		
	/**
	 * default constructor
	 */
	protected ExcIEEEST2AValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcIEEEST2AValidator getInstance() {
		return new ExcIEEEST2AValidator();
	}
		
	/**
	 * handles creation validation for a ExcIEEEST2A
	 */
	public void validate( CreateExcIEEEST2ACommand excIEEEST2A )throws Exception {
		Assert.notNull( excIEEEST2A, "CreateExcIEEEST2ACommand should not be null" );
//		Assert.isNull( excIEEEST2A.getExcIEEEST2AId(), "CreateExcIEEEST2ACommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcIEEEST2A
	 */
	public void validate( UpdateExcIEEEST2ACommand excIEEEST2A ) throws Exception {
		Assert.notNull( excIEEEST2A, "UpdateExcIEEEST2ACommand should not be null" );
		Assert.notNull( excIEEEST2A.getExcIEEEST2AId(), "UpdateExcIEEEST2ACommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcIEEEST2A
	 */
    public void validate( DeleteExcIEEEST2ACommand excIEEEST2A ) throws Exception {
		Assert.notNull( excIEEEST2A, "{commandAlias} should not be null" );
		Assert.notNull( excIEEEST2A.getExcIEEEST2AId(), "DeleteExcIEEEST2ACommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcIEEEST2A
	 */
	public void validate( ExcIEEEST2AFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcIEEEST2AFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcIEEEST2AId(), "ExcIEEEST2AFetchOneSummary identifier should not be null" );
	}



}
