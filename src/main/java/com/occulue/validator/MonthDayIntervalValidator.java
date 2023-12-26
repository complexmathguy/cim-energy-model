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

public class MonthDayIntervalValidator {
		
	/**
	 * default constructor
	 */
	protected MonthDayIntervalValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public MonthDayIntervalValidator getInstance() {
		return new MonthDayIntervalValidator();
	}
		
	/**
	 * handles creation validation for a MonthDayInterval
	 */
	public void validate( CreateMonthDayIntervalCommand monthDayInterval )throws Exception {
		Assert.notNull( monthDayInterval, "CreateMonthDayIntervalCommand should not be null" );
//		Assert.isNull( monthDayInterval.getMonthDayIntervalId(), "CreateMonthDayIntervalCommand identifier should be null" );
	}

	/**
	 * handles update validation for a MonthDayInterval
	 */
	public void validate( UpdateMonthDayIntervalCommand monthDayInterval ) throws Exception {
		Assert.notNull( monthDayInterval, "UpdateMonthDayIntervalCommand should not be null" );
		Assert.notNull( monthDayInterval.getMonthDayIntervalId(), "UpdateMonthDayIntervalCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a MonthDayInterval
	 */
    public void validate( DeleteMonthDayIntervalCommand monthDayInterval ) throws Exception {
		Assert.notNull( monthDayInterval, "{commandAlias} should not be null" );
		Assert.notNull( monthDayInterval.getMonthDayIntervalId(), "DeleteMonthDayIntervalCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a MonthDayInterval
	 */
	public void validate( MonthDayIntervalFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "MonthDayIntervalFetchOneSummary should not be null" );
		Assert.notNull( summary.getMonthDayIntervalId(), "MonthDayIntervalFetchOneSummary identifier should not be null" );
	}



}
