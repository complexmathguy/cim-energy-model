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

public class TopologyVersionValidator {
		
	/**
	 * default constructor
	 */
	protected TopologyVersionValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public TopologyVersionValidator getInstance() {
		return new TopologyVersionValidator();
	}
		
	/**
	 * handles creation validation for a TopologyVersion
	 */
	public void validate( CreateTopologyVersionCommand topologyVersion )throws Exception {
		Assert.notNull( topologyVersion, "CreateTopologyVersionCommand should not be null" );
//		Assert.isNull( topologyVersion.getTopologyVersionId(), "CreateTopologyVersionCommand identifier should be null" );
	}

	/**
	 * handles update validation for a TopologyVersion
	 */
	public void validate( UpdateTopologyVersionCommand topologyVersion ) throws Exception {
		Assert.notNull( topologyVersion, "UpdateTopologyVersionCommand should not be null" );
		Assert.notNull( topologyVersion.getTopologyVersionId(), "UpdateTopologyVersionCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a TopologyVersion
	 */
    public void validate( DeleteTopologyVersionCommand topologyVersion ) throws Exception {
		Assert.notNull( topologyVersion, "{commandAlias} should not be null" );
		Assert.notNull( topologyVersion.getTopologyVersionId(), "DeleteTopologyVersionCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a TopologyVersion
	 */
	public void validate( TopologyVersionFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "TopologyVersionFetchOneSummary should not be null" );
		Assert.notNull( summary.getTopologyVersionId(), "TopologyVersionFetchOneSummary identifier should not be null" );
	}



}
