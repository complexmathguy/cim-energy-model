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

public class PFVArType2IEEEPFControllerValidator {
		
	/**
	 * default constructor
	 */
	protected PFVArType2IEEEPFControllerValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public PFVArType2IEEEPFControllerValidator getInstance() {
		return new PFVArType2IEEEPFControllerValidator();
	}
		
	/**
	 * handles creation validation for a PFVArType2IEEEPFController
	 */
	public void validate( CreatePFVArType2IEEEPFControllerCommand pFVArType2IEEEPFController )throws Exception {
		Assert.notNull( pFVArType2IEEEPFController, "CreatePFVArType2IEEEPFControllerCommand should not be null" );
//		Assert.isNull( pFVArType2IEEEPFController.getPFVArType2IEEEPFControllerId(), "CreatePFVArType2IEEEPFControllerCommand identifier should be null" );
	}

	/**
	 * handles update validation for a PFVArType2IEEEPFController
	 */
	public void validate( UpdatePFVArType2IEEEPFControllerCommand pFVArType2IEEEPFController ) throws Exception {
		Assert.notNull( pFVArType2IEEEPFController, "UpdatePFVArType2IEEEPFControllerCommand should not be null" );
		Assert.notNull( pFVArType2IEEEPFController.getPFVArType2IEEEPFControllerId(), "UpdatePFVArType2IEEEPFControllerCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a PFVArType2IEEEPFController
	 */
    public void validate( DeletePFVArType2IEEEPFControllerCommand pFVArType2IEEEPFController ) throws Exception {
		Assert.notNull( pFVArType2IEEEPFController, "{commandAlias} should not be null" );
		Assert.notNull( pFVArType2IEEEPFController.getPFVArType2IEEEPFControllerId(), "DeletePFVArType2IEEEPFControllerCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a PFVArType2IEEEPFController
	 */
	public void validate( PFVArType2IEEEPFControllerFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "PFVArType2IEEEPFControllerFetchOneSummary should not be null" );
		Assert.notNull( summary.getPFVArType2IEEEPFControllerId(), "PFVArType2IEEEPFControllerFetchOneSummary identifier should not be null" );
	}



}
