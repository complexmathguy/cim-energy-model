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

public class TopologicalNodeValidator {
		
	/**
	 * default constructor
	 */
	protected TopologicalNodeValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public TopologicalNodeValidator getInstance() {
		return new TopologicalNodeValidator();
	}
		
	/**
	 * handles creation validation for a TopologicalNode
	 */
	public void validate( CreateTopologicalNodeCommand topologicalNode )throws Exception {
		Assert.notNull( topologicalNode, "CreateTopologicalNodeCommand should not be null" );
//		Assert.isNull( topologicalNode.getTopologicalNodeId(), "CreateTopologicalNodeCommand identifier should be null" );
	}

	/**
	 * handles update validation for a TopologicalNode
	 */
	public void validate( UpdateTopologicalNodeCommand topologicalNode ) throws Exception {
		Assert.notNull( topologicalNode, "UpdateTopologicalNodeCommand should not be null" );
		Assert.notNull( topologicalNode.getTopologicalNodeId(), "UpdateTopologicalNodeCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a TopologicalNode
	 */
    public void validate( DeleteTopologicalNodeCommand topologicalNode ) throws Exception {
		Assert.notNull( topologicalNode, "{commandAlias} should not be null" );
		Assert.notNull( topologicalNode.getTopologicalNodeId(), "DeleteTopologicalNodeCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a TopologicalNode
	 */
	public void validate( TopologicalNodeFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "TopologicalNodeFetchOneSummary should not be null" );
		Assert.notNull( summary.getTopologicalNodeId(), "TopologicalNodeFetchOneSummary identifier should not be null" );
	}



}
