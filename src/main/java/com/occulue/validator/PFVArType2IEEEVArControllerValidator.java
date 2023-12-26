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

public class PFVArType2IEEEVArControllerValidator {
		
	/**
	 * default constructor
	 */
	protected PFVArType2IEEEVArControllerValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public PFVArType2IEEEVArControllerValidator getInstance() {
		return new PFVArType2IEEEVArControllerValidator();
	}
		
	/**
	 * handles creation validation for a PFVArType2IEEEVArController
	 */
	public void validate( CreatePFVArType2IEEEVArControllerCommand pFVArType2IEEEVArController )throws Exception {
		Assert.notNull( pFVArType2IEEEVArController, "CreatePFVArType2IEEEVArControllerCommand should not be null" );
//		Assert.isNull( pFVArType2IEEEVArController.getPFVArType2IEEEVArControllerId(), "CreatePFVArType2IEEEVArControllerCommand identifier should be null" );
	}

	/**
	 * handles update validation for a PFVArType2IEEEVArController
	 */
	public void validate( UpdatePFVArType2IEEEVArControllerCommand pFVArType2IEEEVArController ) throws Exception {
		Assert.notNull( pFVArType2IEEEVArController, "UpdatePFVArType2IEEEVArControllerCommand should not be null" );
		Assert.notNull( pFVArType2IEEEVArController.getPFVArType2IEEEVArControllerId(), "UpdatePFVArType2IEEEVArControllerCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a PFVArType2IEEEVArController
	 */
    public void validate( DeletePFVArType2IEEEVArControllerCommand pFVArType2IEEEVArController ) throws Exception {
		Assert.notNull( pFVArType2IEEEVArController, "{commandAlias} should not be null" );
		Assert.notNull( pFVArType2IEEEVArController.getPFVArType2IEEEVArControllerId(), "DeletePFVArType2IEEEVArControllerCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a PFVArType2IEEEVArController
	 */
	public void validate( PFVArType2IEEEVArControllerFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "PFVArType2IEEEVArControllerFetchOneSummary should not be null" );
		Assert.notNull( summary.getPFVArType2IEEEVArControllerId(), "PFVArType2IEEEVArControllerFetchOneSummary identifier should not be null" );
	}



}
