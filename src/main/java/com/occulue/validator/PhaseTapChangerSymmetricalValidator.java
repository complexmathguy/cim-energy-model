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

public class PhaseTapChangerSymmetricalValidator {
		
	/**
	 * default constructor
	 */
	protected PhaseTapChangerSymmetricalValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public PhaseTapChangerSymmetricalValidator getInstance() {
		return new PhaseTapChangerSymmetricalValidator();
	}
		
	/**
	 * handles creation validation for a PhaseTapChangerSymmetrical
	 */
	public void validate( CreatePhaseTapChangerSymmetricalCommand phaseTapChangerSymmetrical )throws Exception {
		Assert.notNull( phaseTapChangerSymmetrical, "CreatePhaseTapChangerSymmetricalCommand should not be null" );
//		Assert.isNull( phaseTapChangerSymmetrical.getPhaseTapChangerSymmetricalId(), "CreatePhaseTapChangerSymmetricalCommand identifier should be null" );
	}

	/**
	 * handles update validation for a PhaseTapChangerSymmetrical
	 */
	public void validate( UpdatePhaseTapChangerSymmetricalCommand phaseTapChangerSymmetrical ) throws Exception {
		Assert.notNull( phaseTapChangerSymmetrical, "UpdatePhaseTapChangerSymmetricalCommand should not be null" );
		Assert.notNull( phaseTapChangerSymmetrical.getPhaseTapChangerSymmetricalId(), "UpdatePhaseTapChangerSymmetricalCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a PhaseTapChangerSymmetrical
	 */
    public void validate( DeletePhaseTapChangerSymmetricalCommand phaseTapChangerSymmetrical ) throws Exception {
		Assert.notNull( phaseTapChangerSymmetrical, "{commandAlias} should not be null" );
		Assert.notNull( phaseTapChangerSymmetrical.getPhaseTapChangerSymmetricalId(), "DeletePhaseTapChangerSymmetricalCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a PhaseTapChangerSymmetrical
	 */
	public void validate( PhaseTapChangerSymmetricalFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "PhaseTapChangerSymmetricalFetchOneSummary should not be null" );
		Assert.notNull( summary.getPhaseTapChangerSymmetricalId(), "PhaseTapChangerSymmetricalFetchOneSummary identifier should not be null" );
	}



}
