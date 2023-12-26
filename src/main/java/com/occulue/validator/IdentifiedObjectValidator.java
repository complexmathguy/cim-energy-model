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

public class IdentifiedObjectValidator {
		
	/**
	 * default constructor
	 */
	protected IdentifiedObjectValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public IdentifiedObjectValidator getInstance() {
		return new IdentifiedObjectValidator();
	}
		
	/**
	 * handles creation validation for a IdentifiedObject
	 */
	public void validate( CreateIdentifiedObjectCommand identifiedObject )throws Exception {
		Assert.notNull( identifiedObject, "CreateIdentifiedObjectCommand should not be null" );
//		Assert.isNull( identifiedObject.getIdentifiedObjectId(), "CreateIdentifiedObjectCommand identifier should be null" );
	}

	/**
	 * handles update validation for a IdentifiedObject
	 */
	public void validate( UpdateIdentifiedObjectCommand identifiedObject ) throws Exception {
		Assert.notNull( identifiedObject, "UpdateIdentifiedObjectCommand should not be null" );
		Assert.notNull( identifiedObject.getIdentifiedObjectId(), "UpdateIdentifiedObjectCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a IdentifiedObject
	 */
    public void validate( DeleteIdentifiedObjectCommand identifiedObject ) throws Exception {
		Assert.notNull( identifiedObject, "{commandAlias} should not be null" );
		Assert.notNull( identifiedObject.getIdentifiedObjectId(), "DeleteIdentifiedObjectCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a IdentifiedObject
	 */
	public void validate( IdentifiedObjectFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "IdentifiedObjectFetchOneSummary should not be null" );
		Assert.notNull( summary.getIdentifiedObjectId(), "IdentifiedObjectFetchOneSummary identifier should not be null" );
	}



}
