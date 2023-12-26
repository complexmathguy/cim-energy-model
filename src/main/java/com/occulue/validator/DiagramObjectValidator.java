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

public class DiagramObjectValidator {
		
	/**
	 * default constructor
	 */
	protected DiagramObjectValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public DiagramObjectValidator getInstance() {
		return new DiagramObjectValidator();
	}
		
	/**
	 * handles creation validation for a DiagramObject
	 */
	public void validate( CreateDiagramObjectCommand diagramObject )throws Exception {
		Assert.notNull( diagramObject, "CreateDiagramObjectCommand should not be null" );
//		Assert.isNull( diagramObject.getDiagramObjectId(), "CreateDiagramObjectCommand identifier should be null" );
	}

	/**
	 * handles update validation for a DiagramObject
	 */
	public void validate( UpdateDiagramObjectCommand diagramObject ) throws Exception {
		Assert.notNull( diagramObject, "UpdateDiagramObjectCommand should not be null" );
		Assert.notNull( diagramObject.getDiagramObjectId(), "UpdateDiagramObjectCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a DiagramObject
	 */
    public void validate( DeleteDiagramObjectCommand diagramObject ) throws Exception {
		Assert.notNull( diagramObject, "{commandAlias} should not be null" );
		Assert.notNull( diagramObject.getDiagramObjectId(), "DeleteDiagramObjectCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a DiagramObject
	 */
	public void validate( DiagramObjectFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "DiagramObjectFetchOneSummary should not be null" );
		Assert.notNull( summary.getDiagramObjectId(), "DiagramObjectFetchOneSummary identifier should not be null" );
	}



}
