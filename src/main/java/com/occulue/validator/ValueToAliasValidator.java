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

public class ValueToAliasValidator {
		
	/**
	 * default constructor
	 */
	protected ValueToAliasValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ValueToAliasValidator getInstance() {
		return new ValueToAliasValidator();
	}
		
	/**
	 * handles creation validation for a ValueToAlias
	 */
	public void validate( CreateValueToAliasCommand valueToAlias )throws Exception {
		Assert.notNull( valueToAlias, "CreateValueToAliasCommand should not be null" );
//		Assert.isNull( valueToAlias.getValueToAliasId(), "CreateValueToAliasCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ValueToAlias
	 */
	public void validate( UpdateValueToAliasCommand valueToAlias ) throws Exception {
		Assert.notNull( valueToAlias, "UpdateValueToAliasCommand should not be null" );
		Assert.notNull( valueToAlias.getValueToAliasId(), "UpdateValueToAliasCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ValueToAlias
	 */
    public void validate( DeleteValueToAliasCommand valueToAlias ) throws Exception {
		Assert.notNull( valueToAlias, "{commandAlias} should not be null" );
		Assert.notNull( valueToAlias.getValueToAliasId(), "DeleteValueToAliasCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ValueToAlias
	 */
	public void validate( ValueToAliasFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ValueToAliasFetchOneSummary should not be null" );
		Assert.notNull( summary.getValueToAliasId(), "ValueToAliasFetchOneSummary identifier should not be null" );
	}



}
