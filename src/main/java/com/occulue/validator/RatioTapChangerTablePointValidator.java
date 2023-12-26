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

public class RatioTapChangerTablePointValidator {
		
	/**
	 * default constructor
	 */
	protected RatioTapChangerTablePointValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public RatioTapChangerTablePointValidator getInstance() {
		return new RatioTapChangerTablePointValidator();
	}
		
	/**
	 * handles creation validation for a RatioTapChangerTablePoint
	 */
	public void validate( CreateRatioTapChangerTablePointCommand ratioTapChangerTablePoint )throws Exception {
		Assert.notNull( ratioTapChangerTablePoint, "CreateRatioTapChangerTablePointCommand should not be null" );
//		Assert.isNull( ratioTapChangerTablePoint.getRatioTapChangerTablePointId(), "CreateRatioTapChangerTablePointCommand identifier should be null" );
	}

	/**
	 * handles update validation for a RatioTapChangerTablePoint
	 */
	public void validate( UpdateRatioTapChangerTablePointCommand ratioTapChangerTablePoint ) throws Exception {
		Assert.notNull( ratioTapChangerTablePoint, "UpdateRatioTapChangerTablePointCommand should not be null" );
		Assert.notNull( ratioTapChangerTablePoint.getRatioTapChangerTablePointId(), "UpdateRatioTapChangerTablePointCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a RatioTapChangerTablePoint
	 */
    public void validate( DeleteRatioTapChangerTablePointCommand ratioTapChangerTablePoint ) throws Exception {
		Assert.notNull( ratioTapChangerTablePoint, "{commandAlias} should not be null" );
		Assert.notNull( ratioTapChangerTablePoint.getRatioTapChangerTablePointId(), "DeleteRatioTapChangerTablePointCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a RatioTapChangerTablePoint
	 */
	public void validate( RatioTapChangerTablePointFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "RatioTapChangerTablePointFetchOneSummary should not be null" );
		Assert.notNull( summary.getRatioTapChangerTablePointId(), "RatioTapChangerTablePointFetchOneSummary identifier should not be null" );
	}



}
