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

public class SvVoltageValidator {
		
	/**
	 * default constructor
	 */
	protected SvVoltageValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public SvVoltageValidator getInstance() {
		return new SvVoltageValidator();
	}
		
	/**
	 * handles creation validation for a SvVoltage
	 */
	public void validate( CreateSvVoltageCommand svVoltage )throws Exception {
		Assert.notNull( svVoltage, "CreateSvVoltageCommand should not be null" );
//		Assert.isNull( svVoltage.getSvVoltageId(), "CreateSvVoltageCommand identifier should be null" );
	}

	/**
	 * handles update validation for a SvVoltage
	 */
	public void validate( UpdateSvVoltageCommand svVoltage ) throws Exception {
		Assert.notNull( svVoltage, "UpdateSvVoltageCommand should not be null" );
		Assert.notNull( svVoltage.getSvVoltageId(), "UpdateSvVoltageCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a SvVoltage
	 */
    public void validate( DeleteSvVoltageCommand svVoltage ) throws Exception {
		Assert.notNull( svVoltage, "{commandAlias} should not be null" );
		Assert.notNull( svVoltage.getSvVoltageId(), "DeleteSvVoltageCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a SvVoltage
	 */
	public void validate( SvVoltageFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "SvVoltageFetchOneSummary should not be null" );
		Assert.notNull( summary.getSvVoltageId(), "SvVoltageFetchOneSummary identifier should not be null" );
	}



}
