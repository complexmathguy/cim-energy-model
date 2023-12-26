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

public class DiscExcContIEEEDEC2AValidator {
		
	/**
	 * default constructor
	 */
	protected DiscExcContIEEEDEC2AValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public DiscExcContIEEEDEC2AValidator getInstance() {
		return new DiscExcContIEEEDEC2AValidator();
	}
		
	/**
	 * handles creation validation for a DiscExcContIEEEDEC2A
	 */
	public void validate( CreateDiscExcContIEEEDEC2ACommand discExcContIEEEDEC2A )throws Exception {
		Assert.notNull( discExcContIEEEDEC2A, "CreateDiscExcContIEEEDEC2ACommand should not be null" );
//		Assert.isNull( discExcContIEEEDEC2A.getDiscExcContIEEEDEC2AId(), "CreateDiscExcContIEEEDEC2ACommand identifier should be null" );
	}

	/**
	 * handles update validation for a DiscExcContIEEEDEC2A
	 */
	public void validate( UpdateDiscExcContIEEEDEC2ACommand discExcContIEEEDEC2A ) throws Exception {
		Assert.notNull( discExcContIEEEDEC2A, "UpdateDiscExcContIEEEDEC2ACommand should not be null" );
		Assert.notNull( discExcContIEEEDEC2A.getDiscExcContIEEEDEC2AId(), "UpdateDiscExcContIEEEDEC2ACommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a DiscExcContIEEEDEC2A
	 */
    public void validate( DeleteDiscExcContIEEEDEC2ACommand discExcContIEEEDEC2A ) throws Exception {
		Assert.notNull( discExcContIEEEDEC2A, "{commandAlias} should not be null" );
		Assert.notNull( discExcContIEEEDEC2A.getDiscExcContIEEEDEC2AId(), "DeleteDiscExcContIEEEDEC2ACommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a DiscExcContIEEEDEC2A
	 */
	public void validate( DiscExcContIEEEDEC2AFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "DiscExcContIEEEDEC2AFetchOneSummary should not be null" );
		Assert.notNull( summary.getDiscExcContIEEEDEC2AId(), "DiscExcContIEEEDEC2AFetchOneSummary identifier should not be null" );
	}



}
