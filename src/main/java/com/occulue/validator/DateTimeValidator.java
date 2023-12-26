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

public class DateTimeValidator {
		
	/**
	 * default constructor
	 */
	protected DateTimeValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public DateTimeValidator getInstance() {
		return new DateTimeValidator();
	}
		
	/**
	 * handles creation validation for a DateTime
	 */
	public void validate( CreateDateTimeCommand dateTime )throws Exception {
		Assert.notNull( dateTime, "CreateDateTimeCommand should not be null" );
//		Assert.isNull( dateTime.getDateTimeId(), "CreateDateTimeCommand identifier should be null" );
	}

	/**
	 * handles update validation for a DateTime
	 */
	public void validate( UpdateDateTimeCommand dateTime ) throws Exception {
		Assert.notNull( dateTime, "UpdateDateTimeCommand should not be null" );
		Assert.notNull( dateTime.getDateTimeId(), "UpdateDateTimeCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a DateTime
	 */
    public void validate( DeleteDateTimeCommand dateTime ) throws Exception {
		Assert.notNull( dateTime, "{commandAlias} should not be null" );
		Assert.notNull( dateTime.getDateTimeId(), "DeleteDateTimeCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a DateTime
	 */
	public void validate( DateTimeFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "DateTimeFetchOneSummary should not be null" );
		Assert.notNull( summary.getDateTimeId(), "DateTimeFetchOneSummary identifier should not be null" );
	}



}
