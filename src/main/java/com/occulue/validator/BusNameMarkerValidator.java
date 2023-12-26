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

public class BusNameMarkerValidator {
		
	/**
	 * default constructor
	 */
	protected BusNameMarkerValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public BusNameMarkerValidator getInstance() {
		return new BusNameMarkerValidator();
	}
		
	/**
	 * handles creation validation for a BusNameMarker
	 */
	public void validate( CreateBusNameMarkerCommand busNameMarker )throws Exception {
		Assert.notNull( busNameMarker, "CreateBusNameMarkerCommand should not be null" );
//		Assert.isNull( busNameMarker.getBusNameMarkerId(), "CreateBusNameMarkerCommand identifier should be null" );
	}

	/**
	 * handles update validation for a BusNameMarker
	 */
	public void validate( UpdateBusNameMarkerCommand busNameMarker ) throws Exception {
		Assert.notNull( busNameMarker, "UpdateBusNameMarkerCommand should not be null" );
		Assert.notNull( busNameMarker.getBusNameMarkerId(), "UpdateBusNameMarkerCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a BusNameMarker
	 */
    public void validate( DeleteBusNameMarkerCommand busNameMarker ) throws Exception {
		Assert.notNull( busNameMarker, "{commandAlias} should not be null" );
		Assert.notNull( busNameMarker.getBusNameMarkerId(), "DeleteBusNameMarkerCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a BusNameMarker
	 */
	public void validate( BusNameMarkerFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "BusNameMarkerFetchOneSummary should not be null" );
		Assert.notNull( summary.getBusNameMarkerId(), "BusNameMarkerFetchOneSummary identifier should not be null" );
	}



}
