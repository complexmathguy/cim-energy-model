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

public class ENTSOEJunctionValidator {
		
	/**
	 * default constructor
	 */
	protected ENTSOEJunctionValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ENTSOEJunctionValidator getInstance() {
		return new ENTSOEJunctionValidator();
	}
		
	/**
	 * handles creation validation for a ENTSOEJunction
	 */
	public void validate( CreateENTSOEJunctionCommand eNTSOEJunction )throws Exception {
		Assert.notNull( eNTSOEJunction, "CreateENTSOEJunctionCommand should not be null" );
//		Assert.isNull( eNTSOEJunction.getENTSOEJunctionId(), "CreateENTSOEJunctionCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ENTSOEJunction
	 */
	public void validate( UpdateENTSOEJunctionCommand eNTSOEJunction ) throws Exception {
		Assert.notNull( eNTSOEJunction, "UpdateENTSOEJunctionCommand should not be null" );
		Assert.notNull( eNTSOEJunction.getENTSOEJunctionId(), "UpdateENTSOEJunctionCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ENTSOEJunction
	 */
    public void validate( DeleteENTSOEJunctionCommand eNTSOEJunction ) throws Exception {
		Assert.notNull( eNTSOEJunction, "{commandAlias} should not be null" );
		Assert.notNull( eNTSOEJunction.getENTSOEJunctionId(), "DeleteENTSOEJunctionCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ENTSOEJunction
	 */
	public void validate( ENTSOEJunctionFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ENTSOEJunctionFetchOneSummary should not be null" );
		Assert.notNull( summary.getENTSOEJunctionId(), "ENTSOEJunctionFetchOneSummary identifier should not be null" );
	}



}
