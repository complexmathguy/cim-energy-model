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

public class PositionPointValidator {
		
	/**
	 * default constructor
	 */
	protected PositionPointValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public PositionPointValidator getInstance() {
		return new PositionPointValidator();
	}
		
	/**
	 * handles creation validation for a PositionPoint
	 */
	public void validate( CreatePositionPointCommand positionPoint )throws Exception {
		Assert.notNull( positionPoint, "CreatePositionPointCommand should not be null" );
//		Assert.isNull( positionPoint.getPositionPointId(), "CreatePositionPointCommand identifier should be null" );
	}

	/**
	 * handles update validation for a PositionPoint
	 */
	public void validate( UpdatePositionPointCommand positionPoint ) throws Exception {
		Assert.notNull( positionPoint, "UpdatePositionPointCommand should not be null" );
		Assert.notNull( positionPoint.getPositionPointId(), "UpdatePositionPointCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a PositionPoint
	 */
    public void validate( DeletePositionPointCommand positionPoint ) throws Exception {
		Assert.notNull( positionPoint, "{commandAlias} should not be null" );
		Assert.notNull( positionPoint.getPositionPointId(), "DeletePositionPointCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a PositionPoint
	 */
	public void validate( PositionPointFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "PositionPointFetchOneSummary should not be null" );
		Assert.notNull( summary.getPositionPointId(), "PositionPointFetchOneSummary identifier should not be null" );
	}



}
