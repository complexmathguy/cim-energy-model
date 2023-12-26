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

public class LoadGroupValidator {
		
	/**
	 * default constructor
	 */
	protected LoadGroupValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public LoadGroupValidator getInstance() {
		return new LoadGroupValidator();
	}
		
	/**
	 * handles creation validation for a LoadGroup
	 */
	public void validate( CreateLoadGroupCommand loadGroup )throws Exception {
		Assert.notNull( loadGroup, "CreateLoadGroupCommand should not be null" );
//		Assert.isNull( loadGroup.getLoadGroupId(), "CreateLoadGroupCommand identifier should be null" );
	}

	/**
	 * handles update validation for a LoadGroup
	 */
	public void validate( UpdateLoadGroupCommand loadGroup ) throws Exception {
		Assert.notNull( loadGroup, "UpdateLoadGroupCommand should not be null" );
		Assert.notNull( loadGroup.getLoadGroupId(), "UpdateLoadGroupCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a LoadGroup
	 */
    public void validate( DeleteLoadGroupCommand loadGroup ) throws Exception {
		Assert.notNull( loadGroup, "{commandAlias} should not be null" );
		Assert.notNull( loadGroup.getLoadGroupId(), "DeleteLoadGroupCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a LoadGroup
	 */
	public void validate( LoadGroupFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "LoadGroupFetchOneSummary should not be null" );
		Assert.notNull( summary.getLoadGroupId(), "LoadGroupFetchOneSummary identifier should not be null" );
	}



}
