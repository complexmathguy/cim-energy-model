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

public class VolumeFlowRateValidator {
		
	/**
	 * default constructor
	 */
	protected VolumeFlowRateValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public VolumeFlowRateValidator getInstance() {
		return new VolumeFlowRateValidator();
	}
		
	/**
	 * handles creation validation for a VolumeFlowRate
	 */
	public void validate( CreateVolumeFlowRateCommand volumeFlowRate )throws Exception {
		Assert.notNull( volumeFlowRate, "CreateVolumeFlowRateCommand should not be null" );
//		Assert.isNull( volumeFlowRate.getVolumeFlowRateId(), "CreateVolumeFlowRateCommand identifier should be null" );
	}

	/**
	 * handles update validation for a VolumeFlowRate
	 */
	public void validate( UpdateVolumeFlowRateCommand volumeFlowRate ) throws Exception {
		Assert.notNull( volumeFlowRate, "UpdateVolumeFlowRateCommand should not be null" );
		Assert.notNull( volumeFlowRate.getVolumeFlowRateId(), "UpdateVolumeFlowRateCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a VolumeFlowRate
	 */
    public void validate( DeleteVolumeFlowRateCommand volumeFlowRate ) throws Exception {
		Assert.notNull( volumeFlowRate, "{commandAlias} should not be null" );
		Assert.notNull( volumeFlowRate.getVolumeFlowRateId(), "DeleteVolumeFlowRateCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a VolumeFlowRate
	 */
	public void validate( VolumeFlowRateFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "VolumeFlowRateFetchOneSummary should not be null" );
		Assert.notNull( summary.getVolumeFlowRateId(), "VolumeFlowRateFetchOneSummary identifier should not be null" );
	}



}
