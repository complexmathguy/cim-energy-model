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

public class MechLoad1Validator {
		
	/**
	 * default constructor
	 */
	protected MechLoad1Validator() {	
	}
	
	/**
	 * factory method
	 */
	static public MechLoad1Validator getInstance() {
		return new MechLoad1Validator();
	}
		
	/**
	 * handles creation validation for a MechLoad1
	 */
	public void validate( CreateMechLoad1Command mechLoad1 )throws Exception {
		Assert.notNull( mechLoad1, "CreateMechLoad1Command should not be null" );
//		Assert.isNull( mechLoad1.getMechLoad1Id(), "CreateMechLoad1Command identifier should be null" );
	}

	/**
	 * handles update validation for a MechLoad1
	 */
	public void validate( UpdateMechLoad1Command mechLoad1 ) throws Exception {
		Assert.notNull( mechLoad1, "UpdateMechLoad1Command should not be null" );
		Assert.notNull( mechLoad1.getMechLoad1Id(), "UpdateMechLoad1Command identifier should not be null" );
    }

	/**
	 * handles delete validation for a MechLoad1
	 */
    public void validate( DeleteMechLoad1Command mechLoad1 ) throws Exception {
		Assert.notNull( mechLoad1, "{commandAlias} should not be null" );
		Assert.notNull( mechLoad1.getMechLoad1Id(), "DeleteMechLoad1Command identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a MechLoad1
	 */
	public void validate( MechLoad1FetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "MechLoad1FetchOneSummary should not be null" );
		Assert.notNull( summary.getMechLoad1Id(), "MechLoad1FetchOneSummary identifier should not be null" );
	}



}
