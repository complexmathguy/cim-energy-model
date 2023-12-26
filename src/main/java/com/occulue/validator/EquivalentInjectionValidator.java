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

public class EquivalentInjectionValidator {
		
	/**
	 * default constructor
	 */
	protected EquivalentInjectionValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public EquivalentInjectionValidator getInstance() {
		return new EquivalentInjectionValidator();
	}
		
	/**
	 * handles creation validation for a EquivalentInjection
	 */
	public void validate( CreateEquivalentInjectionCommand equivalentInjection )throws Exception {
		Assert.notNull( equivalentInjection, "CreateEquivalentInjectionCommand should not be null" );
//		Assert.isNull( equivalentInjection.getEquivalentInjectionId(), "CreateEquivalentInjectionCommand identifier should be null" );
	}

	/**
	 * handles update validation for a EquivalentInjection
	 */
	public void validate( UpdateEquivalentInjectionCommand equivalentInjection ) throws Exception {
		Assert.notNull( equivalentInjection, "UpdateEquivalentInjectionCommand should not be null" );
		Assert.notNull( equivalentInjection.getEquivalentInjectionId(), "UpdateEquivalentInjectionCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a EquivalentInjection
	 */
    public void validate( DeleteEquivalentInjectionCommand equivalentInjection ) throws Exception {
		Assert.notNull( equivalentInjection, "{commandAlias} should not be null" );
		Assert.notNull( equivalentInjection.getEquivalentInjectionId(), "DeleteEquivalentInjectionCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a EquivalentInjection
	 */
	public void validate( EquivalentInjectionFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "EquivalentInjectionFetchOneSummary should not be null" );
		Assert.notNull( summary.getEquivalentInjectionId(), "EquivalentInjectionFetchOneSummary identifier should not be null" );
	}



}
