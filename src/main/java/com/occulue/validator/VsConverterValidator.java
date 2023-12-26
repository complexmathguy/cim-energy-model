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

public class VsConverterValidator {
		
	/**
	 * default constructor
	 */
	protected VsConverterValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public VsConverterValidator getInstance() {
		return new VsConverterValidator();
	}
		
	/**
	 * handles creation validation for a VsConverter
	 */
	public void validate( CreateVsConverterCommand vsConverter )throws Exception {
		Assert.notNull( vsConverter, "CreateVsConverterCommand should not be null" );
//		Assert.isNull( vsConverter.getVsConverterId(), "CreateVsConverterCommand identifier should be null" );
	}

	/**
	 * handles update validation for a VsConverter
	 */
	public void validate( UpdateVsConverterCommand vsConverter ) throws Exception {
		Assert.notNull( vsConverter, "UpdateVsConverterCommand should not be null" );
		Assert.notNull( vsConverter.getVsConverterId(), "UpdateVsConverterCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a VsConverter
	 */
    public void validate( DeleteVsConverterCommand vsConverter ) throws Exception {
		Assert.notNull( vsConverter, "{commandAlias} should not be null" );
		Assert.notNull( vsConverter.getVsConverterId(), "DeleteVsConverterCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a VsConverter
	 */
	public void validate( VsConverterFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "VsConverterFetchOneSummary should not be null" );
		Assert.notNull( summary.getVsConverterId(), "VsConverterFetchOneSummary identifier should not be null" );
	}



}
