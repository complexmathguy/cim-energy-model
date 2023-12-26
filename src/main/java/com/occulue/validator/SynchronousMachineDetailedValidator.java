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

public class SynchronousMachineDetailedValidator {
		
	/**
	 * default constructor
	 */
	protected SynchronousMachineDetailedValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public SynchronousMachineDetailedValidator getInstance() {
		return new SynchronousMachineDetailedValidator();
	}
		
	/**
	 * handles creation validation for a SynchronousMachineDetailed
	 */
	public void validate( CreateSynchronousMachineDetailedCommand synchronousMachineDetailed )throws Exception {
		Assert.notNull( synchronousMachineDetailed, "CreateSynchronousMachineDetailedCommand should not be null" );
//		Assert.isNull( synchronousMachineDetailed.getSynchronousMachineDetailedId(), "CreateSynchronousMachineDetailedCommand identifier should be null" );
	}

	/**
	 * handles update validation for a SynchronousMachineDetailed
	 */
	public void validate( UpdateSynchronousMachineDetailedCommand synchronousMachineDetailed ) throws Exception {
		Assert.notNull( synchronousMachineDetailed, "UpdateSynchronousMachineDetailedCommand should not be null" );
		Assert.notNull( synchronousMachineDetailed.getSynchronousMachineDetailedId(), "UpdateSynchronousMachineDetailedCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a SynchronousMachineDetailed
	 */
    public void validate( DeleteSynchronousMachineDetailedCommand synchronousMachineDetailed ) throws Exception {
		Assert.notNull( synchronousMachineDetailed, "{commandAlias} should not be null" );
		Assert.notNull( synchronousMachineDetailed.getSynchronousMachineDetailedId(), "DeleteSynchronousMachineDetailedCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a SynchronousMachineDetailed
	 */
	public void validate( SynchronousMachineDetailedFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "SynchronousMachineDetailedFetchOneSummary should not be null" );
		Assert.notNull( summary.getSynchronousMachineDetailedId(), "SynchronousMachineDetailedFetchOneSummary identifier should not be null" );
	}



}
