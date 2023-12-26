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

public class DCEquipmentContainerValidator {
		
	/**
	 * default constructor
	 */
	protected DCEquipmentContainerValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public DCEquipmentContainerValidator getInstance() {
		return new DCEquipmentContainerValidator();
	}
		
	/**
	 * handles creation validation for a DCEquipmentContainer
	 */
	public void validate( CreateDCEquipmentContainerCommand dCEquipmentContainer )throws Exception {
		Assert.notNull( dCEquipmentContainer, "CreateDCEquipmentContainerCommand should not be null" );
//		Assert.isNull( dCEquipmentContainer.getDCEquipmentContainerId(), "CreateDCEquipmentContainerCommand identifier should be null" );
	}

	/**
	 * handles update validation for a DCEquipmentContainer
	 */
	public void validate( UpdateDCEquipmentContainerCommand dCEquipmentContainer ) throws Exception {
		Assert.notNull( dCEquipmentContainer, "UpdateDCEquipmentContainerCommand should not be null" );
		Assert.notNull( dCEquipmentContainer.getDCEquipmentContainerId(), "UpdateDCEquipmentContainerCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a DCEquipmentContainer
	 */
    public void validate( DeleteDCEquipmentContainerCommand dCEquipmentContainer ) throws Exception {
		Assert.notNull( dCEquipmentContainer, "{commandAlias} should not be null" );
		Assert.notNull( dCEquipmentContainer.getDCEquipmentContainerId(), "DeleteDCEquipmentContainerCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a DCEquipmentContainer
	 */
	public void validate( DCEquipmentContainerFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "DCEquipmentContainerFetchOneSummary should not be null" );
		Assert.notNull( summary.getDCEquipmentContainerId(), "DCEquipmentContainerFetchOneSummary identifier should not be null" );
	}



}
