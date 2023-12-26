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

public class LoadCompositeValidator {
		
	/**
	 * default constructor
	 */
	protected LoadCompositeValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public LoadCompositeValidator getInstance() {
		return new LoadCompositeValidator();
	}
		
	/**
	 * handles creation validation for a LoadComposite
	 */
	public void validate( CreateLoadCompositeCommand loadComposite )throws Exception {
		Assert.notNull( loadComposite, "CreateLoadCompositeCommand should not be null" );
//		Assert.isNull( loadComposite.getLoadCompositeId(), "CreateLoadCompositeCommand identifier should be null" );
	}

	/**
	 * handles update validation for a LoadComposite
	 */
	public void validate( UpdateLoadCompositeCommand loadComposite ) throws Exception {
		Assert.notNull( loadComposite, "UpdateLoadCompositeCommand should not be null" );
		Assert.notNull( loadComposite.getLoadCompositeId(), "UpdateLoadCompositeCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a LoadComposite
	 */
    public void validate( DeleteLoadCompositeCommand loadComposite ) throws Exception {
		Assert.notNull( loadComposite, "{commandAlias} should not be null" );
		Assert.notNull( loadComposite.getLoadCompositeId(), "DeleteLoadCompositeCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a LoadComposite
	 */
	public void validate( LoadCompositeFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "LoadCompositeFetchOneSummary should not be null" );
		Assert.notNull( summary.getLoadCompositeId(), "LoadCompositeFetchOneSummary identifier should not be null" );
	}



}
