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

public class LoadStaticValidator {
		
	/**
	 * default constructor
	 */
	protected LoadStaticValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public LoadStaticValidator getInstance() {
		return new LoadStaticValidator();
	}
		
	/**
	 * handles creation validation for a LoadStatic
	 */
	public void validate( CreateLoadStaticCommand loadStatic )throws Exception {
		Assert.notNull( loadStatic, "CreateLoadStaticCommand should not be null" );
//		Assert.isNull( loadStatic.getLoadStaticId(), "CreateLoadStaticCommand identifier should be null" );
	}

	/**
	 * handles update validation for a LoadStatic
	 */
	public void validate( UpdateLoadStaticCommand loadStatic ) throws Exception {
		Assert.notNull( loadStatic, "UpdateLoadStaticCommand should not be null" );
		Assert.notNull( loadStatic.getLoadStaticId(), "UpdateLoadStaticCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a LoadStatic
	 */
    public void validate( DeleteLoadStaticCommand loadStatic ) throws Exception {
		Assert.notNull( loadStatic, "{commandAlias} should not be null" );
		Assert.notNull( loadStatic.getLoadStaticId(), "DeleteLoadStaticCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a LoadStatic
	 */
	public void validate( LoadStaticFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "LoadStaticFetchOneSummary should not be null" );
		Assert.notNull( summary.getLoadStaticId(), "LoadStaticFetchOneSummary identifier should not be null" );
	}



}
