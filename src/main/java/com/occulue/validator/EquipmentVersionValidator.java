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

public class EquipmentVersionValidator {
		
	/**
	 * default constructor
	 */
	protected EquipmentVersionValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public EquipmentVersionValidator getInstance() {
		return new EquipmentVersionValidator();
	}
		
	/**
	 * handles creation validation for a EquipmentVersion
	 */
	public void validate( CreateEquipmentVersionCommand equipmentVersion )throws Exception {
		Assert.notNull( equipmentVersion, "CreateEquipmentVersionCommand should not be null" );
//		Assert.isNull( equipmentVersion.getEquipmentVersionId(), "CreateEquipmentVersionCommand identifier should be null" );
	}

	/**
	 * handles update validation for a EquipmentVersion
	 */
	public void validate( UpdateEquipmentVersionCommand equipmentVersion ) throws Exception {
		Assert.notNull( equipmentVersion, "UpdateEquipmentVersionCommand should not be null" );
		Assert.notNull( equipmentVersion.getEquipmentVersionId(), "UpdateEquipmentVersionCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a EquipmentVersion
	 */
    public void validate( DeleteEquipmentVersionCommand equipmentVersion ) throws Exception {
		Assert.notNull( equipmentVersion, "{commandAlias} should not be null" );
		Assert.notNull( equipmentVersion.getEquipmentVersionId(), "DeleteEquipmentVersionCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a EquipmentVersion
	 */
	public void validate( EquipmentVersionFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "EquipmentVersionFetchOneSummary should not be null" );
		Assert.notNull( summary.getEquipmentVersionId(), "EquipmentVersionFetchOneSummary identifier should not be null" );
	}



}
