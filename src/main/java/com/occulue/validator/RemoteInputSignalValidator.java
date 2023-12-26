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

public class RemoteInputSignalValidator {
		
	/**
	 * default constructor
	 */
	protected RemoteInputSignalValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public RemoteInputSignalValidator getInstance() {
		return new RemoteInputSignalValidator();
	}
		
	/**
	 * handles creation validation for a RemoteInputSignal
	 */
	public void validate( CreateRemoteInputSignalCommand remoteInputSignal )throws Exception {
		Assert.notNull( remoteInputSignal, "CreateRemoteInputSignalCommand should not be null" );
//		Assert.isNull( remoteInputSignal.getRemoteInputSignalId(), "CreateRemoteInputSignalCommand identifier should be null" );
	}

	/**
	 * handles update validation for a RemoteInputSignal
	 */
	public void validate( UpdateRemoteInputSignalCommand remoteInputSignal ) throws Exception {
		Assert.notNull( remoteInputSignal, "UpdateRemoteInputSignalCommand should not be null" );
		Assert.notNull( remoteInputSignal.getRemoteInputSignalId(), "UpdateRemoteInputSignalCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a RemoteInputSignal
	 */
    public void validate( DeleteRemoteInputSignalCommand remoteInputSignal ) throws Exception {
		Assert.notNull( remoteInputSignal, "{commandAlias} should not be null" );
		Assert.notNull( remoteInputSignal.getRemoteInputSignalId(), "DeleteRemoteInputSignalCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a RemoteInputSignal
	 */
	public void validate( RemoteInputSignalFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "RemoteInputSignalFetchOneSummary should not be null" );
		Assert.notNull( summary.getRemoteInputSignalId(), "RemoteInputSignalFetchOneSummary identifier should not be null" );
	}



}
