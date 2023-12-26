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

public class DCNodeValidator {
		
	/**
	 * default constructor
	 */
	protected DCNodeValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public DCNodeValidator getInstance() {
		return new DCNodeValidator();
	}
		
	/**
	 * handles creation validation for a DCNode
	 */
	public void validate( CreateDCNodeCommand dCNode )throws Exception {
		Assert.notNull( dCNode, "CreateDCNodeCommand should not be null" );
//		Assert.isNull( dCNode.getDCNodeId(), "CreateDCNodeCommand identifier should be null" );
	}

	/**
	 * handles update validation for a DCNode
	 */
	public void validate( UpdateDCNodeCommand dCNode ) throws Exception {
		Assert.notNull( dCNode, "UpdateDCNodeCommand should not be null" );
		Assert.notNull( dCNode.getDCNodeId(), "UpdateDCNodeCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a DCNode
	 */
    public void validate( DeleteDCNodeCommand dCNode ) throws Exception {
		Assert.notNull( dCNode, "{commandAlias} should not be null" );
		Assert.notNull( dCNode.getDCNodeId(), "DeleteDCNodeCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a DCNode
	 */
	public void validate( DCNodeFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "DCNodeFetchOneSummary should not be null" );
		Assert.notNull( summary.getDCNodeId(), "DCNodeFetchOneSummary identifier should not be null" );
	}



}
