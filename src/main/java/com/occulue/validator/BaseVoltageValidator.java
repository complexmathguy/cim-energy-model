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

public class BaseVoltageValidator {
		
	/**
	 * default constructor
	 */
	protected BaseVoltageValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public BaseVoltageValidator getInstance() {
		return new BaseVoltageValidator();
	}
		
	/**
	 * handles creation validation for a BaseVoltage
	 */
	public void validate( CreateBaseVoltageCommand baseVoltage )throws Exception {
		Assert.notNull( baseVoltage, "CreateBaseVoltageCommand should not be null" );
//		Assert.isNull( baseVoltage.getBaseVoltageId(), "CreateBaseVoltageCommand identifier should be null" );
	}

	/**
	 * handles update validation for a BaseVoltage
	 */
	public void validate( UpdateBaseVoltageCommand baseVoltage ) throws Exception {
		Assert.notNull( baseVoltage, "UpdateBaseVoltageCommand should not be null" );
		Assert.notNull( baseVoltage.getBaseVoltageId(), "UpdateBaseVoltageCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a BaseVoltage
	 */
    public void validate( DeleteBaseVoltageCommand baseVoltage ) throws Exception {
		Assert.notNull( baseVoltage, "{commandAlias} should not be null" );
		Assert.notNull( baseVoltage.getBaseVoltageId(), "DeleteBaseVoltageCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a BaseVoltage
	 */
	public void validate( BaseVoltageFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "BaseVoltageFetchOneSummary should not be null" );
		Assert.notNull( summary.getBaseVoltageId(), "BaseVoltageFetchOneSummary identifier should not be null" );
	}



}
