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

public class ACLineSegmentValidator {
		
	/**
	 * default constructor
	 */
	protected ACLineSegmentValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ACLineSegmentValidator getInstance() {
		return new ACLineSegmentValidator();
	}
		
	/**
	 * handles creation validation for a ACLineSegment
	 */
	public void validate( CreateACLineSegmentCommand aCLineSegment )throws Exception {
		Assert.notNull( aCLineSegment, "CreateACLineSegmentCommand should not be null" );
//		Assert.isNull( aCLineSegment.getACLineSegmentId(), "CreateACLineSegmentCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ACLineSegment
	 */
	public void validate( UpdateACLineSegmentCommand aCLineSegment ) throws Exception {
		Assert.notNull( aCLineSegment, "UpdateACLineSegmentCommand should not be null" );
		Assert.notNull( aCLineSegment.getACLineSegmentId(), "UpdateACLineSegmentCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ACLineSegment
	 */
    public void validate( DeleteACLineSegmentCommand aCLineSegment ) throws Exception {
		Assert.notNull( aCLineSegment, "{commandAlias} should not be null" );
		Assert.notNull( aCLineSegment.getACLineSegmentId(), "DeleteACLineSegmentCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ACLineSegment
	 */
	public void validate( ACLineSegmentFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ACLineSegmentFetchOneSummary should not be null" );
		Assert.notNull( summary.getACLineSegmentId(), "ACLineSegmentFetchOneSummary identifier should not be null" );
	}



}
