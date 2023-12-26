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

public class PhaseTapChangerLinearValidator {
		
	/**
	 * default constructor
	 */
	protected PhaseTapChangerLinearValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public PhaseTapChangerLinearValidator getInstance() {
		return new PhaseTapChangerLinearValidator();
	}
		
	/**
	 * handles creation validation for a PhaseTapChangerLinear
	 */
	public void validate( CreatePhaseTapChangerLinearCommand phaseTapChangerLinear )throws Exception {
		Assert.notNull( phaseTapChangerLinear, "CreatePhaseTapChangerLinearCommand should not be null" );
//		Assert.isNull( phaseTapChangerLinear.getPhaseTapChangerLinearId(), "CreatePhaseTapChangerLinearCommand identifier should be null" );
	}

	/**
	 * handles update validation for a PhaseTapChangerLinear
	 */
	public void validate( UpdatePhaseTapChangerLinearCommand phaseTapChangerLinear ) throws Exception {
		Assert.notNull( phaseTapChangerLinear, "UpdatePhaseTapChangerLinearCommand should not be null" );
		Assert.notNull( phaseTapChangerLinear.getPhaseTapChangerLinearId(), "UpdatePhaseTapChangerLinearCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a PhaseTapChangerLinear
	 */
    public void validate( DeletePhaseTapChangerLinearCommand phaseTapChangerLinear ) throws Exception {
		Assert.notNull( phaseTapChangerLinear, "{commandAlias} should not be null" );
		Assert.notNull( phaseTapChangerLinear.getPhaseTapChangerLinearId(), "DeletePhaseTapChangerLinearCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a PhaseTapChangerLinear
	 */
	public void validate( PhaseTapChangerLinearFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "PhaseTapChangerLinearFetchOneSummary should not be null" );
		Assert.notNull( summary.getPhaseTapChangerLinearId(), "PhaseTapChangerLinearFetchOneSummary identifier should not be null" );
	}



}
