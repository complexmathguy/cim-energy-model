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

public class ExcANSValidator {
		
	/**
	 * default constructor
	 */
	protected ExcANSValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ExcANSValidator getInstance() {
		return new ExcANSValidator();
	}
		
	/**
	 * handles creation validation for a ExcANS
	 */
	public void validate( CreateExcANSCommand excANS )throws Exception {
		Assert.notNull( excANS, "CreateExcANSCommand should not be null" );
//		Assert.isNull( excANS.getExcANSId(), "CreateExcANSCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ExcANS
	 */
	public void validate( UpdateExcANSCommand excANS ) throws Exception {
		Assert.notNull( excANS, "UpdateExcANSCommand should not be null" );
		Assert.notNull( excANS.getExcANSId(), "UpdateExcANSCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ExcANS
	 */
    public void validate( DeleteExcANSCommand excANS ) throws Exception {
		Assert.notNull( excANS, "{commandAlias} should not be null" );
		Assert.notNull( excANS.getExcANSId(), "DeleteExcANSCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ExcANS
	 */
	public void validate( ExcANSFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ExcANSFetchOneSummary should not be null" );
		Assert.notNull( summary.getExcANSId(), "ExcANSFetchOneSummary identifier should not be null" );
	}



}
