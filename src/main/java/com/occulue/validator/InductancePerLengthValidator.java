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

public class InductancePerLengthValidator {
		
	/**
	 * default constructor
	 */
	protected InductancePerLengthValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public InductancePerLengthValidator getInstance() {
		return new InductancePerLengthValidator();
	}
		
	/**
	 * handles creation validation for a InductancePerLength
	 */
	public void validate( CreateInductancePerLengthCommand inductancePerLength )throws Exception {
		Assert.notNull( inductancePerLength, "CreateInductancePerLengthCommand should not be null" );
//		Assert.isNull( inductancePerLength.getInductancePerLengthId(), "CreateInductancePerLengthCommand identifier should be null" );
	}

	/**
	 * handles update validation for a InductancePerLength
	 */
	public void validate( UpdateInductancePerLengthCommand inductancePerLength ) throws Exception {
		Assert.notNull( inductancePerLength, "UpdateInductancePerLengthCommand should not be null" );
		Assert.notNull( inductancePerLength.getInductancePerLengthId(), "UpdateInductancePerLengthCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a InductancePerLength
	 */
    public void validate( DeleteInductancePerLengthCommand inductancePerLength ) throws Exception {
		Assert.notNull( inductancePerLength, "{commandAlias} should not be null" );
		Assert.notNull( inductancePerLength.getInductancePerLengthId(), "DeleteInductancePerLengthCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a InductancePerLength
	 */
	public void validate( InductancePerLengthFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "InductancePerLengthFetchOneSummary should not be null" );
		Assert.notNull( summary.getInductancePerLengthId(), "InductancePerLengthFetchOneSummary identifier should not be null" );
	}



}
