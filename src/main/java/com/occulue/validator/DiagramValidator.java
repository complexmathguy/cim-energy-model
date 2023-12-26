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

public class DiagramValidator {
		
	/**
	 * default constructor
	 */
	protected DiagramValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public DiagramValidator getInstance() {
		return new DiagramValidator();
	}
		
	/**
	 * handles creation validation for a Diagram
	 */
	public void validate( CreateDiagramCommand diagram )throws Exception {
		Assert.notNull( diagram, "CreateDiagramCommand should not be null" );
//		Assert.isNull( diagram.getDiagramId(), "CreateDiagramCommand identifier should be null" );
	}

	/**
	 * handles update validation for a Diagram
	 */
	public void validate( UpdateDiagramCommand diagram ) throws Exception {
		Assert.notNull( diagram, "UpdateDiagramCommand should not be null" );
		Assert.notNull( diagram.getDiagramId(), "UpdateDiagramCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a Diagram
	 */
    public void validate( DeleteDiagramCommand diagram ) throws Exception {
		Assert.notNull( diagram, "{commandAlias} should not be null" );
		Assert.notNull( diagram.getDiagramId(), "DeleteDiagramCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a Diagram
	 */
	public void validate( DiagramFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "DiagramFetchOneSummary should not be null" );
		Assert.notNull( summary.getDiagramId(), "DiagramFetchOneSummary identifier should not be null" );
	}



}
