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

public class InductanceValidator {
		
	/**
	 * default constructor
	 */
	protected InductanceValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public InductanceValidator getInstance() {
		return new InductanceValidator();
	}
		
	/**
	 * handles creation validation for a Inductance
	 */
	public void validate( CreateInductanceCommand inductance )throws Exception {
		Assert.notNull( inductance, "CreateInductanceCommand should not be null" );
//		Assert.isNull( inductance.getInductanceId(), "CreateInductanceCommand identifier should be null" );
	}

	/**
	 * handles update validation for a Inductance
	 */
	public void validate( UpdateInductanceCommand inductance ) throws Exception {
		Assert.notNull( inductance, "UpdateInductanceCommand should not be null" );
		Assert.notNull( inductance.getInductanceId(), "UpdateInductanceCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a Inductance
	 */
    public void validate( DeleteInductanceCommand inductance ) throws Exception {
		Assert.notNull( inductance, "{commandAlias} should not be null" );
		Assert.notNull( inductance.getInductanceId(), "DeleteInductanceCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a Inductance
	 */
	public void validate( InductanceFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "InductanceFetchOneSummary should not be null" );
		Assert.notNull( summary.getInductanceId(), "InductanceFetchOneSummary identifier should not be null" );
	}



}
