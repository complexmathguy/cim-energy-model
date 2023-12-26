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

public class RegularTimePointValidator {
		
	/**
	 * default constructor
	 */
	protected RegularTimePointValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public RegularTimePointValidator getInstance() {
		return new RegularTimePointValidator();
	}
		
	/**
	 * handles creation validation for a RegularTimePoint
	 */
	public void validate( CreateRegularTimePointCommand regularTimePoint )throws Exception {
		Assert.notNull( regularTimePoint, "CreateRegularTimePointCommand should not be null" );
//		Assert.isNull( regularTimePoint.getRegularTimePointId(), "CreateRegularTimePointCommand identifier should be null" );
	}

	/**
	 * handles update validation for a RegularTimePoint
	 */
	public void validate( UpdateRegularTimePointCommand regularTimePoint ) throws Exception {
		Assert.notNull( regularTimePoint, "UpdateRegularTimePointCommand should not be null" );
		Assert.notNull( regularTimePoint.getRegularTimePointId(), "UpdateRegularTimePointCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a RegularTimePoint
	 */
    public void validate( DeleteRegularTimePointCommand regularTimePoint ) throws Exception {
		Assert.notNull( regularTimePoint, "{commandAlias} should not be null" );
		Assert.notNull( regularTimePoint.getRegularTimePointId(), "DeleteRegularTimePointCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a RegularTimePoint
	 */
	public void validate( RegularTimePointFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "RegularTimePointFetchOneSummary should not be null" );
		Assert.notNull( summary.getRegularTimePointId(), "RegularTimePointFetchOneSummary identifier should not be null" );
	}



}
