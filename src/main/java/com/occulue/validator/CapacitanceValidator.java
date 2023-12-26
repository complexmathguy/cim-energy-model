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

public class CapacitanceValidator {
		
	/**
	 * default constructor
	 */
	protected CapacitanceValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public CapacitanceValidator getInstance() {
		return new CapacitanceValidator();
	}
		
	/**
	 * handles creation validation for a Capacitance
	 */
	public void validate( CreateCapacitanceCommand capacitance )throws Exception {
		Assert.notNull( capacitance, "CreateCapacitanceCommand should not be null" );
//		Assert.isNull( capacitance.getCapacitanceId(), "CreateCapacitanceCommand identifier should be null" );
	}

	/**
	 * handles update validation for a Capacitance
	 */
	public void validate( UpdateCapacitanceCommand capacitance ) throws Exception {
		Assert.notNull( capacitance, "UpdateCapacitanceCommand should not be null" );
		Assert.notNull( capacitance.getCapacitanceId(), "UpdateCapacitanceCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a Capacitance
	 */
    public void validate( DeleteCapacitanceCommand capacitance ) throws Exception {
		Assert.notNull( capacitance, "{commandAlias} should not be null" );
		Assert.notNull( capacitance.getCapacitanceId(), "DeleteCapacitanceCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a Capacitance
	 */
	public void validate( CapacitanceFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "CapacitanceFetchOneSummary should not be null" );
		Assert.notNull( summary.getCapacitanceId(), "CapacitanceFetchOneSummary identifier should not be null" );
	}



}
