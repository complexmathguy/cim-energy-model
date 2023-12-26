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

public class PerCentValidator {
		
	/**
	 * default constructor
	 */
	protected PerCentValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public PerCentValidator getInstance() {
		return new PerCentValidator();
	}
		
	/**
	 * handles creation validation for a PerCent
	 */
	public void validate( CreatePerCentCommand perCent )throws Exception {
		Assert.notNull( perCent, "CreatePerCentCommand should not be null" );
//		Assert.isNull( perCent.getPerCentId(), "CreatePerCentCommand identifier should be null" );
	}

	/**
	 * handles update validation for a PerCent
	 */
	public void validate( UpdatePerCentCommand perCent ) throws Exception {
		Assert.notNull( perCent, "UpdatePerCentCommand should not be null" );
		Assert.notNull( perCent.getPerCentId(), "UpdatePerCentCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a PerCent
	 */
    public void validate( DeletePerCentCommand perCent ) throws Exception {
		Assert.notNull( perCent, "{commandAlias} should not be null" );
		Assert.notNull( perCent.getPerCentId(), "DeletePerCentCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a PerCent
	 */
	public void validate( PerCentFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "PerCentFetchOneSummary should not be null" );
		Assert.notNull( summary.getPerCentId(), "PerCentFetchOneSummary identifier should not be null" );
	}



}
