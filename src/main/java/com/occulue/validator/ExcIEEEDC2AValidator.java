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

public class ExcIEEEDC2AValidator {
		
	/**
	 * default constructor
	 */
	protected ExcIEEEDC2AValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcIEEEDC2AValidator getInstance() {
		return new ExcIEEEDC2AValidator();
	}
		
	/**
	 * handles creation validation for a ExcIEEEDC2A
	 */
	public void validate( CreateExcIEEEDC2ACommand excIEEEDC2A )throws Exception {
		Assert.notNull( excIEEEDC2A, "CreateExcIEEEDC2ACommand should not be null" );
//		Assert.isNull( excIEEEDC2A.getExcIEEEDC2AId(), "CreateExcIEEEDC2ACommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcIEEEDC2A
	 */
	public void validate( UpdateExcIEEEDC2ACommand excIEEEDC2A ) throws Exception {
		Assert.notNull( excIEEEDC2A, "UpdateExcIEEEDC2ACommand should not be null" );
		Assert.notNull( excIEEEDC2A.getExcIEEEDC2AId(), "UpdateExcIEEEDC2ACommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcIEEEDC2A
	 */
    public void validate( DeleteExcIEEEDC2ACommand excIEEEDC2A ) throws Exception {
		Assert.notNull( excIEEEDC2A, "{commandAlias} should not be null" );
		Assert.notNull( excIEEEDC2A.getExcIEEEDC2AId(), "DeleteExcIEEEDC2ACommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcIEEEDC2A
	 */
	public void validate( ExcIEEEDC2AFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcIEEEDC2AFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcIEEEDC2AId(), "ExcIEEEDC2AFetchOneSummary identifier should not be null" );
	}



}
