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

public class NonlinearShuntCompensatorPointValidator {
		
	/**
	 * default constructor
	 */
	protected NonlinearShuntCompensatorPointValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public NonlinearShuntCompensatorPointValidator getInstance() {
		return new NonlinearShuntCompensatorPointValidator();
	}
		
	/**
	 * handles creation validation for a NonlinearShuntCompensatorPoint
	 */
	public void validate( CreateNonlinearShuntCompensatorPointCommand nonlinearShuntCompensatorPoint )throws Exception {
		Assert.notNull( nonlinearShuntCompensatorPoint, "CreateNonlinearShuntCompensatorPointCommand should not be null" );
//		Assert.isNull( nonlinearShuntCompensatorPoint.getNonlinearShuntCompensatorPointId(), "CreateNonlinearShuntCompensatorPointCommand identifier should be null" );
	}

	/**
	 * handles update validation for a NonlinearShuntCompensatorPoint
	 */
	public void validate( UpdateNonlinearShuntCompensatorPointCommand nonlinearShuntCompensatorPoint ) throws Exception {
		Assert.notNull( nonlinearShuntCompensatorPoint, "UpdateNonlinearShuntCompensatorPointCommand should not be null" );
		Assert.notNull( nonlinearShuntCompensatorPoint.getNonlinearShuntCompensatorPointId(), "UpdateNonlinearShuntCompensatorPointCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a NonlinearShuntCompensatorPoint
	 */
    public void validate( DeleteNonlinearShuntCompensatorPointCommand nonlinearShuntCompensatorPoint ) throws Exception {
		Assert.notNull( nonlinearShuntCompensatorPoint, "{commandAlias} should not be null" );
		Assert.notNull( nonlinearShuntCompensatorPoint.getNonlinearShuntCompensatorPointId(), "DeleteNonlinearShuntCompensatorPointCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a NonlinearShuntCompensatorPoint
	 */
	public void validate( NonlinearShuntCompensatorPointFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "NonlinearShuntCompensatorPointFetchOneSummary should not be null" );
		Assert.notNull( summary.getNonlinearShuntCompensatorPointId(), "NonlinearShuntCompensatorPointFetchOneSummary identifier should not be null" );
	}



}
