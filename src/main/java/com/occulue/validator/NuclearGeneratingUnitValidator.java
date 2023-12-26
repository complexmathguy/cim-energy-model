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

public class NuclearGeneratingUnitValidator {
		
	/**
	 * default constructor
	 */
	protected NuclearGeneratingUnitValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public NuclearGeneratingUnitValidator getInstance() {
		return new NuclearGeneratingUnitValidator();
	}
		
	/**
	 * handles creation validation for a NuclearGeneratingUnit
	 */
	public void validate( CreateNuclearGeneratingUnitCommand nuclearGeneratingUnit )throws Exception {
		Assert.notNull( nuclearGeneratingUnit, "CreateNuclearGeneratingUnitCommand should not be null" );
//		Assert.isNull( nuclearGeneratingUnit.getNuclearGeneratingUnitId(), "CreateNuclearGeneratingUnitCommand identifier should be null" );
	}

	/**
	 * handles update validation for a NuclearGeneratingUnit
	 */
	public void validate( UpdateNuclearGeneratingUnitCommand nuclearGeneratingUnit ) throws Exception {
		Assert.notNull( nuclearGeneratingUnit, "UpdateNuclearGeneratingUnitCommand should not be null" );
		Assert.notNull( nuclearGeneratingUnit.getNuclearGeneratingUnitId(), "UpdateNuclearGeneratingUnitCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a NuclearGeneratingUnit
	 */
    public void validate( DeleteNuclearGeneratingUnitCommand nuclearGeneratingUnit ) throws Exception {
		Assert.notNull( nuclearGeneratingUnit, "{commandAlias} should not be null" );
		Assert.notNull( nuclearGeneratingUnit.getNuclearGeneratingUnitId(), "DeleteNuclearGeneratingUnitCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a NuclearGeneratingUnit
	 */
	public void validate( NuclearGeneratingUnitFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "NuclearGeneratingUnitFetchOneSummary should not be null" );
		Assert.notNull( summary.getNuclearGeneratingUnitId(), "NuclearGeneratingUnitFetchOneSummary identifier should not be null" );
	}



}
