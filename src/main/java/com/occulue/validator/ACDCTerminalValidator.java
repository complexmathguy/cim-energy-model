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

public class ACDCTerminalValidator {
		
	/**
	 * default constructor
	 */
	protected ACDCTerminalValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ACDCTerminalValidator getInstance() {
		return new ACDCTerminalValidator();
	}
		
	/**
	 * handles creation validation for a ACDCTerminal
	 */
	public void validate( CreateACDCTerminalCommand aCDCTerminal )throws Exception {
		Assert.notNull( aCDCTerminal, "CreateACDCTerminalCommand should not be null" );
//		Assert.isNull( aCDCTerminal.getACDCTerminalId(), "CreateACDCTerminalCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ACDCTerminal
	 */
	public void validate( UpdateACDCTerminalCommand aCDCTerminal ) throws Exception {
		Assert.notNull( aCDCTerminal, "UpdateACDCTerminalCommand should not be null" );
		Assert.notNull( aCDCTerminal.getACDCTerminalId(), "UpdateACDCTerminalCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ACDCTerminal
	 */
    public void validate( DeleteACDCTerminalCommand aCDCTerminal ) throws Exception {
		Assert.notNull( aCDCTerminal, "{commandAlias} should not be null" );
		Assert.notNull( aCDCTerminal.getACDCTerminalId(), "DeleteACDCTerminalCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ACDCTerminal
	 */
	public void validate( ACDCTerminalFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ACDCTerminalFetchOneSummary should not be null" );
		Assert.notNull( summary.getACDCTerminalId(), "ACDCTerminalFetchOneSummary identifier should not be null" );
	}



}
