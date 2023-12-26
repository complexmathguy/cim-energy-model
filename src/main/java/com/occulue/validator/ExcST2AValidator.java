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

public class ExcST2AValidator {
		
	/**
	 * default constructor
	 */
	protected ExcST2AValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcST2AValidator getInstance() {
		return new ExcST2AValidator();
	}
		
	/**
	 * handles creation validation for a ExcST2A
	 */
	public void validate( CreateExcST2ACommand excST2A )throws Exception {
		Assert.notNull( excST2A, "CreateExcST2ACommand should not be null" );
//		Assert.isNull( excST2A.getExcST2AId(), "CreateExcST2ACommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcST2A
	 */
	public void validate( UpdateExcST2ACommand excST2A ) throws Exception {
		Assert.notNull( excST2A, "UpdateExcST2ACommand should not be null" );
		Assert.notNull( excST2A.getExcST2AId(), "UpdateExcST2ACommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcST2A
	 */
    public void validate( DeleteExcST2ACommand excST2A ) throws Exception {
		Assert.notNull( excST2A, "{commandAlias} should not be null" );
		Assert.notNull( excST2A.getExcST2AId(), "DeleteExcST2ACommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcST2A
	 */
	public void validate( ExcST2AFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcST2AFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcST2AId(), "ExcST2AFetchOneSummary identifier should not be null" );
	}



}
