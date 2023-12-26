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

public class SvInjectionValidator {
		
	/**
	 * default constructor
	 */
	protected SvInjectionValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public SvInjectionValidator getInstance() {
		return new SvInjectionValidator();
	}
		
	/**
	 * handles creation validation for a SvInjection
	 */
	public void validate( CreateSvInjectionCommand svInjection )throws Exception {
		Assert.notNull( svInjection, "CreateSvInjectionCommand should not be null" );
//		Assert.isNull( svInjection.getSvInjectionId(), "CreateSvInjectionCommand identifier should be null" );
	}

	/**
	 * handles update validation for a SvInjection
	 */
	public void validate( UpdateSvInjectionCommand svInjection ) throws Exception {
		Assert.notNull( svInjection, "UpdateSvInjectionCommand should not be null" );
		Assert.notNull( svInjection.getSvInjectionId(), "UpdateSvInjectionCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a SvInjection
	 */
    public void validate( DeleteSvInjectionCommand svInjection ) throws Exception {
		Assert.notNull( svInjection, "{commandAlias} should not be null" );
		Assert.notNull( svInjection.getSvInjectionId(), "DeleteSvInjectionCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a SvInjection
	 */
	public void validate( SvInjectionFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "SvInjectionFetchOneSummary should not be null" );
		Assert.notNull( summary.getSvInjectionId(), "SvInjectionFetchOneSummary identifier should not be null" );
	}



}
