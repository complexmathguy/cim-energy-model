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

public class PhaseTapChangerValidator {
		
	/**
	 * default constructor
	 */
	protected PhaseTapChangerValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public PhaseTapChangerValidator getInstance() {
		return new PhaseTapChangerValidator();
	}
		
	/**
	 * handles creation validation for a PhaseTapChanger
	 */
	public void validate( CreatePhaseTapChangerCommand phaseTapChanger )throws Exception {
		Assert.notNull( phaseTapChanger, "CreatePhaseTapChangerCommand should not be null" );
//		Assert.isNull( phaseTapChanger.getPhaseTapChangerId(), "CreatePhaseTapChangerCommand identifier should be null" );
	}

	/**
	 * handles update validation for a PhaseTapChanger
	 */
	public void validate( UpdatePhaseTapChangerCommand phaseTapChanger ) throws Exception {
		Assert.notNull( phaseTapChanger, "UpdatePhaseTapChangerCommand should not be null" );
		Assert.notNull( phaseTapChanger.getPhaseTapChangerId(), "UpdatePhaseTapChangerCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a PhaseTapChanger
	 */
    public void validate( DeletePhaseTapChangerCommand phaseTapChanger ) throws Exception {
		Assert.notNull( phaseTapChanger, "{commandAlias} should not be null" );
		Assert.notNull( phaseTapChanger.getPhaseTapChangerId(), "DeletePhaseTapChangerCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a PhaseTapChanger
	 */
	public void validate( PhaseTapChangerFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "PhaseTapChangerFetchOneSummary should not be null" );
		Assert.notNull( summary.getPhaseTapChangerId(), "PhaseTapChangerFetchOneSummary identifier should not be null" );
	}



}
