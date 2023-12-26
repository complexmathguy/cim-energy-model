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

public class TransformerEndValidator {
		
	/**
	 * default constructor
	 */
	protected TransformerEndValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public TransformerEndValidator getInstance() {
		return new TransformerEndValidator();
	}
		
	/**
	 * handles creation validation for a TransformerEnd
	 */
	public void validate( CreateTransformerEndCommand transformerEnd )throws Exception {
		Assert.notNull( transformerEnd, "CreateTransformerEndCommand should not be null" );
//		Assert.isNull( transformerEnd.getTransformerEndId(), "CreateTransformerEndCommand identifier should be null" );
	}

	/**
	 * handles update validation for a TransformerEnd
	 */
	public void validate( UpdateTransformerEndCommand transformerEnd ) throws Exception {
		Assert.notNull( transformerEnd, "UpdateTransformerEndCommand should not be null" );
		Assert.notNull( transformerEnd.getTransformerEndId(), "UpdateTransformerEndCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a TransformerEnd
	 */
    public void validate( DeleteTransformerEndCommand transformerEnd ) throws Exception {
		Assert.notNull( transformerEnd, "{commandAlias} should not be null" );
		Assert.notNull( transformerEnd.getTransformerEndId(), "DeleteTransformerEndCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a TransformerEnd
	 */
	public void validate( TransformerEndFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "TransformerEndFetchOneSummary should not be null" );
		Assert.notNull( summary.getTransformerEndId(), "TransformerEndFetchOneSummary identifier should not be null" );
	}



}
