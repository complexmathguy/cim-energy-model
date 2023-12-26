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

public class VoltageCompensatorUserDefinedValidator {
		
	/**
	 * default constructor
	 */
	protected VoltageCompensatorUserDefinedValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public VoltageCompensatorUserDefinedValidator getInstance() {
		return new VoltageCompensatorUserDefinedValidator();
	}
		
	/**
	 * handles creation validation for a VoltageCompensatorUserDefined
	 */
	public void validate( CreateVoltageCompensatorUserDefinedCommand voltageCompensatorUserDefined )throws Exception {
		Assert.notNull( voltageCompensatorUserDefined, "CreateVoltageCompensatorUserDefinedCommand should not be null" );
//		Assert.isNull( voltageCompensatorUserDefined.getVoltageCompensatorUserDefinedId(), "CreateVoltageCompensatorUserDefinedCommand identifier should be null" );
	}

	/**
	 * handles update validation for a VoltageCompensatorUserDefined
	 */
	public void validate( UpdateVoltageCompensatorUserDefinedCommand voltageCompensatorUserDefined ) throws Exception {
		Assert.notNull( voltageCompensatorUserDefined, "UpdateVoltageCompensatorUserDefinedCommand should not be null" );
		Assert.notNull( voltageCompensatorUserDefined.getVoltageCompensatorUserDefinedId(), "UpdateVoltageCompensatorUserDefinedCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a VoltageCompensatorUserDefined
	 */
    public void validate( DeleteVoltageCompensatorUserDefinedCommand voltageCompensatorUserDefined ) throws Exception {
		Assert.notNull( voltageCompensatorUserDefined, "{commandAlias} should not be null" );
		Assert.notNull( voltageCompensatorUserDefined.getVoltageCompensatorUserDefinedId(), "DeleteVoltageCompensatorUserDefinedCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a VoltageCompensatorUserDefined
	 */
	public void validate( VoltageCompensatorUserDefinedFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "VoltageCompensatorUserDefinedFetchOneSummary should not be null" );
		Assert.notNull( summary.getVoltageCompensatorUserDefinedId(), "VoltageCompensatorUserDefinedFetchOneSummary identifier should not be null" );
	}



}
