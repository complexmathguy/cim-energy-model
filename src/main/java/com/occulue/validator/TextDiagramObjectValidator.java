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

public class TextDiagramObjectValidator {
		
	/**
	 * default constructor
	 */
	protected TextDiagramObjectValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public TextDiagramObjectValidator getInstance() {
		return new TextDiagramObjectValidator();
	}
		
	/**
	 * handles creation validation for a TextDiagramObject
	 */
	public void validate( CreateTextDiagramObjectCommand textDiagramObject )throws Exception {
		Assert.notNull( textDiagramObject, "CreateTextDiagramObjectCommand should not be null" );
//		Assert.isNull( textDiagramObject.getTextDiagramObjectId(), "CreateTextDiagramObjectCommand identifier should be null" );
	}

	/**
	 * handles update validation for a TextDiagramObject
	 */
	public void validate( UpdateTextDiagramObjectCommand textDiagramObject ) throws Exception {
		Assert.notNull( textDiagramObject, "UpdateTextDiagramObjectCommand should not be null" );
		Assert.notNull( textDiagramObject.getTextDiagramObjectId(), "UpdateTextDiagramObjectCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a TextDiagramObject
	 */
    public void validate( DeleteTextDiagramObjectCommand textDiagramObject ) throws Exception {
		Assert.notNull( textDiagramObject, "{commandAlias} should not be null" );
		Assert.notNull( textDiagramObject.getTextDiagramObjectId(), "DeleteTextDiagramObjectCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a TextDiagramObject
	 */
	public void validate( TextDiagramObjectFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "TextDiagramObjectFetchOneSummary should not be null" );
		Assert.notNull( summary.getTextDiagramObjectId(), "TextDiagramObjectFetchOneSummary identifier should not be null" );
	}



}
