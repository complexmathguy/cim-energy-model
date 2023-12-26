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

public class VoltageAdjusterUserDefinedValidator {
		
	/**
	 * default constructor
	 */
	protected VoltageAdjusterUserDefinedValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public VoltageAdjusterUserDefinedValidator getInstance() {
		return new VoltageAdjusterUserDefinedValidator();
	}
		
	/**
	 * handles creation validation for a VoltageAdjusterUserDefined
	 */
	public void validate( CreateVoltageAdjusterUserDefinedCommand voltageAdjusterUserDefined )throws Exception {
		Assert.notNull( voltageAdjusterUserDefined, "CreateVoltageAdjusterUserDefinedCommand should not be null" );
//		Assert.isNull( voltageAdjusterUserDefined.getVoltageAdjusterUserDefinedId(), "CreateVoltageAdjusterUserDefinedCommand identifier should be null" );
	}

	/**
	 * handles update validation for a VoltageAdjusterUserDefined
	 */
	public void validate( UpdateVoltageAdjusterUserDefinedCommand voltageAdjusterUserDefined ) throws Exception {
		Assert.notNull( voltageAdjusterUserDefined, "UpdateVoltageAdjusterUserDefinedCommand should not be null" );
		Assert.notNull( voltageAdjusterUserDefined.getVoltageAdjusterUserDefinedId(), "UpdateVoltageAdjusterUserDefinedCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a VoltageAdjusterUserDefined
	 */
    public void validate( DeleteVoltageAdjusterUserDefinedCommand voltageAdjusterUserDefined ) throws Exception {
		Assert.notNull( voltageAdjusterUserDefined, "{commandAlias} should not be null" );
		Assert.notNull( voltageAdjusterUserDefined.getVoltageAdjusterUserDefinedId(), "DeleteVoltageAdjusterUserDefinedCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a VoltageAdjusterUserDefined
	 */
	public void validate( VoltageAdjusterUserDefinedFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "VoltageAdjusterUserDefinedFetchOneSummary should not be null" );
		Assert.notNull( summary.getVoltageAdjusterUserDefinedId(), "VoltageAdjusterUserDefinedFetchOneSummary identifier should not be null" );
	}



}
