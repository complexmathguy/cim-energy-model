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

public class DCConductingEquipmentValidator {
		
	/**
	 * default constructor
	 */
	protected DCConductingEquipmentValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public DCConductingEquipmentValidator getInstance() {
		return new DCConductingEquipmentValidator();
	}
		
	/**
	 * handles creation validation for a DCConductingEquipment
	 */
	public void validate( CreateDCConductingEquipmentCommand dCConductingEquipment )throws Exception {
		Assert.notNull( dCConductingEquipment, "CreateDCConductingEquipmentCommand should not be null" );
//		Assert.isNull( dCConductingEquipment.getDCConductingEquipmentId(), "CreateDCConductingEquipmentCommand identifier should be null" );
	}

	/**
	 * handles update validation for a DCConductingEquipment
	 */
	public void validate( UpdateDCConductingEquipmentCommand dCConductingEquipment ) throws Exception {
		Assert.notNull( dCConductingEquipment, "UpdateDCConductingEquipmentCommand should not be null" );
		Assert.notNull( dCConductingEquipment.getDCConductingEquipmentId(), "UpdateDCConductingEquipmentCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a DCConductingEquipment
	 */
    public void validate( DeleteDCConductingEquipmentCommand dCConductingEquipment ) throws Exception {
		Assert.notNull( dCConductingEquipment, "{commandAlias} should not be null" );
		Assert.notNull( dCConductingEquipment.getDCConductingEquipmentId(), "DeleteDCConductingEquipmentCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a DCConductingEquipment
	 */
	public void validate( DCConductingEquipmentFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "DCConductingEquipmentFetchOneSummary should not be null" );
		Assert.notNull( summary.getDCConductingEquipmentId(), "DCConductingEquipmentFetchOneSummary identifier should not be null" );
	}



}
