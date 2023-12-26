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

public class EquipmentBoundaryVersionValidator {
		
	/**
	 * default constructor
	 */
	protected EquipmentBoundaryVersionValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public EquipmentBoundaryVersionValidator getInstance() {
		return new EquipmentBoundaryVersionValidator();
	}
		
	/**
	 * handles creation validation for a EquipmentBoundaryVersion
	 */
	public void validate( CreateEquipmentBoundaryVersionCommand equipmentBoundaryVersion )throws Exception {
		Assert.notNull( equipmentBoundaryVersion, "CreateEquipmentBoundaryVersionCommand should not be null" );
//		Assert.isNull( equipmentBoundaryVersion.getEquipmentBoundaryVersionId(), "CreateEquipmentBoundaryVersionCommand identifier should be null" );
	}

	/**
	 * handles update validation for a EquipmentBoundaryVersion
	 */
	public void validate( UpdateEquipmentBoundaryVersionCommand equipmentBoundaryVersion ) throws Exception {
		Assert.notNull( equipmentBoundaryVersion, "UpdateEquipmentBoundaryVersionCommand should not be null" );
		Assert.notNull( equipmentBoundaryVersion.getEquipmentBoundaryVersionId(), "UpdateEquipmentBoundaryVersionCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a EquipmentBoundaryVersion
	 */
    public void validate( DeleteEquipmentBoundaryVersionCommand equipmentBoundaryVersion ) throws Exception {
		Assert.notNull( equipmentBoundaryVersion, "{commandAlias} should not be null" );
		Assert.notNull( equipmentBoundaryVersion.getEquipmentBoundaryVersionId(), "DeleteEquipmentBoundaryVersionCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a EquipmentBoundaryVersion
	 */
	public void validate( EquipmentBoundaryVersionFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "EquipmentBoundaryVersionFetchOneSummary should not be null" );
		Assert.notNull( summary.getEquipmentBoundaryVersionId(), "EquipmentBoundaryVersionFetchOneSummary identifier should not be null" );
	}



}
