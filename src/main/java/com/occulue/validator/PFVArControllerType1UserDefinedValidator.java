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

public class PFVArControllerType1UserDefinedValidator {
		
	/**
	 * default constructor
	 */
	protected PFVArControllerType1UserDefinedValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public PFVArControllerType1UserDefinedValidator getInstance() {
		return new PFVArControllerType1UserDefinedValidator();
	}
		
	/**
	 * handles creation validation for a PFVArControllerType1UserDefined
	 */
	public void validate( CreatePFVArControllerType1UserDefinedCommand pFVArControllerType1UserDefined )throws Exception {
		Assert.notNull( pFVArControllerType1UserDefined, "CreatePFVArControllerType1UserDefinedCommand should not be null" );
//		Assert.isNull( pFVArControllerType1UserDefined.getPFVArControllerType1UserDefinedId(), "CreatePFVArControllerType1UserDefinedCommand identifier should be null" );
	}

	/**
	 * handles update validation for a PFVArControllerType1UserDefined
	 */
	public void validate( UpdatePFVArControllerType1UserDefinedCommand pFVArControllerType1UserDefined ) throws Exception {
		Assert.notNull( pFVArControllerType1UserDefined, "UpdatePFVArControllerType1UserDefinedCommand should not be null" );
		Assert.notNull( pFVArControllerType1UserDefined.getPFVArControllerType1UserDefinedId(), "UpdatePFVArControllerType1UserDefinedCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a PFVArControllerType1UserDefined
	 */
    public void validate( DeletePFVArControllerType1UserDefinedCommand pFVArControllerType1UserDefined ) throws Exception {
		Assert.notNull( pFVArControllerType1UserDefined, "{commandAlias} should not be null" );
		Assert.notNull( pFVArControllerType1UserDefined.getPFVArControllerType1UserDefinedId(), "DeletePFVArControllerType1UserDefinedCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a PFVArControllerType1UserDefined
	 */
	public void validate( PFVArControllerType1UserDefinedFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "PFVArControllerType1UserDefinedFetchOneSummary should not be null" );
		Assert.notNull( summary.getPFVArControllerType1UserDefinedId(), "PFVArControllerType1UserDefinedFetchOneSummary identifier should not be null" );
	}



}
