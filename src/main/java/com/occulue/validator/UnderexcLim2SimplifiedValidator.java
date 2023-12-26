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

public class UnderexcLim2SimplifiedValidator {
		
	/**
	 * default constructor
	 */
	protected UnderexcLim2SimplifiedValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public UnderexcLim2SimplifiedValidator getInstance() {
		return new UnderexcLim2SimplifiedValidator();
	}
		
	/**
	 * handles creation validation for a UnderexcLim2Simplified
	 */
	public void validate( CreateUnderexcLim2SimplifiedCommand underexcLim2Simplified )throws Exception {
		Assert.notNull( underexcLim2Simplified, "CreateUnderexcLim2SimplifiedCommand should not be null" );
//		Assert.isNull( underexcLim2Simplified.getUnderexcLim2SimplifiedId(), "CreateUnderexcLim2SimplifiedCommand identifier should be null" );
	}

	/**
	 * handles update validation for a UnderexcLim2Simplified
	 */
	public void validate( UpdateUnderexcLim2SimplifiedCommand underexcLim2Simplified ) throws Exception {
		Assert.notNull( underexcLim2Simplified, "UpdateUnderexcLim2SimplifiedCommand should not be null" );
		Assert.notNull( underexcLim2Simplified.getUnderexcLim2SimplifiedId(), "UpdateUnderexcLim2SimplifiedCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a UnderexcLim2Simplified
	 */
    public void validate( DeleteUnderexcLim2SimplifiedCommand underexcLim2Simplified ) throws Exception {
		Assert.notNull( underexcLim2Simplified, "{commandAlias} should not be null" );
		Assert.notNull( underexcLim2Simplified.getUnderexcLim2SimplifiedId(), "DeleteUnderexcLim2SimplifiedCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a UnderexcLim2Simplified
	 */
	public void validate( UnderexcLim2SimplifiedFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "UnderexcLim2SimplifiedFetchOneSummary should not be null" );
		Assert.notNull( summary.getUnderexcLim2SimplifiedId(), "UnderexcLim2SimplifiedFetchOneSummary identifier should not be null" );
	}



}
