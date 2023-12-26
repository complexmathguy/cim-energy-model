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

public class ResistanceValidator {
		
	/**
	 * default constructor
	 */
	protected ResistanceValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ResistanceValidator getInstance() {
		return new ResistanceValidator();
	}
		
	/**
	 * handles creation validation for a Resistance
	 */
	public void validate( CreateResistanceCommand resistance )throws Exception {
		Assert.notNull( resistance, "CreateResistanceCommand should not be null" );
//		Assert.isNull( resistance.getResistanceId(), "CreateResistanceCommand identifier should be null" );
	}

	/**
	 * handles update validation for a Resistance
	 */
	public void validate( UpdateResistanceCommand resistance ) throws Exception {
		Assert.notNull( resistance, "UpdateResistanceCommand should not be null" );
		Assert.notNull( resistance.getResistanceId(), "UpdateResistanceCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a Resistance
	 */
    public void validate( DeleteResistanceCommand resistance ) throws Exception {
		Assert.notNull( resistance, "{commandAlias} should not be null" );
		Assert.notNull( resistance.getResistanceId(), "DeleteResistanceCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a Resistance
	 */
	public void validate( ResistanceFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ResistanceFetchOneSummary should not be null" );
		Assert.notNull( summary.getResistanceId(), "ResistanceFetchOneSummary identifier should not be null" );
	}



}
