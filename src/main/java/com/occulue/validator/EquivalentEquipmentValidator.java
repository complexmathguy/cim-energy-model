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

public class EquivalentEquipmentValidator {
		
	/**
	 * default constructor
	 */
	protected EquivalentEquipmentValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public EquivalentEquipmentValidator getInstance() {
		return new EquivalentEquipmentValidator();
	}
		
	/**
	 * handles creation validation for a EquivalentEquipment
	 */
	public void validate( CreateEquivalentEquipmentCommand equivalentEquipment )throws Exception {
		Assert.notNull( equivalentEquipment, "CreateEquivalentEquipmentCommand should not be null" );
//		Assert.isNull( equivalentEquipment.getEquivalentEquipmentId(), "CreateEquivalentEquipmentCommand identifier should be null" );
	}

	/**
	 * handles update validation for a EquivalentEquipment
	 */
	public void validate( UpdateEquivalentEquipmentCommand equivalentEquipment ) throws Exception {
		Assert.notNull( equivalentEquipment, "UpdateEquivalentEquipmentCommand should not be null" );
		Assert.notNull( equivalentEquipment.getEquivalentEquipmentId(), "UpdateEquivalentEquipmentCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a EquivalentEquipment
	 */
    public void validate( DeleteEquivalentEquipmentCommand equivalentEquipment ) throws Exception {
		Assert.notNull( equivalentEquipment, "{commandAlias} should not be null" );
		Assert.notNull( equivalentEquipment.getEquivalentEquipmentId(), "DeleteEquivalentEquipmentCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a EquivalentEquipment
	 */
	public void validate( EquivalentEquipmentFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "EquivalentEquipmentFetchOneSummary should not be null" );
		Assert.notNull( summary.getEquivalentEquipmentId(), "EquivalentEquipmentFetchOneSummary identifier should not be null" );
	}



}
