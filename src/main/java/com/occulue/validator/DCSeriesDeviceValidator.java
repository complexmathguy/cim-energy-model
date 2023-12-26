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

public class DCSeriesDeviceValidator {
		
	/**
	 * default constructor
	 */
	protected DCSeriesDeviceValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public DCSeriesDeviceValidator getInstance() {
		return new DCSeriesDeviceValidator();
	}
		
	/**
	 * handles creation validation for a DCSeriesDevice
	 */
	public void validate( CreateDCSeriesDeviceCommand dCSeriesDevice )throws Exception {
		Assert.notNull( dCSeriesDevice, "CreateDCSeriesDeviceCommand should not be null" );
//		Assert.isNull( dCSeriesDevice.getDCSeriesDeviceId(), "CreateDCSeriesDeviceCommand identifier should be null" );
	}

	/**
	 * handles update validation for a DCSeriesDevice
	 */
	public void validate( UpdateDCSeriesDeviceCommand dCSeriesDevice ) throws Exception {
		Assert.notNull( dCSeriesDevice, "UpdateDCSeriesDeviceCommand should not be null" );
		Assert.notNull( dCSeriesDevice.getDCSeriesDeviceId(), "UpdateDCSeriesDeviceCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a DCSeriesDevice
	 */
    public void validate( DeleteDCSeriesDeviceCommand dCSeriesDevice ) throws Exception {
		Assert.notNull( dCSeriesDevice, "{commandAlias} should not be null" );
		Assert.notNull( dCSeriesDevice.getDCSeriesDeviceId(), "DeleteDCSeriesDeviceCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a DCSeriesDevice
	 */
	public void validate( DCSeriesDeviceFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "DCSeriesDeviceFetchOneSummary should not be null" );
		Assert.notNull( summary.getDCSeriesDeviceId(), "DCSeriesDeviceFetchOneSummary identifier should not be null" );
	}



}
