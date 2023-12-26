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

public class FrequencyValidator {
		
	/**
	 * default constructor
	 */
	protected FrequencyValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public FrequencyValidator getInstance() {
		return new FrequencyValidator();
	}
		
	/**
	 * handles creation validation for a Frequency
	 */
	public void validate( CreateFrequencyCommand frequency )throws Exception {
		Assert.notNull( frequency, "CreateFrequencyCommand should not be null" );
//		Assert.isNull( frequency.getFrequencyId(), "CreateFrequencyCommand identifier should be null" );
	}

	/**
	 * handles update validation for a Frequency
	 */
	public void validate( UpdateFrequencyCommand frequency ) throws Exception {
		Assert.notNull( frequency, "UpdateFrequencyCommand should not be null" );
		Assert.notNull( frequency.getFrequencyId(), "UpdateFrequencyCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a Frequency
	 */
    public void validate( DeleteFrequencyCommand frequency ) throws Exception {
		Assert.notNull( frequency, "{commandAlias} should not be null" );
		Assert.notNull( frequency.getFrequencyId(), "DeleteFrequencyCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a Frequency
	 */
	public void validate( FrequencyFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "FrequencyFetchOneSummary should not be null" );
		Assert.notNull( summary.getFrequencyId(), "FrequencyFetchOneSummary identifier should not be null" );
	}



}
