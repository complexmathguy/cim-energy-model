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

public class CsConverterValidator {
		
	/**
	 * default constructor
	 */
	protected CsConverterValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public CsConverterValidator getInstance() {
		return new CsConverterValidator();
	}
		
	/**
	 * handles creation validation for a CsConverter
	 */
	public void validate( CreateCsConverterCommand csConverter )throws Exception {
		Assert.notNull( csConverter, "CreateCsConverterCommand should not be null" );
//		Assert.isNull( csConverter.getCsConverterId(), "CreateCsConverterCommand identifier should be null" );
	}

	/**
	 * handles update validation for a CsConverter
	 */
	public void validate( UpdateCsConverterCommand csConverter ) throws Exception {
		Assert.notNull( csConverter, "UpdateCsConverterCommand should not be null" );
		Assert.notNull( csConverter.getCsConverterId(), "UpdateCsConverterCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a CsConverter
	 */
    public void validate( DeleteCsConverterCommand csConverter ) throws Exception {
		Assert.notNull( csConverter, "{commandAlias} should not be null" );
		Assert.notNull( csConverter.getCsConverterId(), "DeleteCsConverterCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a CsConverter
	 */
	public void validate( CsConverterFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "CsConverterFetchOneSummary should not be null" );
		Assert.notNull( summary.getCsConverterId(), "CsConverterFetchOneSummary identifier should not be null" );
	}



}
