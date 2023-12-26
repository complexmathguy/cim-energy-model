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

public class DCLineValidator {
		
	/**
	 * default constructor
	 */
	protected DCLineValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public DCLineValidator getInstance() {
		return new DCLineValidator();
	}
		
	/**
	 * handles creation validation for a DCLine
	 */
	public void validate( CreateDCLineCommand dCLine )throws Exception {
		Assert.notNull( dCLine, "CreateDCLineCommand should not be null" );
//		Assert.isNull( dCLine.getDCLineId(), "CreateDCLineCommand identifier should be null" );
	}

	/**
	 * handles update validation for a DCLine
	 */
	public void validate( UpdateDCLineCommand dCLine ) throws Exception {
		Assert.notNull( dCLine, "UpdateDCLineCommand should not be null" );
		Assert.notNull( dCLine.getDCLineId(), "UpdateDCLineCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a DCLine
	 */
    public void validate( DeleteDCLineCommand dCLine ) throws Exception {
		Assert.notNull( dCLine, "{commandAlias} should not be null" );
		Assert.notNull( dCLine.getDCLineId(), "DeleteDCLineCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a DCLine
	 */
	public void validate( DCLineFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "DCLineFetchOneSummary should not be null" );
		Assert.notNull( summary.getDCLineId(), "DCLineFetchOneSummary identifier should not be null" );
	}



}
