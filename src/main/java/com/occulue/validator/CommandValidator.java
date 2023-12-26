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

public class CommandValidator {
		
	/**
	 * default constructor
	 */
	protected CommandValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public CommandValidator getInstance() {
		return new CommandValidator();
	}
		
	/**
	 * handles creation validation for a Command
	 */
	public void validate( CreateCommandCommand command )throws Exception {
		Assert.notNull( command, "CreateCommandCommand should not be null" );
//		Assert.isNull( command.getCommandId(), "CreateCommandCommand identifier should be null" );
	}

	/**
	 * handles update validation for a Command
	 */
	public void validate( UpdateCommandCommand command ) throws Exception {
		Assert.notNull( command, "UpdateCommandCommand should not be null" );
		Assert.notNull( command.getCommandId(), "UpdateCommandCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a Command
	 */
    public void validate( DeleteCommandCommand command ) throws Exception {
		Assert.notNull( command, "{commandAlias} should not be null" );
		Assert.notNull( command.getCommandId(), "DeleteCommandCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a Command
	 */
	public void validate( CommandFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "CommandFetchOneSummary should not be null" );
		Assert.notNull( summary.getCommandId(), "CommandFetchOneSummary identifier should not be null" );
	}



}
