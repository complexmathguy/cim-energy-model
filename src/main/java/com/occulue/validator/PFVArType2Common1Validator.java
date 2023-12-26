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

public class PFVArType2Common1Validator {
		
	/**
	 * default constructor
	 */
	protected PFVArType2Common1Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public PFVArType2Common1Validator getInstance() {
		return new PFVArType2Common1Validator();
	}
		
	/**
	 * handles creation validation for a PFVArType2Common1
	 */
	public void validate( CreatePFVArType2Common1Command pFVArType2Common1 )throws Exception {
		Assert.notNull( pFVArType2Common1, "CreatePFVArType2Common1Command should not be null" );
//		Assert.isNull( pFVArType2Common1.getPFVArType2Common1Id(), "CreatePFVArType2Common1Command identifier should be null" );
	}

	/**
	 * handles update validation for a PFVArType2Common1
	 */
	public void validate( UpdatePFVArType2Common1Command pFVArType2Common1 ) throws Exception {
		Assert.notNull( pFVArType2Common1, "UpdatePFVArType2Common1Command should not be null" );
		Assert.notNull( pFVArType2Common1.getPFVArType2Common1Id(), "UpdatePFVArType2Common1Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a PFVArType2Common1
	 */
    public void validate( DeletePFVArType2Common1Command pFVArType2Common1 ) throws Exception {
		Assert.notNull( pFVArType2Common1, "{commandAlias} should not be null" );
		Assert.notNull( pFVArType2Common1.getPFVArType2Common1Id(), "DeletePFVArType2Common1Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a PFVArType2Common1
	 */
	public void validate( PFVArType2Common1FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "PFVArType2Common1FetchOneSummary should not be null" );
		Assert.notNull( summary.getPFVArType2Common1Id(), "PFVArType2Common1FetchOneSummary identifier should not be null" );
	}



}
