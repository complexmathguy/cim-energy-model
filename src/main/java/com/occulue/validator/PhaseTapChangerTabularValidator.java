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

public class PhaseTapChangerTabularValidator {
		
	/**
	 * default constructor
	 */
	protected PhaseTapChangerTabularValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public PhaseTapChangerTabularValidator getInstance() {
		return new PhaseTapChangerTabularValidator();
	}
		
	/**
	 * handles creation validation for a PhaseTapChangerTabular
	 */
	public void validate( CreatePhaseTapChangerTabularCommand phaseTapChangerTabular )throws Exception {
		Assert.notNull( phaseTapChangerTabular, "CreatePhaseTapChangerTabularCommand should not be null" );
//		Assert.isNull( phaseTapChangerTabular.getPhaseTapChangerTabularId(), "CreatePhaseTapChangerTabularCommand identifier should be null" );
	}

	/**
	 * handles update validation for a PhaseTapChangerTabular
	 */
	public void validate( UpdatePhaseTapChangerTabularCommand phaseTapChangerTabular ) throws Exception {
		Assert.notNull( phaseTapChangerTabular, "UpdatePhaseTapChangerTabularCommand should not be null" );
		Assert.notNull( phaseTapChangerTabular.getPhaseTapChangerTabularId(), "UpdatePhaseTapChangerTabularCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a PhaseTapChangerTabular
	 */
    public void validate( DeletePhaseTapChangerTabularCommand phaseTapChangerTabular ) throws Exception {
		Assert.notNull( phaseTapChangerTabular, "{commandAlias} should not be null" );
		Assert.notNull( phaseTapChangerTabular.getPhaseTapChangerTabularId(), "DeletePhaseTapChangerTabularCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a PhaseTapChangerTabular
	 */
	public void validate( PhaseTapChangerTabularFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "PhaseTapChangerTabularFetchOneSummary should not be null" );
		Assert.notNull( summary.getPhaseTapChangerTabularId(), "PhaseTapChangerTabularFetchOneSummary identifier should not be null" );
	}



}
