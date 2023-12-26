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

public class ReportingGroupValidator {
		
	/**
	 * default constructor
	 */
	protected ReportingGroupValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ReportingGroupValidator getInstance() {
		return new ReportingGroupValidator();
	}
		
	/**
	 * handles creation validation for a ReportingGroup
	 */
	public void validate( CreateReportingGroupCommand reportingGroup )throws Exception {
		Assert.notNull( reportingGroup, "CreateReportingGroupCommand should not be null" );
//		Assert.isNull( reportingGroup.getReportingGroupId(), "CreateReportingGroupCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ReportingGroup
	 */
	public void validate( UpdateReportingGroupCommand reportingGroup ) throws Exception {
		Assert.notNull( reportingGroup, "UpdateReportingGroupCommand should not be null" );
		Assert.notNull( reportingGroup.getReportingGroupId(), "UpdateReportingGroupCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ReportingGroup
	 */
    public void validate( DeleteReportingGroupCommand reportingGroup ) throws Exception {
		Assert.notNull( reportingGroup, "{commandAlias} should not be null" );
		Assert.notNull( reportingGroup.getReportingGroupId(), "DeleteReportingGroupCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ReportingGroup
	 */
	public void validate( ReportingGroupFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ReportingGroupFetchOneSummary should not be null" );
		Assert.notNull( summary.getReportingGroupId(), "ReportingGroupFetchOneSummary identifier should not be null" );
	}



}
