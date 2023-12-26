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

public class BoundaryExtensionsValidator {
		
	/**
	 * default constructor
	 */
	protected BoundaryExtensionsValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public BoundaryExtensionsValidator getInstance() {
		return new BoundaryExtensionsValidator();
	}
		
	/**
	 * handles creation validation for a BoundaryExtensions
	 */
	public void validate( CreateBoundaryExtensionsCommand boundaryExtensions )throws Exception {
		Assert.notNull( boundaryExtensions, "CreateBoundaryExtensionsCommand should not be null" );
//		Assert.isNull( boundaryExtensions.getBoundaryExtensionsId(), "CreateBoundaryExtensionsCommand identifier should be null" );
	}

	/**
	 * handles update validation for a BoundaryExtensions
	 */
	public void validate( UpdateBoundaryExtensionsCommand boundaryExtensions ) throws Exception {
		Assert.notNull( boundaryExtensions, "UpdateBoundaryExtensionsCommand should not be null" );
		Assert.notNull( boundaryExtensions.getBoundaryExtensionsId(), "UpdateBoundaryExtensionsCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a BoundaryExtensions
	 */
    public void validate( DeleteBoundaryExtensionsCommand boundaryExtensions ) throws Exception {
		Assert.notNull( boundaryExtensions, "{commandAlias} should not be null" );
		Assert.notNull( boundaryExtensions.getBoundaryExtensionsId(), "DeleteBoundaryExtensionsCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a BoundaryExtensions
	 */
	public void validate( BoundaryExtensionsFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "BoundaryExtensionsFetchOneSummary should not be null" );
		Assert.notNull( summary.getBoundaryExtensionsId(), "BoundaryExtensionsFetchOneSummary identifier should not be null" );
	}



}
