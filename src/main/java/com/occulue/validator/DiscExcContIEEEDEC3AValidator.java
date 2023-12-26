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

public class DiscExcContIEEEDEC3AValidator {
		
	/**
	 * default constructor
	 */
	protected DiscExcContIEEEDEC3AValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public DiscExcContIEEEDEC3AValidator getInstance() {
		return new DiscExcContIEEEDEC3AValidator();
	}
		
	/**
	 * handles creation validation for a DiscExcContIEEEDEC3A
	 */
	public void validate( CreateDiscExcContIEEEDEC3ACommand discExcContIEEEDEC3A )throws Exception {
		Assert.notNull( discExcContIEEEDEC3A, "CreateDiscExcContIEEEDEC3ACommand should not be null" );
//		Assert.isNull( discExcContIEEEDEC3A.getDiscExcContIEEEDEC3AId(), "CreateDiscExcContIEEEDEC3ACommand identifier should be null" );
	}

	/**
	 * handles update validation for a DiscExcContIEEEDEC3A
	 */
	public void validate( UpdateDiscExcContIEEEDEC3ACommand discExcContIEEEDEC3A ) throws Exception {
		Assert.notNull( discExcContIEEEDEC3A, "UpdateDiscExcContIEEEDEC3ACommand should not be null" );
		Assert.notNull( discExcContIEEEDEC3A.getDiscExcContIEEEDEC3AId(), "UpdateDiscExcContIEEEDEC3ACommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a DiscExcContIEEEDEC3A
	 */
    public void validate( DeleteDiscExcContIEEEDEC3ACommand discExcContIEEEDEC3A ) throws Exception {
		Assert.notNull( discExcContIEEEDEC3A, "{commandAlias} should not be null" );
		Assert.notNull( discExcContIEEEDEC3A.getDiscExcContIEEEDEC3AId(), "DeleteDiscExcContIEEEDEC3ACommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a DiscExcContIEEEDEC3A
	 */
	public void validate( DiscExcContIEEEDEC3AFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "DiscExcContIEEEDEC3AFetchOneSummary should not be null" );
		Assert.notNull( summary.getDiscExcContIEEEDEC3AId(), "DiscExcContIEEEDEC3AFetchOneSummary identifier should not be null" );
	}



}
