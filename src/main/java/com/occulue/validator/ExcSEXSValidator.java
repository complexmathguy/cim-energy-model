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

public class ExcSEXSValidator {
		
	/**
	 * default constructor
	 */
	protected ExcSEXSValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcSEXSValidator getInstance() {
		return new ExcSEXSValidator();
	}
		
	/**
	 * handles creation validation for a ExcSEXS
	 */
	public void validate( CreateExcSEXSCommand excSEXS )throws Exception {
		Assert.notNull( excSEXS, "CreateExcSEXSCommand should not be null" );
//		Assert.isNull( excSEXS.getExcSEXSId(), "CreateExcSEXSCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcSEXS
	 */
	public void validate( UpdateExcSEXSCommand excSEXS ) throws Exception {
		Assert.notNull( excSEXS, "UpdateExcSEXSCommand should not be null" );
		Assert.notNull( excSEXS.getExcSEXSId(), "UpdateExcSEXSCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcSEXS
	 */
    public void validate( DeleteExcSEXSCommand excSEXS ) throws Exception {
		Assert.notNull( excSEXS, "{commandAlias} should not be null" );
		Assert.notNull( excSEXS.getExcSEXSId(), "DeleteExcSEXSCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcSEXS
	 */
	public void validate( ExcSEXSFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcSEXSFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcSEXSId(), "ExcSEXSFetchOneSummary identifier should not be null" );
	}



}
