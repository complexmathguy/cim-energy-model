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

public class ACDCConverterValidator {
		
	/**
	 * default constructor
	 */
	protected ACDCConverterValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ACDCConverterValidator getInstance() {
		return new ACDCConverterValidator();
	}
		
	/**
	 * handles creation validation for a ACDCConverter
	 */
	public void validate( CreateACDCConverterCommand aCDCConverter )throws Exception {
		Assert.notNull( aCDCConverter, "CreateACDCConverterCommand should not be null" );
//		Assert.isNull( aCDCConverter.getACDCConverterId(), "CreateACDCConverterCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ACDCConverter
	 */
	public void validate( UpdateACDCConverterCommand aCDCConverter ) throws Exception {
		Assert.notNull( aCDCConverter, "UpdateACDCConverterCommand should not be null" );
		Assert.notNull( aCDCConverter.getACDCConverterId(), "UpdateACDCConverterCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ACDCConverter
	 */
    public void validate( DeleteACDCConverterCommand aCDCConverter ) throws Exception {
		Assert.notNull( aCDCConverter, "{commandAlias} should not be null" );
		Assert.notNull( aCDCConverter.getACDCConverterId(), "DeleteACDCConverterCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ACDCConverter
	 */
	public void validate( ACDCConverterFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ACDCConverterFetchOneSummary should not be null" );
		Assert.notNull( summary.getACDCConverterId(), "ACDCConverterFetchOneSummary identifier should not be null" );
	}



}
