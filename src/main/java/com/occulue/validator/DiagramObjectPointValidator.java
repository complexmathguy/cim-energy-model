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

public class DiagramObjectPointValidator {
		
	/**
	 * default constructor
	 */
	protected DiagramObjectPointValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public DiagramObjectPointValidator getInstance() {
		return new DiagramObjectPointValidator();
	}
		
	/**
	 * handles creation validation for a DiagramObjectPoint
	 */
	public void validate( CreateDiagramObjectPointCommand diagramObjectPoint )throws Exception {
		Assert.notNull( diagramObjectPoint, "CreateDiagramObjectPointCommand should not be null" );
//		Assert.isNull( diagramObjectPoint.getDiagramObjectPointId(), "CreateDiagramObjectPointCommand identifier should be null" );
	}

	/**
	 * handles update validation for a DiagramObjectPoint
	 */
	public void validate( UpdateDiagramObjectPointCommand diagramObjectPoint ) throws Exception {
		Assert.notNull( diagramObjectPoint, "UpdateDiagramObjectPointCommand should not be null" );
		Assert.notNull( diagramObjectPoint.getDiagramObjectPointId(), "UpdateDiagramObjectPointCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a DiagramObjectPoint
	 */
    public void validate( DeleteDiagramObjectPointCommand diagramObjectPoint ) throws Exception {
		Assert.notNull( diagramObjectPoint, "{commandAlias} should not be null" );
		Assert.notNull( diagramObjectPoint.getDiagramObjectPointId(), "DeleteDiagramObjectPointCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a DiagramObjectPoint
	 */
	public void validate( DiagramObjectPointFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "DiagramObjectPointFetchOneSummary should not be null" );
		Assert.notNull( summary.getDiagramObjectPointId(), "DiagramObjectPointFetchOneSummary identifier should not be null" );
	}



}
