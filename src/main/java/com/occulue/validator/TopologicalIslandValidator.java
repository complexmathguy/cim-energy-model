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

public class TopologicalIslandValidator {
		
	/**
	 * default constructor
	 */
	protected TopologicalIslandValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public TopologicalIslandValidator getInstance() {
		return new TopologicalIslandValidator();
	}
		
	/**
	 * handles creation validation for a TopologicalIsland
	 */
	public void validate( CreateTopologicalIslandCommand topologicalIsland )throws Exception {
		Assert.notNull( topologicalIsland, "CreateTopologicalIslandCommand should not be null" );
//		Assert.isNull( topologicalIsland.getTopologicalIslandId(), "CreateTopologicalIslandCommand identifier should be null" );
	}

	/**
	 * handles update validation for a TopologicalIsland
	 */
	public void validate( UpdateTopologicalIslandCommand topologicalIsland ) throws Exception {
		Assert.notNull( topologicalIsland, "UpdateTopologicalIslandCommand should not be null" );
		Assert.notNull( topologicalIsland.getTopologicalIslandId(), "UpdateTopologicalIslandCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a TopologicalIsland
	 */
    public void validate( DeleteTopologicalIslandCommand topologicalIsland ) throws Exception {
		Assert.notNull( topologicalIsland, "{commandAlias} should not be null" );
		Assert.notNull( topologicalIsland.getTopologicalIslandId(), "DeleteTopologicalIslandCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a TopologicalIsland
	 */
	public void validate( TopologicalIslandFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "TopologicalIslandFetchOneSummary should not be null" );
		Assert.notNull( summary.getTopologicalIslandId(), "TopologicalIslandFetchOneSummary identifier should not be null" );
	}



}
