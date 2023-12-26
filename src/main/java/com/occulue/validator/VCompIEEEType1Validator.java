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

public class VCompIEEEType1Validator {
		
	/**
	 * default constructor
	 */
	protected VCompIEEEType1Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public VCompIEEEType1Validator getInstance() {
		return new VCompIEEEType1Validator();
	}
		
	/**
	 * handles creation validation for a VCompIEEEType1
	 */
	public void validate( CreateVCompIEEEType1Command vCompIEEEType1 )throws Exception {
		Assert.notNull( vCompIEEEType1, "CreateVCompIEEEType1Command should not be null" );
//		Assert.isNull( vCompIEEEType1.getVCompIEEEType1Id(), "CreateVCompIEEEType1Command identifier should be null" );
	}

	/**
	 * handles update validation for a VCompIEEEType1
	 */
	public void validate( UpdateVCompIEEEType1Command vCompIEEEType1 ) throws Exception {
		Assert.notNull( vCompIEEEType1, "UpdateVCompIEEEType1Command should not be null" );
		Assert.notNull( vCompIEEEType1.getVCompIEEEType1Id(), "UpdateVCompIEEEType1Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a VCompIEEEType1
	 */
    public void validate( DeleteVCompIEEEType1Command vCompIEEEType1 ) throws Exception {
		Assert.notNull( vCompIEEEType1, "{commandAlias} should not be null" );
		Assert.notNull( vCompIEEEType1.getVCompIEEEType1Id(), "DeleteVCompIEEEType1Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a VCompIEEEType1
	 */
	public void validate( VCompIEEEType1FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "VCompIEEEType1FetchOneSummary should not be null" );
		Assert.notNull( summary.getVCompIEEEType1Id(), "VCompIEEEType1FetchOneSummary identifier should not be null" );
	}



}
