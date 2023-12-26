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

public class VisibilityLayerValidator {
		
	/**
	 * default constructor
	 */
	protected VisibilityLayerValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public VisibilityLayerValidator getInstance() {
		return new VisibilityLayerValidator();
	}
		
	/**
	 * handles creation validation for a VisibilityLayer
	 */
	public void validate( CreateVisibilityLayerCommand visibilityLayer )throws Exception {
		Assert.notNull( visibilityLayer, "CreateVisibilityLayerCommand should not be null" );
//		Assert.isNull( visibilityLayer.getVisibilityLayerId(), "CreateVisibilityLayerCommand identifier should be null" );
	}

	/**
	 * handles update validation for a VisibilityLayer
	 */
	public void validate( UpdateVisibilityLayerCommand visibilityLayer ) throws Exception {
		Assert.notNull( visibilityLayer, "UpdateVisibilityLayerCommand should not be null" );
		Assert.notNull( visibilityLayer.getVisibilityLayerId(), "UpdateVisibilityLayerCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a VisibilityLayer
	 */
    public void validate( DeleteVisibilityLayerCommand visibilityLayer ) throws Exception {
		Assert.notNull( visibilityLayer, "{commandAlias} should not be null" );
		Assert.notNull( visibilityLayer.getVisibilityLayerId(), "DeleteVisibilityLayerCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a VisibilityLayer
	 */
	public void validate( VisibilityLayerFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "VisibilityLayerFetchOneSummary should not be null" );
		Assert.notNull( summary.getVisibilityLayerId(), "VisibilityLayerFetchOneSummary identifier should not be null" );
	}



}
