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

public class DCShuntValidator {
		
	/**
	 * default constructor
	 */
	protected DCShuntValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public DCShuntValidator getInstance() {
		return new DCShuntValidator();
	}
		
	/**
	 * handles creation validation for a DCShunt
	 */
	public void validate( CreateDCShuntCommand dCShunt )throws Exception {
		Assert.notNull( dCShunt, "CreateDCShuntCommand should not be null" );
//		Assert.isNull( dCShunt.getDCShuntId(), "CreateDCShuntCommand identifier should be null" );
	}

	/**
	 * handles update validation for a DCShunt
	 */
	public void validate( UpdateDCShuntCommand dCShunt ) throws Exception {
		Assert.notNull( dCShunt, "UpdateDCShuntCommand should not be null" );
		Assert.notNull( dCShunt.getDCShuntId(), "UpdateDCShuntCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a DCShunt
	 */
    public void validate( DeleteDCShuntCommand dCShunt ) throws Exception {
		Assert.notNull( dCShunt, "{commandAlias} should not be null" );
		Assert.notNull( dCShunt.getDCShuntId(), "DeleteDCShuntCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a DCShunt
	 */
	public void validate( DCShuntFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "DCShuntFetchOneSummary should not be null" );
		Assert.notNull( summary.getDCShuntId(), "DCShuntFetchOneSummary identifier should not be null" );
	}



}
