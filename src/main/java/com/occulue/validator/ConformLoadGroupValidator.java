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

public class ConformLoadGroupValidator {
		
	/**
	 * default constructor
	 */
	protected ConformLoadGroupValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ConformLoadGroupValidator getInstance() {
		return new ConformLoadGroupValidator();
	}
		
	/**
	 * handles creation validation for a ConformLoadGroup
	 */
	public void validate( CreateConformLoadGroupCommand conformLoadGroup )throws Exception {
		Assert.notNull( conformLoadGroup, "CreateConformLoadGroupCommand should not be null" );
//		Assert.isNull( conformLoadGroup.getConformLoadGroupId(), "CreateConformLoadGroupCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ConformLoadGroup
	 */
	public void validate( UpdateConformLoadGroupCommand conformLoadGroup ) throws Exception {
		Assert.notNull( conformLoadGroup, "UpdateConformLoadGroupCommand should not be null" );
		Assert.notNull( conformLoadGroup.getConformLoadGroupId(), "UpdateConformLoadGroupCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ConformLoadGroup
	 */
    public void validate( DeleteConformLoadGroupCommand conformLoadGroup ) throws Exception {
		Assert.notNull( conformLoadGroup, "{commandAlias} should not be null" );
		Assert.notNull( conformLoadGroup.getConformLoadGroupId(), "DeleteConformLoadGroupCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ConformLoadGroup
	 */
	public void validate( ConformLoadGroupFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ConformLoadGroupFetchOneSummary should not be null" );
		Assert.notNull( summary.getConformLoadGroupId(), "ConformLoadGroupFetchOneSummary identifier should not be null" );
	}



}
