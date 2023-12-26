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

public class PhaseTapChangerAsymmetricalValidator {
		
	/**
	 * default constructor
	 */
	protected PhaseTapChangerAsymmetricalValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public PhaseTapChangerAsymmetricalValidator getInstance() {
		return new PhaseTapChangerAsymmetricalValidator();
	}
		
	/**
	 * handles creation validation for a PhaseTapChangerAsymmetrical
	 */
	public void validate( CreatePhaseTapChangerAsymmetricalCommand phaseTapChangerAsymmetrical )throws Exception {
		Assert.notNull( phaseTapChangerAsymmetrical, "CreatePhaseTapChangerAsymmetricalCommand should not be null" );
//		Assert.isNull( phaseTapChangerAsymmetrical.getPhaseTapChangerAsymmetricalId(), "CreatePhaseTapChangerAsymmetricalCommand identifier should be null" );
	}

	/**
	 * handles update validation for a PhaseTapChangerAsymmetrical
	 */
	public void validate( UpdatePhaseTapChangerAsymmetricalCommand phaseTapChangerAsymmetrical ) throws Exception {
		Assert.notNull( phaseTapChangerAsymmetrical, "UpdatePhaseTapChangerAsymmetricalCommand should not be null" );
		Assert.notNull( phaseTapChangerAsymmetrical.getPhaseTapChangerAsymmetricalId(), "UpdatePhaseTapChangerAsymmetricalCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a PhaseTapChangerAsymmetrical
	 */
    public void validate( DeletePhaseTapChangerAsymmetricalCommand phaseTapChangerAsymmetrical ) throws Exception {
		Assert.notNull( phaseTapChangerAsymmetrical, "{commandAlias} should not be null" );
		Assert.notNull( phaseTapChangerAsymmetrical.getPhaseTapChangerAsymmetricalId(), "DeletePhaseTapChangerAsymmetricalCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a PhaseTapChangerAsymmetrical
	 */
	public void validate( PhaseTapChangerAsymmetricalFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "PhaseTapChangerAsymmetricalFetchOneSummary should not be null" );
		Assert.notNull( summary.getPhaseTapChangerAsymmetricalId(), "PhaseTapChangerAsymmetricalFetchOneSummary identifier should not be null" );
	}



}
