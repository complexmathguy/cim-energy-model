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

public class LoadResponseCharacteristicValidator {
		
	/**
	 * default constructor
	 */
	protected LoadResponseCharacteristicValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public LoadResponseCharacteristicValidator getInstance() {
		return new LoadResponseCharacteristicValidator();
	}
		
	/**
	 * handles creation validation for a LoadResponseCharacteristic
	 */
	public void validate( CreateLoadResponseCharacteristicCommand loadResponseCharacteristic )throws Exception {
		Assert.notNull( loadResponseCharacteristic, "CreateLoadResponseCharacteristicCommand should not be null" );
//		Assert.isNull( loadResponseCharacteristic.getLoadResponseCharacteristicId(), "CreateLoadResponseCharacteristicCommand identifier should be null" );
	}

	/**
	 * handles update validation for a LoadResponseCharacteristic
	 */
	public void validate( UpdateLoadResponseCharacteristicCommand loadResponseCharacteristic ) throws Exception {
		Assert.notNull( loadResponseCharacteristic, "UpdateLoadResponseCharacteristicCommand should not be null" );
		Assert.notNull( loadResponseCharacteristic.getLoadResponseCharacteristicId(), "UpdateLoadResponseCharacteristicCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a LoadResponseCharacteristic
	 */
    public void validate( DeleteLoadResponseCharacteristicCommand loadResponseCharacteristic ) throws Exception {
		Assert.notNull( loadResponseCharacteristic, "{commandAlias} should not be null" );
		Assert.notNull( loadResponseCharacteristic.getLoadResponseCharacteristicId(), "DeleteLoadResponseCharacteristicCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a LoadResponseCharacteristic
	 */
	public void validate( LoadResponseCharacteristicFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "LoadResponseCharacteristicFetchOneSummary should not be null" );
		Assert.notNull( summary.getLoadResponseCharacteristicId(), "LoadResponseCharacteristicFetchOneSummary identifier should not be null" );
	}



}
