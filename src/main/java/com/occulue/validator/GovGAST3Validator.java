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

public class GovGAST3Validator {
		
	/**
	 * default constructor
	 */
	protected GovGAST3Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public GovGAST3Validator getInstance() {
		return new GovGAST3Validator();
	}
		
	/**
	 * handles creation validation for a GovGAST3
	 */
	public void validate( CreateGovGAST3Command govGAST3 )throws Exception {
		Assert.notNull( govGAST3, "CreateGovGAST3Command should not be null" );
//		Assert.isNull( govGAST3.getGovGAST3Id(), "CreateGovGAST3Command identifier should be null" );
	}

	/**
	 * handles update validation for a GovGAST3
	 */
	public void validate( UpdateGovGAST3Command govGAST3 ) throws Exception {
		Assert.notNull( govGAST3, "UpdateGovGAST3Command should not be null" );
		Assert.notNull( govGAST3.getGovGAST3Id(), "UpdateGovGAST3Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a GovGAST3
	 */
    public void validate( DeleteGovGAST3Command govGAST3 ) throws Exception {
		Assert.notNull( govGAST3, "{commandAlias} should not be null" );
		Assert.notNull( govGAST3.getGovGAST3Id(), "DeleteGovGAST3Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a GovGAST3
	 */
	public void validate( GovGAST3FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GovGAST3FetchOneSummary should not be null" );
		Assert.notNull( summary.getGovGAST3Id(), "GovGAST3FetchOneSummary identifier should not be null" );
	}



}
