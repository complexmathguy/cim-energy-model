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

public class PhaseTapChangerNonLinearValidator {
		
	/**
	 * default constructor
	 */
	protected PhaseTapChangerNonLinearValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public PhaseTapChangerNonLinearValidator getInstance() {
		return new PhaseTapChangerNonLinearValidator();
	}
		
	/**
	 * handles creation validation for a PhaseTapChangerNonLinear
	 */
	public void validate( CreatePhaseTapChangerNonLinearCommand phaseTapChangerNonLinear )throws Exception {
		Assert.notNull( phaseTapChangerNonLinear, "CreatePhaseTapChangerNonLinearCommand should not be null" );
//		Assert.isNull( phaseTapChangerNonLinear.getPhaseTapChangerNonLinearId(), "CreatePhaseTapChangerNonLinearCommand identifier should be null" );
	}

	/**
	 * handles update validation for a PhaseTapChangerNonLinear
	 */
	public void validate( UpdatePhaseTapChangerNonLinearCommand phaseTapChangerNonLinear ) throws Exception {
		Assert.notNull( phaseTapChangerNonLinear, "UpdatePhaseTapChangerNonLinearCommand should not be null" );
		Assert.notNull( phaseTapChangerNonLinear.getPhaseTapChangerNonLinearId(), "UpdatePhaseTapChangerNonLinearCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a PhaseTapChangerNonLinear
	 */
    public void validate( DeletePhaseTapChangerNonLinearCommand phaseTapChangerNonLinear ) throws Exception {
		Assert.notNull( phaseTapChangerNonLinear, "{commandAlias} should not be null" );
		Assert.notNull( phaseTapChangerNonLinear.getPhaseTapChangerNonLinearId(), "DeletePhaseTapChangerNonLinearCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a PhaseTapChangerNonLinear
	 */
	public void validate( PhaseTapChangerNonLinearFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "PhaseTapChangerNonLinearFetchOneSummary should not be null" );
		Assert.notNull( summary.getPhaseTapChangerNonLinearId(), "PhaseTapChangerNonLinearFetchOneSummary identifier should not be null" );
	}



}
