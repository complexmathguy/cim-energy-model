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

public class NonConformLoadGroupValidator {
		
	/**
	 * default constructor
	 */
	protected NonConformLoadGroupValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public NonConformLoadGroupValidator getInstance() {
		return new NonConformLoadGroupValidator();
	}
		
	/**
	 * handles creation validation for a NonConformLoadGroup
	 */
	public void validate( CreateNonConformLoadGroupCommand nonConformLoadGroup )throws Exception {
		Assert.notNull( nonConformLoadGroup, "CreateNonConformLoadGroupCommand should not be null" );
//		Assert.isNull( nonConformLoadGroup.getNonConformLoadGroupId(), "CreateNonConformLoadGroupCommand identifier should be null" );
	}

	/**
	 * handles update validation for a NonConformLoadGroup
	 */
	public void validate( UpdateNonConformLoadGroupCommand nonConformLoadGroup ) throws Exception {
		Assert.notNull( nonConformLoadGroup, "UpdateNonConformLoadGroupCommand should not be null" );
		Assert.notNull( nonConformLoadGroup.getNonConformLoadGroupId(), "UpdateNonConformLoadGroupCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a NonConformLoadGroup
	 */
    public void validate( DeleteNonConformLoadGroupCommand nonConformLoadGroup ) throws Exception {
		Assert.notNull( nonConformLoadGroup, "{commandAlias} should not be null" );
		Assert.notNull( nonConformLoadGroup.getNonConformLoadGroupId(), "DeleteNonConformLoadGroupCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a NonConformLoadGroup
	 */
	public void validate( NonConformLoadGroupFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "NonConformLoadGroupFetchOneSummary should not be null" );
		Assert.notNull( summary.getNonConformLoadGroupId(), "NonConformLoadGroupFetchOneSummary identifier should not be null" );
	}



}
