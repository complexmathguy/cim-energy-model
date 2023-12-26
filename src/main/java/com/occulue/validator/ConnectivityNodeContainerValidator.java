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

public class ConnectivityNodeContainerValidator {
		
	/**
	 * default constructor
	 */
	protected ConnectivityNodeContainerValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ConnectivityNodeContainerValidator getInstance() {
		return new ConnectivityNodeContainerValidator();
	}
		
	/**
	 * handles creation validation for a ConnectivityNodeContainer
	 */
	public void validate( CreateConnectivityNodeContainerCommand connectivityNodeContainer )throws Exception {
		Assert.notNull( connectivityNodeContainer, "CreateConnectivityNodeContainerCommand should not be null" );
//		Assert.isNull( connectivityNodeContainer.getConnectivityNodeContainerId(), "CreateConnectivityNodeContainerCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ConnectivityNodeContainer
	 */
	public void validate( UpdateConnectivityNodeContainerCommand connectivityNodeContainer ) throws Exception {
		Assert.notNull( connectivityNodeContainer, "UpdateConnectivityNodeContainerCommand should not be null" );
		Assert.notNull( connectivityNodeContainer.getConnectivityNodeContainerId(), "UpdateConnectivityNodeContainerCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ConnectivityNodeContainer
	 */
    public void validate( DeleteConnectivityNodeContainerCommand connectivityNodeContainer ) throws Exception {
		Assert.notNull( connectivityNodeContainer, "{commandAlias} should not be null" );
		Assert.notNull( connectivityNodeContainer.getConnectivityNodeContainerId(), "DeleteConnectivityNodeContainerCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ConnectivityNodeContainer
	 */
	public void validate( ConnectivityNodeContainerFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ConnectivityNodeContainerFetchOneSummary should not be null" );
		Assert.notNull( summary.getConnectivityNodeContainerId(), "ConnectivityNodeContainerFetchOneSummary identifier should not be null" );
	}



}
