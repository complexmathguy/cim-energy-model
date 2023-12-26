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

public class PssSHValidator {
		
	/**
	 * default constructor
	 */
	protected PssSHValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public PssSHValidator getInstance() {
		return new PssSHValidator();
	}
		
	/**
	 * handles creation validation for a PssSH
	 */
	public void validate( CreatePssSHCommand pssSH )throws Exception {
		Assert.notNull( pssSH, "CreatePssSHCommand should not be null" );
//		Assert.isNull( pssSH.getPssSHId(), "CreatePssSHCommand identifier should be null" );
	}

	/**
	 * handles update validation for a PssSH
	 */
	public void validate( UpdatePssSHCommand pssSH ) throws Exception {
		Assert.notNull( pssSH, "UpdatePssSHCommand should not be null" );
		Assert.notNull( pssSH.getPssSHId(), "UpdatePssSHCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a PssSH
	 */
    public void validate( DeletePssSHCommand pssSH ) throws Exception {
		Assert.notNull( pssSH, "{commandAlias} should not be null" );
		Assert.notNull( pssSH.getPssSHId(), "DeletePssSHCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a PssSH
	 */
	public void validate( PssSHFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "PssSHFetchOneSummary should not be null" );
		Assert.notNull( summary.getPssSHId(), "PssSHFetchOneSummary identifier should not be null" );
	}



}
