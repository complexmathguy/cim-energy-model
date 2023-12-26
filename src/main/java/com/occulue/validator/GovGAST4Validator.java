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

public class GovGAST4Validator {
		
	/**
	 * default constructor
	 */
	protected GovGAST4Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public GovGAST4Validator getInstance() {
		return new GovGAST4Validator();
	}
		
	/**
	 * handles creation validation for a GovGAST4
	 */
	public void validate( CreateGovGAST4Command govGAST4 )throws Exception {
		Assert.notNull( govGAST4, "CreateGovGAST4Command should not be null" );
//		Assert.isNull( govGAST4.getGovGAST4Id(), "CreateGovGAST4Command identifier should be null" );
	}

	/**
	 * handles update validation for a GovGAST4
	 */
	public void validate( UpdateGovGAST4Command govGAST4 ) throws Exception {
		Assert.notNull( govGAST4, "UpdateGovGAST4Command should not be null" );
		Assert.notNull( govGAST4.getGovGAST4Id(), "UpdateGovGAST4Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a GovGAST4
	 */
    public void validate( DeleteGovGAST4Command govGAST4 ) throws Exception {
		Assert.notNull( govGAST4, "{commandAlias} should not be null" );
		Assert.notNull( govGAST4.getGovGAST4Id(), "DeleteGovGAST4Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a GovGAST4
	 */
	public void validate( GovGAST4FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GovGAST4FetchOneSummary should not be null" );
		Assert.notNull( summary.getGovGAST4Id(), "GovGAST4FetchOneSummary identifier should not be null" );
	}



}
