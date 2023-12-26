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

public class DiagramStyleValidator {
		
	/**
	 * default constructor
	 */
	protected DiagramStyleValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public DiagramStyleValidator getInstance() {
		return new DiagramStyleValidator();
	}
		
	/**
	 * handles creation validation for a DiagramStyle
	 */
	public void validate( CreateDiagramStyleCommand diagramStyle )throws Exception {
		Assert.notNull( diagramStyle, "CreateDiagramStyleCommand should not be null" );
//		Assert.isNull( diagramStyle.getDiagramStyleId(), "CreateDiagramStyleCommand identifier should be null" );
	}

	/**
	 * handles update validation for a DiagramStyle
	 */
	public void validate( UpdateDiagramStyleCommand diagramStyle ) throws Exception {
		Assert.notNull( diagramStyle, "UpdateDiagramStyleCommand should not be null" );
		Assert.notNull( diagramStyle.getDiagramStyleId(), "UpdateDiagramStyleCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a DiagramStyle
	 */
    public void validate( DeleteDiagramStyleCommand diagramStyle ) throws Exception {
		Assert.notNull( diagramStyle, "{commandAlias} should not be null" );
		Assert.notNull( diagramStyle.getDiagramStyleId(), "DeleteDiagramStyleCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a DiagramStyle
	 */
	public void validate( DiagramStyleFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "DiagramStyleFetchOneSummary should not be null" );
		Assert.notNull( summary.getDiagramStyleId(), "DiagramStyleFetchOneSummary identifier should not be null" );
	}



}
