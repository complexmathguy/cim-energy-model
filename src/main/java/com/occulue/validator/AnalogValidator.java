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

public class AnalogValidator {
		
	/**
	 * default constructor
	 */
	protected AnalogValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public AnalogValidator getInstance() {
		return new AnalogValidator();
	}
		
	/**
	 * handles creation validation for a Analog
	 */
	public void validate( CreateAnalogCommand analog )throws Exception {
		Assert.notNull( analog, "CreateAnalogCommand should not be null" );
//		Assert.isNull( analog.getAnalogId(), "CreateAnalogCommand identifier should be null" );
	}

	/**
	 * handles update validation for a Analog
	 */
	public void validate( UpdateAnalogCommand analog ) throws Exception {
		Assert.notNull( analog, "UpdateAnalogCommand should not be null" );
		Assert.notNull( analog.getAnalogId(), "UpdateAnalogCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a Analog
	 */
    public void validate( DeleteAnalogCommand analog ) throws Exception {
		Assert.notNull( analog, "{commandAlias} should not be null" );
		Assert.notNull( analog.getAnalogId(), "DeleteAnalogCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a Analog
	 */
	public void validate( AnalogFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "AnalogFetchOneSummary should not be null" );
		Assert.notNull( summary.getAnalogId(), "AnalogFetchOneSummary identifier should not be null" );
	}



}
