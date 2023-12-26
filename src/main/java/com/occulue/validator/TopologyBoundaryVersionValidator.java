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

public class TopologyBoundaryVersionValidator {
		
	/**
	 * default constructor
	 */
	protected TopologyBoundaryVersionValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public TopologyBoundaryVersionValidator getInstance() {
		return new TopologyBoundaryVersionValidator();
	}
		
	/**
	 * handles creation validation for a TopologyBoundaryVersion
	 */
	public void validate( CreateTopologyBoundaryVersionCommand topologyBoundaryVersion )throws Exception {
		Assert.notNull( topologyBoundaryVersion, "CreateTopologyBoundaryVersionCommand should not be null" );
//		Assert.isNull( topologyBoundaryVersion.getTopologyBoundaryVersionId(), "CreateTopologyBoundaryVersionCommand identifier should be null" );
	}

	/**
	 * handles update validation for a TopologyBoundaryVersion
	 */
	public void validate( UpdateTopologyBoundaryVersionCommand topologyBoundaryVersion ) throws Exception {
		Assert.notNull( topologyBoundaryVersion, "UpdateTopologyBoundaryVersionCommand should not be null" );
		Assert.notNull( topologyBoundaryVersion.getTopologyBoundaryVersionId(), "UpdateTopologyBoundaryVersionCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a TopologyBoundaryVersion
	 */
    public void validate( DeleteTopologyBoundaryVersionCommand topologyBoundaryVersion ) throws Exception {
		Assert.notNull( topologyBoundaryVersion, "{commandAlias} should not be null" );
		Assert.notNull( topologyBoundaryVersion.getTopologyBoundaryVersionId(), "DeleteTopologyBoundaryVersionCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a TopologyBoundaryVersion
	 */
	public void validate( TopologyBoundaryVersionFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "TopologyBoundaryVersionFetchOneSummary should not be null" );
		Assert.notNull( summary.getTopologyBoundaryVersionId(), "TopologyBoundaryVersionFetchOneSummary identifier should not be null" );
	}



}
