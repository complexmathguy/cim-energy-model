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

public class ControlAreaValidator {
		
	/**
	 * default constructor
	 */
	protected ControlAreaValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ControlAreaValidator getInstance() {
		return new ControlAreaValidator();
	}
		
	/**
	 * handles creation validation for a ControlArea
	 */
	public void validate( CreateControlAreaCommand controlArea )throws Exception {
		Assert.notNull( controlArea, "CreateControlAreaCommand should not be null" );
//		Assert.isNull( controlArea.getControlAreaId(), "CreateControlAreaCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ControlArea
	 */
	public void validate( UpdateControlAreaCommand controlArea ) throws Exception {
		Assert.notNull( controlArea, "UpdateControlAreaCommand should not be null" );
		Assert.notNull( controlArea.getControlAreaId(), "UpdateControlAreaCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ControlArea
	 */
    public void validate( DeleteControlAreaCommand controlArea ) throws Exception {
		Assert.notNull( controlArea, "{commandAlias} should not be null" );
		Assert.notNull( controlArea.getControlAreaId(), "DeleteControlAreaCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ControlArea
	 */
	public void validate( ControlAreaFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ControlAreaFetchOneSummary should not be null" );
		Assert.notNull( summary.getControlAreaId(), "ControlAreaFetchOneSummary identifier should not be null" );
	}



}
