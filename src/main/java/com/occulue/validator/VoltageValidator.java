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

public class VoltageValidator {
		
	/**
	 * default constructor
	 */
	protected VoltageValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public VoltageValidator getInstance() {
		return new VoltageValidator();
	}
		
	/**
	 * handles creation validation for a Voltage
	 */
	public void validate( CreateVoltageCommand voltage )throws Exception {
		Assert.notNull( voltage, "CreateVoltageCommand should not be null" );
//		Assert.isNull( voltage.getVoltageId(), "CreateVoltageCommand identifier should be null" );
	}

	/**
	 * handles update validation for a Voltage
	 */
	public void validate( UpdateVoltageCommand voltage ) throws Exception {
		Assert.notNull( voltage, "UpdateVoltageCommand should not be null" );
		Assert.notNull( voltage.getVoltageId(), "UpdateVoltageCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a Voltage
	 */
    public void validate( DeleteVoltageCommand voltage ) throws Exception {
		Assert.notNull( voltage, "{commandAlias} should not be null" );
		Assert.notNull( voltage.getVoltageId(), "DeleteVoltageCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a Voltage
	 */
	public void validate( VoltageFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "VoltageFetchOneSummary should not be null" );
		Assert.notNull( summary.getVoltageId(), "VoltageFetchOneSummary identifier should not be null" );
	}



}
