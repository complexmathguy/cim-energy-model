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

public class SubstationValidator {
		
	/**
	 * default constructor
	 */
	protected SubstationValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public SubstationValidator getInstance() {
		return new SubstationValidator();
	}
		
	/**
	 * handles creation validation for a Substation
	 */
	public void validate( CreateSubstationCommand substation )throws Exception {
		Assert.notNull( substation, "CreateSubstationCommand should not be null" );
//		Assert.isNull( substation.getSubstationId(), "CreateSubstationCommand identifier should be null" );
	}

	/**
	 * handles update validation for a Substation
	 */
	public void validate( UpdateSubstationCommand substation ) throws Exception {
		Assert.notNull( substation, "UpdateSubstationCommand should not be null" );
		Assert.notNull( substation.getSubstationId(), "UpdateSubstationCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a Substation
	 */
    public void validate( DeleteSubstationCommand substation ) throws Exception {
		Assert.notNull( substation, "{commandAlias} should not be null" );
		Assert.notNull( substation.getSubstationId(), "DeleteSubstationCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a Substation
	 */
	public void validate( SubstationFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "SubstationFetchOneSummary should not be null" );
		Assert.notNull( summary.getSubstationId(), "SubstationFetchOneSummary identifier should not be null" );
	}



}
