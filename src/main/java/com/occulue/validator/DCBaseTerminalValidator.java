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

public class DCBaseTerminalValidator {
		
	/**
	 * default constructor
	 */
	protected DCBaseTerminalValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public DCBaseTerminalValidator getInstance() {
		return new DCBaseTerminalValidator();
	}
		
	/**
	 * handles creation validation for a DCBaseTerminal
	 */
	public void validate( CreateDCBaseTerminalCommand dCBaseTerminal )throws Exception {
		Assert.notNull( dCBaseTerminal, "CreateDCBaseTerminalCommand should not be null" );
//		Assert.isNull( dCBaseTerminal.getDCBaseTerminalId(), "CreateDCBaseTerminalCommand identifier should be null" );
	}

	/**
	 * handles update validation for a DCBaseTerminal
	 */
	public void validate( UpdateDCBaseTerminalCommand dCBaseTerminal ) throws Exception {
		Assert.notNull( dCBaseTerminal, "UpdateDCBaseTerminalCommand should not be null" );
		Assert.notNull( dCBaseTerminal.getDCBaseTerminalId(), "UpdateDCBaseTerminalCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a DCBaseTerminal
	 */
    public void validate( DeleteDCBaseTerminalCommand dCBaseTerminal ) throws Exception {
		Assert.notNull( dCBaseTerminal, "{commandAlias} should not be null" );
		Assert.notNull( dCBaseTerminal.getDCBaseTerminalId(), "DeleteDCBaseTerminalCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a DCBaseTerminal
	 */
	public void validate( DCBaseTerminalFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "DCBaseTerminalFetchOneSummary should not be null" );
		Assert.notNull( summary.getDCBaseTerminalId(), "DCBaseTerminalFetchOneSummary identifier should not be null" );
	}



}
