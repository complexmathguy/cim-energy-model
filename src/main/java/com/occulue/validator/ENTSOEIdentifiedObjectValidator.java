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

public class ENTSOEIdentifiedObjectValidator {
		
	/**
	 * default constructor
	 */
	protected ENTSOEIdentifiedObjectValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ENTSOEIdentifiedObjectValidator getInstance() {
		return new ENTSOEIdentifiedObjectValidator();
	}
		
	/**
	 * handles creation validation for a ENTSOEIdentifiedObject
	 */
	public void validate( CreateENTSOEIdentifiedObjectCommand eNTSOEIdentifiedObject )throws Exception {
		Assert.notNull( eNTSOEIdentifiedObject, "CreateENTSOEIdentifiedObjectCommand should not be null" );
//		Assert.isNull( eNTSOEIdentifiedObject.getENTSOEIdentifiedObjectId(), "CreateENTSOEIdentifiedObjectCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ENTSOEIdentifiedObject
	 */
	public void validate( UpdateENTSOEIdentifiedObjectCommand eNTSOEIdentifiedObject ) throws Exception {
		Assert.notNull( eNTSOEIdentifiedObject, "UpdateENTSOEIdentifiedObjectCommand should not be null" );
		Assert.notNull( eNTSOEIdentifiedObject.getENTSOEIdentifiedObjectId(), "UpdateENTSOEIdentifiedObjectCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ENTSOEIdentifiedObject
	 */
    public void validate( DeleteENTSOEIdentifiedObjectCommand eNTSOEIdentifiedObject ) throws Exception {
		Assert.notNull( eNTSOEIdentifiedObject, "{commandAlias} should not be null" );
		Assert.notNull( eNTSOEIdentifiedObject.getENTSOEIdentifiedObjectId(), "DeleteENTSOEIdentifiedObjectCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ENTSOEIdentifiedObject
	 */
	public void validate( ENTSOEIdentifiedObjectFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ENTSOEIdentifiedObjectFetchOneSummary should not be null" );
		Assert.notNull( summary.getENTSOEIdentifiedObjectId(), "ENTSOEIdentifiedObjectFetchOneSummary identifier should not be null" );
	}



}
