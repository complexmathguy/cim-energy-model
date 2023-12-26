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

public class GeographicalLocationVersionValidator {
		
	/**
	 * default constructor
	 */
	protected GeographicalLocationVersionValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public GeographicalLocationVersionValidator getInstance() {
		return new GeographicalLocationVersionValidator();
	}
		
	/**
	 * handles creation validation for a GeographicalLocationVersion
	 */
	public void validate( CreateGeographicalLocationVersionCommand geographicalLocationVersion )throws Exception {
		Assert.notNull( geographicalLocationVersion, "CreateGeographicalLocationVersionCommand should not be null" );
//		Assert.isNull( geographicalLocationVersion.getGeographicalLocationVersionId(), "CreateGeographicalLocationVersionCommand identifier should be null" );
	}

	/**
	 * handles update validation for a GeographicalLocationVersion
	 */
	public void validate( UpdateGeographicalLocationVersionCommand geographicalLocationVersion ) throws Exception {
		Assert.notNull( geographicalLocationVersion, "UpdateGeographicalLocationVersionCommand should not be null" );
		Assert.notNull( geographicalLocationVersion.getGeographicalLocationVersionId(), "UpdateGeographicalLocationVersionCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a GeographicalLocationVersion
	 */
    public void validate( DeleteGeographicalLocationVersionCommand geographicalLocationVersion ) throws Exception {
		Assert.notNull( geographicalLocationVersion, "{commandAlias} should not be null" );
		Assert.notNull( geographicalLocationVersion.getGeographicalLocationVersionId(), "DeleteGeographicalLocationVersionCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a GeographicalLocationVersion
	 */
	public void validate( GeographicalLocationVersionFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GeographicalLocationVersionFetchOneSummary should not be null" );
		Assert.notNull( summary.getGeographicalLocationVersionId(), "GeographicalLocationVersionFetchOneSummary identifier should not be null" );
	}



}
