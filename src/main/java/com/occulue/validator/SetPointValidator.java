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

public class SetPointValidator {
		
	/**
	 * default constructor
	 */
	protected SetPointValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public SetPointValidator getInstance() {
		return new SetPointValidator();
	}
		
	/**
	 * handles creation validation for a SetPoint
	 */
	public void validate( CreateSetPointCommand setPoint )throws Exception {
		Assert.notNull( setPoint, "CreateSetPointCommand should not be null" );
//		Assert.isNull( setPoint.getSetPointId(), "CreateSetPointCommand identifier should be null" );
	}

	/**
	 * handles update validation for a SetPoint
	 */
	public void validate( UpdateSetPointCommand setPoint ) throws Exception {
		Assert.notNull( setPoint, "UpdateSetPointCommand should not be null" );
		Assert.notNull( setPoint.getSetPointId(), "UpdateSetPointCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a SetPoint
	 */
    public void validate( DeleteSetPointCommand setPoint ) throws Exception {
		Assert.notNull( setPoint, "{commandAlias} should not be null" );
		Assert.notNull( setPoint.getSetPointId(), "DeleteSetPointCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a SetPoint
	 */
	public void validate( SetPointFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "SetPointFetchOneSummary should not be null" );
		Assert.notNull( summary.getSetPointId(), "SetPointFetchOneSummary identifier should not be null" );
	}



}
