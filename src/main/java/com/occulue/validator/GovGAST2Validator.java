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

public class GovGAST2Validator {
		
	/**
	 * default constructor
	 */
	protected GovGAST2Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public GovGAST2Validator getInstance() {
		return new GovGAST2Validator();
	}
		
	/**
	 * handles creation validation for a GovGAST2
	 */
	public void validate( CreateGovGAST2Command govGAST2 )throws Exception {
		Assert.notNull( govGAST2, "CreateGovGAST2Command should not be null" );
//		Assert.isNull( govGAST2.getGovGAST2Id(), "CreateGovGAST2Command identifier should be null" );
	}

	/**
	 * handles update validation for a GovGAST2
	 */
	public void validate( UpdateGovGAST2Command govGAST2 ) throws Exception {
		Assert.notNull( govGAST2, "UpdateGovGAST2Command should not be null" );
		Assert.notNull( govGAST2.getGovGAST2Id(), "UpdateGovGAST2Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a GovGAST2
	 */
    public void validate( DeleteGovGAST2Command govGAST2 ) throws Exception {
		Assert.notNull( govGAST2, "{commandAlias} should not be null" );
		Assert.notNull( govGAST2.getGovGAST2Id(), "DeleteGovGAST2Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a GovGAST2
	 */
	public void validate( GovGAST2FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GovGAST2FetchOneSummary should not be null" );
		Assert.notNull( summary.getGovGAST2Id(), "GovGAST2FetchOneSummary identifier should not be null" );
	}



}
