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

public class DCLineSegmentValidator {
		
	/**
	 * default constructor
	 */
	protected DCLineSegmentValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public DCLineSegmentValidator getInstance() {
		return new DCLineSegmentValidator();
	}
		
	/**
	 * handles creation validation for a DCLineSegment
	 */
	public void validate( CreateDCLineSegmentCommand dCLineSegment )throws Exception {
		Assert.notNull( dCLineSegment, "CreateDCLineSegmentCommand should not be null" );
//		Assert.isNull( dCLineSegment.getDCLineSegmentId(), "CreateDCLineSegmentCommand identifier should be null" );
	}

	/**
	 * handles update validation for a DCLineSegment
	 */
	public void validate( UpdateDCLineSegmentCommand dCLineSegment ) throws Exception {
		Assert.notNull( dCLineSegment, "UpdateDCLineSegmentCommand should not be null" );
		Assert.notNull( dCLineSegment.getDCLineSegmentId(), "UpdateDCLineSegmentCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a DCLineSegment
	 */
    public void validate( DeleteDCLineSegmentCommand dCLineSegment ) throws Exception {
		Assert.notNull( dCLineSegment, "{commandAlias} should not be null" );
		Assert.notNull( dCLineSegment.getDCLineSegmentId(), "DeleteDCLineSegmentCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a DCLineSegment
	 */
	public void validate( DCLineSegmentFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "DCLineSegmentFetchOneSummary should not be null" );
		Assert.notNull( summary.getDCLineSegmentId(), "DCLineSegmentFetchOneSummary identifier should not be null" );
	}



}
