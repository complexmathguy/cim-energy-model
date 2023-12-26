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

public class GovGASTValidator {
		
	/**
	 * default constructor
	 */
	protected GovGASTValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public GovGASTValidator getInstance() {
		return new GovGASTValidator();
	}
		
	/**
	 * handles creation validation for a GovGAST
	 */
	public void validate( CreateGovGASTCommand govGAST )throws Exception {
		Assert.notNull( govGAST, "CreateGovGASTCommand should not be null" );
//		Assert.isNull( govGAST.getGovGASTId(), "CreateGovGASTCommand identifier should be null" );
	}

	/**
	 * handles update validation for a GovGAST
	 */
	public void validate( UpdateGovGASTCommand govGAST ) throws Exception {
		Assert.notNull( govGAST, "UpdateGovGASTCommand should not be null" );
		Assert.notNull( govGAST.getGovGASTId(), "UpdateGovGASTCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a GovGAST
	 */
    public void validate( DeleteGovGASTCommand govGAST ) throws Exception {
		Assert.notNull( govGAST, "{commandAlias} should not be null" );
		Assert.notNull( govGAST.getGovGASTId(), "DeleteGovGASTCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a GovGAST
	 */
	public void validate( GovGASTFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GovGASTFetchOneSummary should not be null" );
		Assert.notNull( summary.getGovGASTId(), "GovGASTFetchOneSummary identifier should not be null" );
	}



}
