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

public class EquipmentValidator {
		
	/**
	 * default constructor
	 */
	protected EquipmentValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public EquipmentValidator getInstance() {
		return new EquipmentValidator();
	}
		
	/**
	 * handles creation validation for a Equipment
	 */
	public void validate( CreateEquipmentCommand equipment )throws Exception {
		Assert.notNull( equipment, "CreateEquipmentCommand should not be null" );
//		Assert.isNull( equipment.getEquipmentId(), "CreateEquipmentCommand identifier should be null" );
	}

	/**
	 * handles update validation for a Equipment
	 */
	public void validate( UpdateEquipmentCommand equipment ) throws Exception {
		Assert.notNull( equipment, "UpdateEquipmentCommand should not be null" );
		Assert.notNull( equipment.getEquipmentId(), "UpdateEquipmentCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a Equipment
	 */
    public void validate( DeleteEquipmentCommand equipment ) throws Exception {
		Assert.notNull( equipment, "{commandAlias} should not be null" );
		Assert.notNull( equipment.getEquipmentId(), "DeleteEquipmentCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a Equipment
	 */
	public void validate( EquipmentFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "EquipmentFetchOneSummary should not be null" );
		Assert.notNull( summary.getEquipmentId(), "EquipmentFetchOneSummary identifier should not be null" );
	}



}
