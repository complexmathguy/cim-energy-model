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

public class EquivalentShuntValidator {
		
	/**
	 * default constructor
	 */
	protected EquivalentShuntValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public EquivalentShuntValidator getInstance() {
		return new EquivalentShuntValidator();
	}
		
	/**
	 * handles creation validation for a EquivalentShunt
	 */
	public void validate( CreateEquivalentShuntCommand equivalentShunt )throws Exception {
		Assert.notNull( equivalentShunt, "CreateEquivalentShuntCommand should not be null" );
//		Assert.isNull( equivalentShunt.getEquivalentShuntId(), "CreateEquivalentShuntCommand identifier should be null" );
	}

	/**
	 * handles update validation for a EquivalentShunt
	 */
	public void validate( UpdateEquivalentShuntCommand equivalentShunt ) throws Exception {
		Assert.notNull( equivalentShunt, "UpdateEquivalentShuntCommand should not be null" );
		Assert.notNull( equivalentShunt.getEquivalentShuntId(), "UpdateEquivalentShuntCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a EquivalentShunt
	 */
    public void validate( DeleteEquivalentShuntCommand equivalentShunt ) throws Exception {
		Assert.notNull( equivalentShunt, "{commandAlias} should not be null" );
		Assert.notNull( equivalentShunt.getEquivalentShuntId(), "DeleteEquivalentShuntCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a EquivalentShunt
	 */
	public void validate( EquivalentShuntFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "EquivalentShuntFetchOneSummary should not be null" );
		Assert.notNull( summary.getEquivalentShuntId(), "EquivalentShuntFetchOneSummary identifier should not be null" );
	}



}
