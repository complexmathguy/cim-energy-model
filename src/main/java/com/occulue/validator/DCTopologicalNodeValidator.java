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

public class DCTopologicalNodeValidator {
		
	/**
	 * default constructor
	 */
	protected DCTopologicalNodeValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public DCTopologicalNodeValidator getInstance() {
		return new DCTopologicalNodeValidator();
	}
		
	/**
	 * handles creation validation for a DCTopologicalNode
	 */
	public void validate( CreateDCTopologicalNodeCommand dCTopologicalNode )throws Exception {
		Assert.notNull( dCTopologicalNode, "CreateDCTopologicalNodeCommand should not be null" );
//		Assert.isNull( dCTopologicalNode.getDCTopologicalNodeId(), "CreateDCTopologicalNodeCommand identifier should be null" );
	}

	/**
	 * handles update validation for a DCTopologicalNode
	 */
	public void validate( UpdateDCTopologicalNodeCommand dCTopologicalNode ) throws Exception {
		Assert.notNull( dCTopologicalNode, "UpdateDCTopologicalNodeCommand should not be null" );
		Assert.notNull( dCTopologicalNode.getDCTopologicalNodeId(), "UpdateDCTopologicalNodeCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a DCTopologicalNode
	 */
    public void validate( DeleteDCTopologicalNodeCommand dCTopologicalNode ) throws Exception {
		Assert.notNull( dCTopologicalNode, "{commandAlias} should not be null" );
		Assert.notNull( dCTopologicalNode.getDCTopologicalNodeId(), "DeleteDCTopologicalNodeCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a DCTopologicalNode
	 */
	public void validate( DCTopologicalNodeFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "DCTopologicalNodeFetchOneSummary should not be null" );
		Assert.notNull( summary.getDCTopologicalNodeId(), "DCTopologicalNodeFetchOneSummary identifier should not be null" );
	}



}
