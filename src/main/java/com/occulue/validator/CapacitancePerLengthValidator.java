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

public class CapacitancePerLengthValidator {
		
	/**
	 * default constructor
	 */
	protected CapacitancePerLengthValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public CapacitancePerLengthValidator getInstance() {
		return new CapacitancePerLengthValidator();
	}
		
	/**
	 * handles creation validation for a CapacitancePerLength
	 */
	public void validate( CreateCapacitancePerLengthCommand capacitancePerLength )throws Exception {
		Assert.notNull( capacitancePerLength, "CreateCapacitancePerLengthCommand should not be null" );
//		Assert.isNull( capacitancePerLength.getCapacitancePerLengthId(), "CreateCapacitancePerLengthCommand identifier should be null" );
	}

	/**
	 * handles update validation for a CapacitancePerLength
	 */
	public void validate( UpdateCapacitancePerLengthCommand capacitancePerLength ) throws Exception {
		Assert.notNull( capacitancePerLength, "UpdateCapacitancePerLengthCommand should not be null" );
		Assert.notNull( capacitancePerLength.getCapacitancePerLengthId(), "UpdateCapacitancePerLengthCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a CapacitancePerLength
	 */
    public void validate( DeleteCapacitancePerLengthCommand capacitancePerLength ) throws Exception {
		Assert.notNull( capacitancePerLength, "{commandAlias} should not be null" );
		Assert.notNull( capacitancePerLength.getCapacitancePerLengthId(), "DeleteCapacitancePerLengthCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a CapacitancePerLength
	 */
	public void validate( CapacitancePerLengthFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "CapacitancePerLengthFetchOneSummary should not be null" );
		Assert.notNull( summary.getCapacitancePerLengthId(), "CapacitancePerLengthFetchOneSummary identifier should not be null" );
	}



}
