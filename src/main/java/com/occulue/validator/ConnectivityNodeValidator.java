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

public class ConnectivityNodeValidator {
		
	/**
	 * default constructor
	 */
	protected ConnectivityNodeValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ConnectivityNodeValidator getInstance() {
		return new ConnectivityNodeValidator();
	}
		
	/**
	 * handles creation validation for a ConnectivityNode
	 */
	public void validate( CreateConnectivityNodeCommand connectivityNode )throws Exception {
		Assert.notNull( connectivityNode, "CreateConnectivityNodeCommand should not be null" );
//		Assert.isNull( connectivityNode.getConnectivityNodeId(), "CreateConnectivityNodeCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ConnectivityNode
	 */
	public void validate( UpdateConnectivityNodeCommand connectivityNode ) throws Exception {
		Assert.notNull( connectivityNode, "UpdateConnectivityNodeCommand should not be null" );
		Assert.notNull( connectivityNode.getConnectivityNodeId(), "UpdateConnectivityNodeCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ConnectivityNode
	 */
    public void validate( DeleteConnectivityNodeCommand connectivityNode ) throws Exception {
		Assert.notNull( connectivityNode, "{commandAlias} should not be null" );
		Assert.notNull( connectivityNode.getConnectivityNodeId(), "DeleteConnectivityNodeCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ConnectivityNode
	 */
	public void validate( ConnectivityNodeFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ConnectivityNodeFetchOneSummary should not be null" );
		Assert.notNull( summary.getConnectivityNodeId(), "ConnectivityNodeFetchOneSummary identifier should not be null" );
	}



}
