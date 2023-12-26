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

public class PssPTIST1Validator {
		
	/**
	 * default constructor
	 */
	protected PssPTIST1Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public PssPTIST1Validator getInstance() {
		return new PssPTIST1Validator();
	}
		
	/**
	 * handles creation validation for a PssPTIST1
	 */
	public void validate( CreatePssPTIST1Command pssPTIST1 )throws Exception {
		Assert.notNull( pssPTIST1, "CreatePssPTIST1Command should not be null" );
//		Assert.isNull( pssPTIST1.getPssPTIST1Id(), "CreatePssPTIST1Command identifier should be null" );
	}

	/**
	 * handles update validation for a PssPTIST1
	 */
	public void validate( UpdatePssPTIST1Command pssPTIST1 ) throws Exception {
		Assert.notNull( pssPTIST1, "UpdatePssPTIST1Command should not be null" );
		Assert.notNull( pssPTIST1.getPssPTIST1Id(), "UpdatePssPTIST1Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a PssPTIST1
	 */
    public void validate( DeletePssPTIST1Command pssPTIST1 ) throws Exception {
		Assert.notNull( pssPTIST1, "{commandAlias} should not be null" );
		Assert.notNull( pssPTIST1.getPssPTIST1Id(), "DeletePssPTIST1Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a PssPTIST1
	 */
	public void validate( PssPTIST1FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "PssPTIST1FetchOneSummary should not be null" );
		Assert.notNull( summary.getPssPTIST1Id(), "PssPTIST1FetchOneSummary identifier should not be null" );
	}



}
