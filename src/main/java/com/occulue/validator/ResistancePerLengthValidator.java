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

public class ResistancePerLengthValidator {
		
	/**
	 * default constructor
	 */
	protected ResistancePerLengthValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ResistancePerLengthValidator getInstance() {
		return new ResistancePerLengthValidator();
	}
		
	/**
	 * handles creation validation for a ResistancePerLength
	 */
	public void validate( CreateResistancePerLengthCommand resistancePerLength )throws Exception {
		Assert.notNull( resistancePerLength, "CreateResistancePerLengthCommand should not be null" );
//		Assert.isNull( resistancePerLength.getResistancePerLengthId(), "CreateResistancePerLengthCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ResistancePerLength
	 */
	public void validate( UpdateResistancePerLengthCommand resistancePerLength ) throws Exception {
		Assert.notNull( resistancePerLength, "UpdateResistancePerLengthCommand should not be null" );
		Assert.notNull( resistancePerLength.getResistancePerLengthId(), "UpdateResistancePerLengthCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ResistancePerLength
	 */
    public void validate( DeleteResistancePerLengthCommand resistancePerLength ) throws Exception {
		Assert.notNull( resistancePerLength, "{commandAlias} should not be null" );
		Assert.notNull( resistancePerLength.getResistancePerLengthId(), "DeleteResistancePerLengthCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ResistancePerLength
	 */
	public void validate( ResistancePerLengthFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ResistancePerLengthFetchOneSummary should not be null" );
		Assert.notNull( summary.getResistancePerLengthId(), "ResistancePerLengthFetchOneSummary identifier should not be null" );
	}



}
