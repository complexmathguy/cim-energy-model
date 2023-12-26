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

public class PetersenCoilValidator {
		
	/**
	 * default constructor
	 */
	protected PetersenCoilValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public PetersenCoilValidator getInstance() {
		return new PetersenCoilValidator();
	}
		
	/**
	 * handles creation validation for a PetersenCoil
	 */
	public void validate( CreatePetersenCoilCommand petersenCoil )throws Exception {
		Assert.notNull( petersenCoil, "CreatePetersenCoilCommand should not be null" );
//		Assert.isNull( petersenCoil.getPetersenCoilId(), "CreatePetersenCoilCommand identifier should be null" );
	}

	/**
	 * handles update validation for a PetersenCoil
	 */
	public void validate( UpdatePetersenCoilCommand petersenCoil ) throws Exception {
		Assert.notNull( petersenCoil, "UpdatePetersenCoilCommand should not be null" );
		Assert.notNull( petersenCoil.getPetersenCoilId(), "UpdatePetersenCoilCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a PetersenCoil
	 */
    public void validate( DeletePetersenCoilCommand petersenCoil ) throws Exception {
		Assert.notNull( petersenCoil, "{commandAlias} should not be null" );
		Assert.notNull( petersenCoil.getPetersenCoilId(), "DeletePetersenCoilCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a PetersenCoil
	 */
	public void validate( PetersenCoilFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "PetersenCoilFetchOneSummary should not be null" );
		Assert.notNull( summary.getPetersenCoilId(), "PetersenCoilFetchOneSummary identifier should not be null" );
	}



}
