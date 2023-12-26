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

public class GovGAST1Validator {
		
	/**
	 * default constructor
	 */
	protected GovGAST1Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public GovGAST1Validator getInstance() {
		return new GovGAST1Validator();
	}
		
	/**
	 * handles creation validation for a GovGAST1
	 */
	public void validate( CreateGovGAST1Command govGAST1 )throws Exception {
		Assert.notNull( govGAST1, "CreateGovGAST1Command should not be null" );
//		Assert.isNull( govGAST1.getGovGAST1Id(), "CreateGovGAST1Command identifier should be null" );
	}

	/**
	 * handles update validation for a GovGAST1
	 */
	public void validate( UpdateGovGAST1Command govGAST1 ) throws Exception {
		Assert.notNull( govGAST1, "UpdateGovGAST1Command should not be null" );
		Assert.notNull( govGAST1.getGovGAST1Id(), "UpdateGovGAST1Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a GovGAST1
	 */
    public void validate( DeleteGovGAST1Command govGAST1 ) throws Exception {
		Assert.notNull( govGAST1, "{commandAlias} should not be null" );
		Assert.notNull( govGAST1.getGovGAST1Id(), "DeleteGovGAST1Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a GovGAST1
	 */
	public void validate( GovGAST1FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GovGAST1FetchOneSummary should not be null" );
		Assert.notNull( summary.getGovGAST1Id(), "GovGAST1FetchOneSummary identifier should not be null" );
	}



}
