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

public class ExcIEEEDC4BValidator {
		
	/**
	 * default constructor
	 */
	protected ExcIEEEDC4BValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcIEEEDC4BValidator getInstance() {
		return new ExcIEEEDC4BValidator();
	}
		
	/**
	 * handles creation validation for a ExcIEEEDC4B
	 */
	public void validate( CreateExcIEEEDC4BCommand excIEEEDC4B )throws Exception {
		Assert.notNull( excIEEEDC4B, "CreateExcIEEEDC4BCommand should not be null" );
//		Assert.isNull( excIEEEDC4B.getExcIEEEDC4BId(), "CreateExcIEEEDC4BCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcIEEEDC4B
	 */
	public void validate( UpdateExcIEEEDC4BCommand excIEEEDC4B ) throws Exception {
		Assert.notNull( excIEEEDC4B, "UpdateExcIEEEDC4BCommand should not be null" );
		Assert.notNull( excIEEEDC4B.getExcIEEEDC4BId(), "UpdateExcIEEEDC4BCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcIEEEDC4B
	 */
    public void validate( DeleteExcIEEEDC4BCommand excIEEEDC4B ) throws Exception {
		Assert.notNull( excIEEEDC4B, "{commandAlias} should not be null" );
		Assert.notNull( excIEEEDC4B.getExcIEEEDC4BId(), "DeleteExcIEEEDC4BCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcIEEEDC4B
	 */
	public void validate( ExcIEEEDC4BFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcIEEEDC4BFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcIEEEDC4BId(), "ExcIEEEDC4BFetchOneSummary identifier should not be null" );
	}



}
