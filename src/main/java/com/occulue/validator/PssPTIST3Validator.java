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

public class PssPTIST3Validator {
		
	/**
	 * default constructor
	 */
	protected PssPTIST3Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public PssPTIST3Validator getInstance() {
		return new PssPTIST3Validator();
	}
		
	/**
	 * handles creation validation for a PssPTIST3
	 */
	public void validate( CreatePssPTIST3Command pssPTIST3 )throws Exception {
		Assert.notNull( pssPTIST3, "CreatePssPTIST3Command should not be null" );
//		Assert.isNull( pssPTIST3.getPssPTIST3Id(), "CreatePssPTIST3Command identifier should be null" );
	}

	/**
	 * handles update validation for a PssPTIST3
	 */
	public void validate( UpdatePssPTIST3Command pssPTIST3 ) throws Exception {
		Assert.notNull( pssPTIST3, "UpdatePssPTIST3Command should not be null" );
		Assert.notNull( pssPTIST3.getPssPTIST3Id(), "UpdatePssPTIST3Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a PssPTIST3
	 */
    public void validate( DeletePssPTIST3Command pssPTIST3 ) throws Exception {
		Assert.notNull( pssPTIST3, "{commandAlias} should not be null" );
		Assert.notNull( pssPTIST3.getPssPTIST3Id(), "DeletePssPTIST3Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a PssPTIST3
	 */
	public void validate( PssPTIST3FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "PssPTIST3FetchOneSummary should not be null" );
		Assert.notNull( summary.getPssPTIST3Id(), "PssPTIST3FetchOneSummary identifier should not be null" );
	}



}
