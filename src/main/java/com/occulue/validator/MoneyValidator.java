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

public class MoneyValidator {
		
	/**
	 * default constructor
	 */
	protected MoneyValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public MoneyValidator getInstance() {
		return new MoneyValidator();
	}
		
	/**
	 * handles creation validation for a Money
	 */
	public void validate( CreateMoneyCommand money )throws Exception {
		Assert.notNull( money, "CreateMoneyCommand should not be null" );
//		Assert.isNull( money.getMoneyId(), "CreateMoneyCommand identifier should be null" );
	}

	/**
	 * handles update validation for a Money
	 */
	public void validate( UpdateMoneyCommand money ) throws Exception {
		Assert.notNull( money, "UpdateMoneyCommand should not be null" );
		Assert.notNull( money.getMoneyId(), "UpdateMoneyCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a Money
	 */
    public void validate( DeleteMoneyCommand money ) throws Exception {
		Assert.notNull( money, "{commandAlias} should not be null" );
		Assert.notNull( money.getMoneyId(), "DeleteMoneyCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a Money
	 */
	public void validate( MoneyFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "MoneyFetchOneSummary should not be null" );
		Assert.notNull( summary.getMoneyId(), "MoneyFetchOneSummary identifier should not be null" );
	}



}
