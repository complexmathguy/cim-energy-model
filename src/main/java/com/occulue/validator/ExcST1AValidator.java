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

public class ExcST1AValidator {
		
	/**
	 * default constructor
	 */
	protected ExcST1AValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcST1AValidator getInstance() {
		return new ExcST1AValidator();
	}
		
	/**
	 * handles creation validation for a ExcST1A
	 */
	public void validate( CreateExcST1ACommand excST1A )throws Exception {
		Assert.notNull( excST1A, "CreateExcST1ACommand should not be null" );
//		Assert.isNull( excST1A.getExcST1AId(), "CreateExcST1ACommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcST1A
	 */
	public void validate( UpdateExcST1ACommand excST1A ) throws Exception {
		Assert.notNull( excST1A, "UpdateExcST1ACommand should not be null" );
		Assert.notNull( excST1A.getExcST1AId(), "UpdateExcST1ACommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcST1A
	 */
    public void validate( DeleteExcST1ACommand excST1A ) throws Exception {
		Assert.notNull( excST1A, "{commandAlias} should not be null" );
		Assert.notNull( excST1A.getExcST1AId(), "DeleteExcST1ACommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcST1A
	 */
	public void validate( ExcST1AFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcST1AFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcST1AId(), "ExcST1AFetchOneSummary identifier should not be null" );
	}



}
