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

public class ConformLoadValidator {
		
	/**
	 * default constructor
	 */
	protected ConformLoadValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ConformLoadValidator getInstance() {
		return new ConformLoadValidator();
	}
		
	/**
	 * handles creation validation for a ConformLoad
	 */
	public void validate( CreateConformLoadCommand conformLoad )throws Exception {
		Assert.notNull( conformLoad, "CreateConformLoadCommand should not be null" );
//		Assert.isNull( conformLoad.getConformLoadId(), "CreateConformLoadCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ConformLoad
	 */
	public void validate( UpdateConformLoadCommand conformLoad ) throws Exception {
		Assert.notNull( conformLoad, "UpdateConformLoadCommand should not be null" );
		Assert.notNull( conformLoad.getConformLoadId(), "UpdateConformLoadCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ConformLoad
	 */
    public void validate( DeleteConformLoadCommand conformLoad ) throws Exception {
		Assert.notNull( conformLoad, "{commandAlias} should not be null" );
		Assert.notNull( conformLoad.getConformLoadId(), "DeleteConformLoadCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ConformLoad
	 */
	public void validate( ConformLoadFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ConformLoadFetchOneSummary should not be null" );
		Assert.notNull( summary.getConformLoadId(), "ConformLoadFetchOneSummary identifier should not be null" );
	}



}
