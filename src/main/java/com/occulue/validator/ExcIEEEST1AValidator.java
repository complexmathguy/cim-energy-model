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

public class ExcIEEEST1AValidator {
		
	/**
	 * default constructor
	 */
	protected ExcIEEEST1AValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcIEEEST1AValidator getInstance() {
		return new ExcIEEEST1AValidator();
	}
		
	/**
	 * handles creation validation for a ExcIEEEST1A
	 */
	public void validate( CreateExcIEEEST1ACommand excIEEEST1A )throws Exception {
		Assert.notNull( excIEEEST1A, "CreateExcIEEEST1ACommand should not be null" );
//		Assert.isNull( excIEEEST1A.getExcIEEEST1AId(), "CreateExcIEEEST1ACommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcIEEEST1A
	 */
	public void validate( UpdateExcIEEEST1ACommand excIEEEST1A ) throws Exception {
		Assert.notNull( excIEEEST1A, "UpdateExcIEEEST1ACommand should not be null" );
		Assert.notNull( excIEEEST1A.getExcIEEEST1AId(), "UpdateExcIEEEST1ACommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcIEEEST1A
	 */
    public void validate( DeleteExcIEEEST1ACommand excIEEEST1A ) throws Exception {
		Assert.notNull( excIEEEST1A, "{commandAlias} should not be null" );
		Assert.notNull( excIEEEST1A.getExcIEEEST1AId(), "DeleteExcIEEEST1ACommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcIEEEST1A
	 */
	public void validate( ExcIEEEST1AFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcIEEEST1AFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcIEEEST1AId(), "ExcIEEEST1AFetchOneSummary identifier should not be null" );
	}



}
