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

public class AreaValidator {
		
	/**
	 * default constructor
	 */
	protected AreaValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public AreaValidator getInstance() {
		return new AreaValidator();
	}
		
	/**
	 * handles creation validation for a Area
	 */
	public void validate( CreateAreaCommand area )throws Exception {
		Assert.notNull( area, "CreateAreaCommand should not be null" );
//		Assert.isNull( area.getAreaId(), "CreateAreaCommand identifier should be null" );
	}

	/**
	 * handles update validation for a Area
	 */
	public void validate( UpdateAreaCommand area ) throws Exception {
		Assert.notNull( area, "UpdateAreaCommand should not be null" );
		Assert.notNull( area.getAreaId(), "UpdateAreaCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a Area
	 */
    public void validate( DeleteAreaCommand area ) throws Exception {
		Assert.notNull( area, "{commandAlias} should not be null" );
		Assert.notNull( area.getAreaId(), "DeleteAreaCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a Area
	 */
	public void validate( AreaFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "AreaFetchOneSummary should not be null" );
		Assert.notNull( summary.getAreaId(), "AreaFetchOneSummary identifier should not be null" );
	}



}
