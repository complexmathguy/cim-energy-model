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

public class TapChangerTablePointValidator {
		
	/**
	 * default constructor
	 */
	protected TapChangerTablePointValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public TapChangerTablePointValidator getInstance() {
		return new TapChangerTablePointValidator();
	}
		
	/**
	 * handles creation validation for a TapChangerTablePoint
	 */
	public void validate( CreateTapChangerTablePointCommand tapChangerTablePoint )throws Exception {
		Assert.notNull( tapChangerTablePoint, "CreateTapChangerTablePointCommand should not be null" );
//		Assert.isNull( tapChangerTablePoint.getTapChangerTablePointId(), "CreateTapChangerTablePointCommand identifier should be null" );
	}

	/**
	 * handles update validation for a TapChangerTablePoint
	 */
	public void validate( UpdateTapChangerTablePointCommand tapChangerTablePoint ) throws Exception {
		Assert.notNull( tapChangerTablePoint, "UpdateTapChangerTablePointCommand should not be null" );
		Assert.notNull( tapChangerTablePoint.getTapChangerTablePointId(), "UpdateTapChangerTablePointCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a TapChangerTablePoint
	 */
    public void validate( DeleteTapChangerTablePointCommand tapChangerTablePoint ) throws Exception {
		Assert.notNull( tapChangerTablePoint, "{commandAlias} should not be null" );
		Assert.notNull( tapChangerTablePoint.getTapChangerTablePointId(), "DeleteTapChangerTablePointCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a TapChangerTablePoint
	 */
	public void validate( TapChangerTablePointFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "TapChangerTablePointFetchOneSummary should not be null" );
		Assert.notNull( summary.getTapChangerTablePointId(), "TapChangerTablePointFetchOneSummary identifier should not be null" );
	}



}
