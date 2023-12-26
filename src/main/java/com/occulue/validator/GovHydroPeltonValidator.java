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

public class GovHydroPeltonValidator {
		
	/**
	 * default constructor
	 */
	protected GovHydroPeltonValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public GovHydroPeltonValidator getInstance() {
		return new GovHydroPeltonValidator();
	}
		
	/**
	 * handles creation validation for a GovHydroPelton
	 */
	public void validate( CreateGovHydroPeltonCommand govHydroPelton )throws Exception {
		Assert.notNull( govHydroPelton, "CreateGovHydroPeltonCommand should not be null" );
//		Assert.isNull( govHydroPelton.getGovHydroPeltonId(), "CreateGovHydroPeltonCommand identifier should be null" );
	}

	/**
	 * handles update validation for a GovHydroPelton
	 */
	public void validate( UpdateGovHydroPeltonCommand govHydroPelton ) throws Exception {
		Assert.notNull( govHydroPelton, "UpdateGovHydroPeltonCommand should not be null" );
		Assert.notNull( govHydroPelton.getGovHydroPeltonId(), "UpdateGovHydroPeltonCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a GovHydroPelton
	 */
    public void validate( DeleteGovHydroPeltonCommand govHydroPelton ) throws Exception {
		Assert.notNull( govHydroPelton, "{commandAlias} should not be null" );
		Assert.notNull( govHydroPelton.getGovHydroPeltonId(), "DeleteGovHydroPeltonCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a GovHydroPelton
	 */
	public void validate( GovHydroPeltonFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GovHydroPeltonFetchOneSummary should not be null" );
		Assert.notNull( summary.getGovHydroPeltonId(), "GovHydroPeltonFetchOneSummary identifier should not be null" );
	}



}
