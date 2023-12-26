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

public class AnalogLimitSetValidator {
		
	/**
	 * default constructor
	 */
	protected AnalogLimitSetValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public AnalogLimitSetValidator getInstance() {
		return new AnalogLimitSetValidator();
	}
		
	/**
	 * handles creation validation for a AnalogLimitSet
	 */
	public void validate( CreateAnalogLimitSetCommand analogLimitSet )throws Exception {
		Assert.notNull( analogLimitSet, "CreateAnalogLimitSetCommand should not be null" );
//		Assert.isNull( analogLimitSet.getAnalogLimitSetId(), "CreateAnalogLimitSetCommand identifier should be null" );
	}

	/**
	 * handles update validation for a AnalogLimitSet
	 */
	public void validate( UpdateAnalogLimitSetCommand analogLimitSet ) throws Exception {
		Assert.notNull( analogLimitSet, "UpdateAnalogLimitSetCommand should not be null" );
		Assert.notNull( analogLimitSet.getAnalogLimitSetId(), "UpdateAnalogLimitSetCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a AnalogLimitSet
	 */
    public void validate( DeleteAnalogLimitSetCommand analogLimitSet ) throws Exception {
		Assert.notNull( analogLimitSet, "{commandAlias} should not be null" );
		Assert.notNull( analogLimitSet.getAnalogLimitSetId(), "DeleteAnalogLimitSetCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a AnalogLimitSet
	 */
	public void validate( AnalogLimitSetFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "AnalogLimitSetFetchOneSummary should not be null" );
		Assert.notNull( summary.getAnalogLimitSetId(), "AnalogLimitSetFetchOneSummary identifier should not be null" );
	}



}
