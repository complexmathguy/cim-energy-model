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

public class Quality61850Validator {
		
	/**
	 * default constructor
	 */
	protected Quality61850Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public Quality61850Validator getInstance() {
		return new Quality61850Validator();
	}
		
	/**
	 * handles creation validation for a Quality61850
	 */
	public void validate( CreateQuality61850Command quality61850 )throws Exception {
		Assert.notNull( quality61850, "CreateQuality61850Command should not be null" );
//		Assert.isNull( quality61850.getQuality61850Id(), "CreateQuality61850Command identifier should be null" );
	}

	/**
	 * handles update validation for a Quality61850
	 */
	public void validate( UpdateQuality61850Command quality61850 ) throws Exception {
		Assert.notNull( quality61850, "UpdateQuality61850Command should not be null" );
		Assert.notNull( quality61850.getQuality61850Id(), "UpdateQuality61850Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a Quality61850
	 */
    public void validate( DeleteQuality61850Command quality61850 ) throws Exception {
		Assert.notNull( quality61850, "{commandAlias} should not be null" );
		Assert.notNull( quality61850.getQuality61850Id(), "DeleteQuality61850Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a Quality61850
	 */
	public void validate( Quality61850FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "Quality61850FetchOneSummary should not be null" );
		Assert.notNull( summary.getQuality61850Id(), "Quality61850FetchOneSummary identifier should not be null" );
	}



}
