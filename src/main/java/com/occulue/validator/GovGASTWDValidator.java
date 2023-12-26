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

public class GovGASTWDValidator {
		
	/**
	 * default constructor
	 */
	protected GovGASTWDValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public GovGASTWDValidator getInstance() {
		return new GovGASTWDValidator();
	}
		
	/**
	 * handles creation validation for a GovGASTWD
	 */
	public void validate( CreateGovGASTWDCommand govGASTWD )throws Exception {
		Assert.notNull( govGASTWD, "CreateGovGASTWDCommand should not be null" );
//		Assert.isNull( govGASTWD.getGovGASTWDId(), "CreateGovGASTWDCommand identifier should be null" );
	}

	/**
	 * handles update validation for a GovGASTWD
	 */
	public void validate( UpdateGovGASTWDCommand govGASTWD ) throws Exception {
		Assert.notNull( govGASTWD, "UpdateGovGASTWDCommand should not be null" );
		Assert.notNull( govGASTWD.getGovGASTWDId(), "UpdateGovGASTWDCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a GovGASTWD
	 */
    public void validate( DeleteGovGASTWDCommand govGASTWD ) throws Exception {
		Assert.notNull( govGASTWD, "{commandAlias} should not be null" );
		Assert.notNull( govGASTWD.getGovGASTWDId(), "DeleteGovGASTWDCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a GovGASTWD
	 */
	public void validate( GovGASTWDFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GovGASTWDFetchOneSummary should not be null" );
		Assert.notNull( summary.getGovGASTWDId(), "GovGASTWDFetchOneSummary identifier should not be null" );
	}



}
