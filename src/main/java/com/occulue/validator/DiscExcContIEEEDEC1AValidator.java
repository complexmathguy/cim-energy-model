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

public class DiscExcContIEEEDEC1AValidator {
		
	/**
	 * default constructor
	 */
	protected DiscExcContIEEEDEC1AValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public DiscExcContIEEEDEC1AValidator getInstance() {
		return new DiscExcContIEEEDEC1AValidator();
	}
		
	/**
	 * handles creation validation for a DiscExcContIEEEDEC1A
	 */
	public void validate( CreateDiscExcContIEEEDEC1ACommand discExcContIEEEDEC1A )throws Exception {
		Assert.notNull( discExcContIEEEDEC1A, "CreateDiscExcContIEEEDEC1ACommand should not be null" );
//		Assert.isNull( discExcContIEEEDEC1A.getDiscExcContIEEEDEC1AId(), "CreateDiscExcContIEEEDEC1ACommand identifier should be null" );
	}

	/**
	 * handles update validation for a DiscExcContIEEEDEC1A
	 */
	public void validate( UpdateDiscExcContIEEEDEC1ACommand discExcContIEEEDEC1A ) throws Exception {
		Assert.notNull( discExcContIEEEDEC1A, "UpdateDiscExcContIEEEDEC1ACommand should not be null" );
		Assert.notNull( discExcContIEEEDEC1A.getDiscExcContIEEEDEC1AId(), "UpdateDiscExcContIEEEDEC1ACommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a DiscExcContIEEEDEC1A
	 */
    public void validate( DeleteDiscExcContIEEEDEC1ACommand discExcContIEEEDEC1A ) throws Exception {
		Assert.notNull( discExcContIEEEDEC1A, "{commandAlias} should not be null" );
		Assert.notNull( discExcContIEEEDEC1A.getDiscExcContIEEEDEC1AId(), "DeleteDiscExcContIEEEDEC1ACommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a DiscExcContIEEEDEC1A
	 */
	public void validate( DiscExcContIEEEDEC1AFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "DiscExcContIEEEDEC1AFetchOneSummary should not be null" );
		Assert.notNull( summary.getDiscExcContIEEEDEC1AId(), "DiscExcContIEEEDEC1AFetchOneSummary identifier should not be null" );
	}



}
