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

public class AngleDegreesValidator {
		
	/**
	 * default constructor
	 */
	protected AngleDegreesValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public AngleDegreesValidator getInstance() {
		return new AngleDegreesValidator();
	}
		
	/**
	 * handles creation validation for a AngleDegrees
	 */
	public void validate( CreateAngleDegreesCommand angleDegrees )throws Exception {
		Assert.notNull( angleDegrees, "CreateAngleDegreesCommand should not be null" );
//		Assert.isNull( angleDegrees.getAngleDegreesId(), "CreateAngleDegreesCommand identifier should be null" );
	}

	/**
	 * handles update validation for a AngleDegrees
	 */
	public void validate( UpdateAngleDegreesCommand angleDegrees ) throws Exception {
		Assert.notNull( angleDegrees, "UpdateAngleDegreesCommand should not be null" );
		Assert.notNull( angleDegrees.getAngleDegreesId(), "UpdateAngleDegreesCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a AngleDegrees
	 */
    public void validate( DeleteAngleDegreesCommand angleDegrees ) throws Exception {
		Assert.notNull( angleDegrees, "{commandAlias} should not be null" );
		Assert.notNull( angleDegrees.getAngleDegreesId(), "DeleteAngleDegreesCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a AngleDegrees
	 */
	public void validate( AngleDegreesFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "AngleDegreesFetchOneSummary should not be null" );
		Assert.notNull( summary.getAngleDegreesId(), "AngleDegreesFetchOneSummary identifier should not be null" );
	}



}
