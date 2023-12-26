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

public class ExcIEEEDC1AValidator {
		
	/**
	 * default constructor
	 */
	protected ExcIEEEDC1AValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcIEEEDC1AValidator getInstance() {
		return new ExcIEEEDC1AValidator();
	}
		
	/**
	 * handles creation validation for a ExcIEEEDC1A
	 */
	public void validate( CreateExcIEEEDC1ACommand excIEEEDC1A )throws Exception {
		Assert.notNull( excIEEEDC1A, "CreateExcIEEEDC1ACommand should not be null" );
//		Assert.isNull( excIEEEDC1A.getExcIEEEDC1AId(), "CreateExcIEEEDC1ACommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcIEEEDC1A
	 */
	public void validate( UpdateExcIEEEDC1ACommand excIEEEDC1A ) throws Exception {
		Assert.notNull( excIEEEDC1A, "UpdateExcIEEEDC1ACommand should not be null" );
		Assert.notNull( excIEEEDC1A.getExcIEEEDC1AId(), "UpdateExcIEEEDC1ACommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcIEEEDC1A
	 */
    public void validate( DeleteExcIEEEDC1ACommand excIEEEDC1A ) throws Exception {
		Assert.notNull( excIEEEDC1A, "{commandAlias} should not be null" );
		Assert.notNull( excIEEEDC1A.getExcIEEEDC1AId(), "DeleteExcIEEEDC1ACommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcIEEEDC1A
	 */
	public void validate( ExcIEEEDC1AFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcIEEEDC1AFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcIEEEDC1AId(), "ExcIEEEDC1AFetchOneSummary identifier should not be null" );
	}



}
