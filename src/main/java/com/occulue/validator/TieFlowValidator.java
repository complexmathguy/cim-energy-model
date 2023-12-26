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

public class TieFlowValidator {
		
	/**
	 * default constructor
	 */
	protected TieFlowValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public TieFlowValidator getInstance() {
		return new TieFlowValidator();
	}
		
	/**
	 * handles creation validation for a TieFlow
	 */
	public void validate( CreateTieFlowCommand tieFlow )throws Exception {
		Assert.notNull( tieFlow, "CreateTieFlowCommand should not be null" );
//		Assert.isNull( tieFlow.getTieFlowId(), "CreateTieFlowCommand identifier should be null" );
	}

	/**
	 * handles update validation for a TieFlow
	 */
	public void validate( UpdateTieFlowCommand tieFlow ) throws Exception {
		Assert.notNull( tieFlow, "UpdateTieFlowCommand should not be null" );
		Assert.notNull( tieFlow.getTieFlowId(), "UpdateTieFlowCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a TieFlow
	 */
    public void validate( DeleteTieFlowCommand tieFlow ) throws Exception {
		Assert.notNull( tieFlow, "{commandAlias} should not be null" );
		Assert.notNull( tieFlow.getTieFlowId(), "DeleteTieFlowCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a TieFlow
	 */
	public void validate( TieFlowFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "TieFlowFetchOneSummary should not be null" );
		Assert.notNull( summary.getTieFlowId(), "TieFlowFetchOneSummary identifier should not be null" );
	}



}
