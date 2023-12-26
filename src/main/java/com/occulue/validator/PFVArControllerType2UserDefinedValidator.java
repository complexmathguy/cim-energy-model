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

public class PFVArControllerType2UserDefinedValidator {
		
	/**
	 * default constructor
	 */
	protected PFVArControllerType2UserDefinedValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public PFVArControllerType2UserDefinedValidator getInstance() {
		return new PFVArControllerType2UserDefinedValidator();
	}
		
	/**
	 * handles creation validation for a PFVArControllerType2UserDefined
	 */
	public void validate( CreatePFVArControllerType2UserDefinedCommand pFVArControllerType2UserDefined )throws Exception {
		Assert.notNull( pFVArControllerType2UserDefined, "CreatePFVArControllerType2UserDefinedCommand should not be null" );
//		Assert.isNull( pFVArControllerType2UserDefined.getPFVArControllerType2UserDefinedId(), "CreatePFVArControllerType2UserDefinedCommand identifier should be null" );
	}

	/**
	 * handles update validation for a PFVArControllerType2UserDefined
	 */
	public void validate( UpdatePFVArControllerType2UserDefinedCommand pFVArControllerType2UserDefined ) throws Exception {
		Assert.notNull( pFVArControllerType2UserDefined, "UpdatePFVArControllerType2UserDefinedCommand should not be null" );
		Assert.notNull( pFVArControllerType2UserDefined.getPFVArControllerType2UserDefinedId(), "UpdatePFVArControllerType2UserDefinedCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a PFVArControllerType2UserDefined
	 */
    public void validate( DeletePFVArControllerType2UserDefinedCommand pFVArControllerType2UserDefined ) throws Exception {
		Assert.notNull( pFVArControllerType2UserDefined, "{commandAlias} should not be null" );
		Assert.notNull( pFVArControllerType2UserDefined.getPFVArControllerType2UserDefinedId(), "DeletePFVArControllerType2UserDefinedCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a PFVArControllerType2UserDefined
	 */
	public void validate( PFVArControllerType2UserDefinedFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "PFVArControllerType2UserDefinedFetchOneSummary should not be null" );
		Assert.notNull( summary.getPFVArControllerType2UserDefinedId(), "PFVArControllerType2UserDefinedFetchOneSummary identifier should not be null" );
	}



}
