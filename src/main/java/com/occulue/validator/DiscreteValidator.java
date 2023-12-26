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

public class DiscreteValidator {
		
	/**
	 * default constructor
	 */
	protected DiscreteValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public DiscreteValidator getInstance() {
		return new DiscreteValidator();
	}
		
	/**
	 * handles creation validation for a Discrete
	 */
	public void validate( CreateDiscreteCommand discrete )throws Exception {
		Assert.notNull( discrete, "CreateDiscreteCommand should not be null" );
//		Assert.isNull( discrete.getDiscreteId(), "CreateDiscreteCommand identifier should be null" );
	}

	/**
	 * handles update validation for a Discrete
	 */
	public void validate( UpdateDiscreteCommand discrete ) throws Exception {
		Assert.notNull( discrete, "UpdateDiscreteCommand should not be null" );
		Assert.notNull( discrete.getDiscreteId(), "UpdateDiscreteCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a Discrete
	 */
    public void validate( DeleteDiscreteCommand discrete ) throws Exception {
		Assert.notNull( discrete, "{commandAlias} should not be null" );
		Assert.notNull( discrete.getDiscreteId(), "DeleteDiscreteCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a Discrete
	 */
	public void validate( DiscreteFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "DiscreteFetchOneSummary should not be null" );
		Assert.notNull( summary.getDiscreteId(), "DiscreteFetchOneSummary identifier should not be null" );
	}



}
