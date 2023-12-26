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

public class CoordinateSystemValidator {
		
	/**
	 * default constructor
	 */
	protected CoordinateSystemValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public CoordinateSystemValidator getInstance() {
		return new CoordinateSystemValidator();
	}
		
	/**
	 * handles creation validation for a CoordinateSystem
	 */
	public void validate( CreateCoordinateSystemCommand coordinateSystem )throws Exception {
		Assert.notNull( coordinateSystem, "CreateCoordinateSystemCommand should not be null" );
//		Assert.isNull( coordinateSystem.getCoordinateSystemId(), "CreateCoordinateSystemCommand identifier should be null" );
	}

	/**
	 * handles update validation for a CoordinateSystem
	 */
	public void validate( UpdateCoordinateSystemCommand coordinateSystem ) throws Exception {
		Assert.notNull( coordinateSystem, "UpdateCoordinateSystemCommand should not be null" );
		Assert.notNull( coordinateSystem.getCoordinateSystemId(), "UpdateCoordinateSystemCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a CoordinateSystem
	 */
    public void validate( DeleteCoordinateSystemCommand coordinateSystem ) throws Exception {
		Assert.notNull( coordinateSystem, "{commandAlias} should not be null" );
		Assert.notNull( coordinateSystem.getCoordinateSystemId(), "DeleteCoordinateSystemCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a CoordinateSystem
	 */
	public void validate( CoordinateSystemFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "CoordinateSystemFetchOneSummary should not be null" );
		Assert.notNull( summary.getCoordinateSystemId(), "CoordinateSystemFetchOneSummary identifier should not be null" );
	}



}
