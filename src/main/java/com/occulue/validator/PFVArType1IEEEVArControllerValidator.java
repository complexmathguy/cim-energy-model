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

public class PFVArType1IEEEVArControllerValidator {
		
	/**
	 * default constructor
	 */
	protected PFVArType1IEEEVArControllerValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public PFVArType1IEEEVArControllerValidator getInstance() {
		return new PFVArType1IEEEVArControllerValidator();
	}
		
	/**
	 * handles creation validation for a PFVArType1IEEEVArController
	 */
	public void validate( CreatePFVArType1IEEEVArControllerCommand pFVArType1IEEEVArController )throws Exception {
		Assert.notNull( pFVArType1IEEEVArController, "CreatePFVArType1IEEEVArControllerCommand should not be null" );
//		Assert.isNull( pFVArType1IEEEVArController.getPFVArType1IEEEVArControllerId(), "CreatePFVArType1IEEEVArControllerCommand identifier should be null" );
	}

	/**
	 * handles update validation for a PFVArType1IEEEVArController
	 */
	public void validate( UpdatePFVArType1IEEEVArControllerCommand pFVArType1IEEEVArController ) throws Exception {
		Assert.notNull( pFVArType1IEEEVArController, "UpdatePFVArType1IEEEVArControllerCommand should not be null" );
		Assert.notNull( pFVArType1IEEEVArController.getPFVArType1IEEEVArControllerId(), "UpdatePFVArType1IEEEVArControllerCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a PFVArType1IEEEVArController
	 */
    public void validate( DeletePFVArType1IEEEVArControllerCommand pFVArType1IEEEVArController ) throws Exception {
		Assert.notNull( pFVArType1IEEEVArController, "{commandAlias} should not be null" );
		Assert.notNull( pFVArType1IEEEVArController.getPFVArType1IEEEVArControllerId(), "DeletePFVArType1IEEEVArControllerCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a PFVArType1IEEEVArController
	 */
	public void validate( PFVArType1IEEEVArControllerFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "PFVArType1IEEEVArControllerFetchOneSummary should not be null" );
		Assert.notNull( summary.getPFVArType1IEEEVArControllerId(), "PFVArType1IEEEVArControllerFetchOneSummary identifier should not be null" );
	}



}
