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

public class ValueAliasSetValidator {
		
	/**
	 * default constructor
	 */
	protected ValueAliasSetValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ValueAliasSetValidator getInstance() {
		return new ValueAliasSetValidator();
	}
		
	/**
	 * handles creation validation for a ValueAliasSet
	 */
	public void validate( CreateValueAliasSetCommand valueAliasSet )throws Exception {
		Assert.notNull( valueAliasSet, "CreateValueAliasSetCommand should not be null" );
//		Assert.isNull( valueAliasSet.getValueAliasSetId(), "CreateValueAliasSetCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ValueAliasSet
	 */
	public void validate( UpdateValueAliasSetCommand valueAliasSet ) throws Exception {
		Assert.notNull( valueAliasSet, "UpdateValueAliasSetCommand should not be null" );
		Assert.notNull( valueAliasSet.getValueAliasSetId(), "UpdateValueAliasSetCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ValueAliasSet
	 */
    public void validate( DeleteValueAliasSetCommand valueAliasSet ) throws Exception {
		Assert.notNull( valueAliasSet, "{commandAlias} should not be null" );
		Assert.notNull( valueAliasSet.getValueAliasSetId(), "DeleteValueAliasSetCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ValueAliasSet
	 */
	public void validate( ValueAliasSetFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ValueAliasSetFetchOneSummary should not be null" );
		Assert.notNull( summary.getValueAliasSetId(), "ValueAliasSetFetchOneSummary identifier should not be null" );
	}



}
