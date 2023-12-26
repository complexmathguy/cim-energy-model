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

public class DynamicsFunctionBlockValidator {
		
	/**
	 * default constructor
	 */
	protected DynamicsFunctionBlockValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public DynamicsFunctionBlockValidator getInstance() {
		return new DynamicsFunctionBlockValidator();
	}
		
	/**
	 * handles creation validation for a DynamicsFunctionBlock
	 */
	public void validate( CreateDynamicsFunctionBlockCommand dynamicsFunctionBlock )throws Exception {
		Assert.notNull( dynamicsFunctionBlock, "CreateDynamicsFunctionBlockCommand should not be null" );
//		Assert.isNull( dynamicsFunctionBlock.getDynamicsFunctionBlockId(), "CreateDynamicsFunctionBlockCommand identifier should be null" );
	}

	/**
	 * handles update validation for a DynamicsFunctionBlock
	 */
	public void validate( UpdateDynamicsFunctionBlockCommand dynamicsFunctionBlock ) throws Exception {
		Assert.notNull( dynamicsFunctionBlock, "UpdateDynamicsFunctionBlockCommand should not be null" );
		Assert.notNull( dynamicsFunctionBlock.getDynamicsFunctionBlockId(), "UpdateDynamicsFunctionBlockCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a DynamicsFunctionBlock
	 */
    public void validate( DeleteDynamicsFunctionBlockCommand dynamicsFunctionBlock ) throws Exception {
		Assert.notNull( dynamicsFunctionBlock, "{commandAlias} should not be null" );
		Assert.notNull( dynamicsFunctionBlock.getDynamicsFunctionBlockId(), "DeleteDynamicsFunctionBlockCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a DynamicsFunctionBlock
	 */
	public void validate( DynamicsFunctionBlockFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "DynamicsFunctionBlockFetchOneSummary should not be null" );
		Assert.notNull( summary.getDynamicsFunctionBlockId(), "DynamicsFunctionBlockFetchOneSummary identifier should not be null" );
	}



}
