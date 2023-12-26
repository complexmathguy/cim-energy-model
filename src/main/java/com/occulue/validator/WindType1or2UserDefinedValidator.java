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

public class WindType1or2UserDefinedValidator {
		
	/**
	 * default constructor
	 */
	protected WindType1or2UserDefinedValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public WindType1or2UserDefinedValidator getInstance() {
		return new WindType1or2UserDefinedValidator();
	}
		
	/**
	 * handles creation validation for a WindType1or2UserDefined
	 */
	public void validate( CreateWindType1or2UserDefinedCommand windType1or2UserDefined )throws Exception {
		Assert.notNull( windType1or2UserDefined, "CreateWindType1or2UserDefinedCommand should not be null" );
//		Assert.isNull( windType1or2UserDefined.getWindType1or2UserDefinedId(), "CreateWindType1or2UserDefinedCommand identifier should be null" );
	}

	/**
	 * handles update validation for a WindType1or2UserDefined
	 */
	public void validate( UpdateWindType1or2UserDefinedCommand windType1or2UserDefined ) throws Exception {
		Assert.notNull( windType1or2UserDefined, "UpdateWindType1or2UserDefinedCommand should not be null" );
		Assert.notNull( windType1or2UserDefined.getWindType1or2UserDefinedId(), "UpdateWindType1or2UserDefinedCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a WindType1or2UserDefined
	 */
    public void validate( DeleteWindType1or2UserDefinedCommand windType1or2UserDefined ) throws Exception {
		Assert.notNull( windType1or2UserDefined, "{commandAlias} should not be null" );
		Assert.notNull( windType1or2UserDefined.getWindType1or2UserDefinedId(), "DeleteWindType1or2UserDefinedCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a WindType1or2UserDefined
	 */
	public void validate( WindType1or2UserDefinedFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "WindType1or2UserDefinedFetchOneSummary should not be null" );
		Assert.notNull( summary.getWindType1or2UserDefinedId(), "WindType1or2UserDefinedFetchOneSummary identifier should not be null" );
	}



}
