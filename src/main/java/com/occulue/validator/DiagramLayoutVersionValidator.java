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

public class DiagramLayoutVersionValidator {
		
	/**
	 * default constructor
	 */
	protected DiagramLayoutVersionValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public DiagramLayoutVersionValidator getInstance() {
		return new DiagramLayoutVersionValidator();
	}
		
	/**
	 * handles creation validation for a DiagramLayoutVersion
	 */
	public void validate( CreateDiagramLayoutVersionCommand diagramLayoutVersion )throws Exception {
		Assert.notNull( diagramLayoutVersion, "CreateDiagramLayoutVersionCommand should not be null" );
//		Assert.isNull( diagramLayoutVersion.getDiagramLayoutVersionId(), "CreateDiagramLayoutVersionCommand identifier should be null" );
	}

	/**
	 * handles update validation for a DiagramLayoutVersion
	 */
	public void validate( UpdateDiagramLayoutVersionCommand diagramLayoutVersion ) throws Exception {
		Assert.notNull( diagramLayoutVersion, "UpdateDiagramLayoutVersionCommand should not be null" );
		Assert.notNull( diagramLayoutVersion.getDiagramLayoutVersionId(), "UpdateDiagramLayoutVersionCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a DiagramLayoutVersion
	 */
    public void validate( DeleteDiagramLayoutVersionCommand diagramLayoutVersion ) throws Exception {
		Assert.notNull( diagramLayoutVersion, "{commandAlias} should not be null" );
		Assert.notNull( diagramLayoutVersion.getDiagramLayoutVersionId(), "DeleteDiagramLayoutVersionCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a DiagramLayoutVersion
	 */
	public void validate( DiagramLayoutVersionFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "DiagramLayoutVersionFetchOneSummary should not be null" );
		Assert.notNull( summary.getDiagramLayoutVersionId(), "DiagramLayoutVersionFetchOneSummary identifier should not be null" );
	}



}
