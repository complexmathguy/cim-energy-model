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

public class DomainVersionValidator {
		
	/**
	 * default constructor
	 */
	protected DomainVersionValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public DomainVersionValidator getInstance() {
		return new DomainVersionValidator();
	}
		
	/**
	 * handles creation validation for a DomainVersion
	 */
	public void validate( CreateDomainVersionCommand domainVersion )throws Exception {
		Assert.notNull( domainVersion, "CreateDomainVersionCommand should not be null" );
//		Assert.isNull( domainVersion.getDomainVersionId(), "CreateDomainVersionCommand identifier should be null" );
	}

	/**
	 * handles update validation for a DomainVersion
	 */
	public void validate( UpdateDomainVersionCommand domainVersion ) throws Exception {
		Assert.notNull( domainVersion, "UpdateDomainVersionCommand should not be null" );
		Assert.notNull( domainVersion.getDomainVersionId(), "UpdateDomainVersionCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a DomainVersion
	 */
    public void validate( DeleteDomainVersionCommand domainVersion ) throws Exception {
		Assert.notNull( domainVersion, "{commandAlias} should not be null" );
		Assert.notNull( domainVersion.getDomainVersionId(), "DeleteDomainVersionCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a DomainVersion
	 */
	public void validate( DomainVersionFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "DomainVersionFetchOneSummary should not be null" );
		Assert.notNull( summary.getDomainVersionId(), "DomainVersionFetchOneSummary identifier should not be null" );
	}



}
