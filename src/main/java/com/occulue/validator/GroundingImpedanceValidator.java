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

public class GroundingImpedanceValidator {
		
	/**
	 * default constructor
	 */
	protected GroundingImpedanceValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public GroundingImpedanceValidator getInstance() {
		return new GroundingImpedanceValidator();
	}
		
	/**
	 * handles creation validation for a GroundingImpedance
	 */
	public void validate( CreateGroundingImpedanceCommand groundingImpedance )throws Exception {
		Assert.notNull( groundingImpedance, "CreateGroundingImpedanceCommand should not be null" );
//		Assert.isNull( groundingImpedance.getGroundingImpedanceId(), "CreateGroundingImpedanceCommand identifier should be null" );
	}

	/**
	 * handles update validation for a GroundingImpedance
	 */
	public void validate( UpdateGroundingImpedanceCommand groundingImpedance ) throws Exception {
		Assert.notNull( groundingImpedance, "UpdateGroundingImpedanceCommand should not be null" );
		Assert.notNull( groundingImpedance.getGroundingImpedanceId(), "UpdateGroundingImpedanceCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a GroundingImpedance
	 */
    public void validate( DeleteGroundingImpedanceCommand groundingImpedance ) throws Exception {
		Assert.notNull( groundingImpedance, "{commandAlias} should not be null" );
		Assert.notNull( groundingImpedance.getGroundingImpedanceId(), "DeleteGroundingImpedanceCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a GroundingImpedance
	 */
	public void validate( GroundingImpedanceFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "GroundingImpedanceFetchOneSummary should not be null" );
		Assert.notNull( summary.getGroundingImpedanceId(), "GroundingImpedanceFetchOneSummary identifier should not be null" );
	}



}
