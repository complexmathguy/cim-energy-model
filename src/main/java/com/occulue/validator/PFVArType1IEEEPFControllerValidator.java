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

public class PFVArType1IEEEPFControllerValidator {
		
	/**
	 * default constructor
	 */
	protected PFVArType1IEEEPFControllerValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public PFVArType1IEEEPFControllerValidator getInstance() {
		return new PFVArType1IEEEPFControllerValidator();
	}
		
	/**
	 * handles creation validation for a PFVArType1IEEEPFController
	 */
	public void validate( CreatePFVArType1IEEEPFControllerCommand pFVArType1IEEEPFController )throws Exception {
		Assert.notNull( pFVArType1IEEEPFController, "CreatePFVArType1IEEEPFControllerCommand should not be null" );
//		Assert.isNull( pFVArType1IEEEPFController.getPFVArType1IEEEPFControllerId(), "CreatePFVArType1IEEEPFControllerCommand identifier should be null" );
	}

	/**
	 * handles update validation for a PFVArType1IEEEPFController
	 */
	public void validate( UpdatePFVArType1IEEEPFControllerCommand pFVArType1IEEEPFController ) throws Exception {
		Assert.notNull( pFVArType1IEEEPFController, "UpdatePFVArType1IEEEPFControllerCommand should not be null" );
		Assert.notNull( pFVArType1IEEEPFController.getPFVArType1IEEEPFControllerId(), "UpdatePFVArType1IEEEPFControllerCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a PFVArType1IEEEPFController
	 */
    public void validate( DeletePFVArType1IEEEPFControllerCommand pFVArType1IEEEPFController ) throws Exception {
		Assert.notNull( pFVArType1IEEEPFController, "{commandAlias} should not be null" );
		Assert.notNull( pFVArType1IEEEPFController.getPFVArType1IEEEPFControllerId(), "DeletePFVArType1IEEEPFControllerCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a PFVArType1IEEEPFController
	 */
	public void validate( PFVArType1IEEEPFControllerFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "PFVArType1IEEEPFControllerFetchOneSummary should not be null" );
		Assert.notNull( summary.getPFVArType1IEEEPFControllerId(), "PFVArType1IEEEPFControllerFetchOneSummary identifier should not be null" );
	}



}
