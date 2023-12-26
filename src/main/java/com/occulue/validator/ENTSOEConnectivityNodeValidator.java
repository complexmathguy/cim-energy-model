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

public class ENTSOEConnectivityNodeValidator {
		
	/**
	 * default constructor
	 */
	protected ENTSOEConnectivityNodeValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public ENTSOEConnectivityNodeValidator getInstance() {
		return new ENTSOEConnectivityNodeValidator();
	}
		
	/**
	 * handles creation validation for a ENTSOEConnectivityNode
	 */
	public void validate( CreateENTSOEConnectivityNodeCommand eNTSOEConnectivityNode )throws Exception {
		Assert.notNull( eNTSOEConnectivityNode, "CreateENTSOEConnectivityNodeCommand should not be null" );
//		Assert.isNull( eNTSOEConnectivityNode.getENTSOEConnectivityNodeId(), "CreateENTSOEConnectivityNodeCommand identifier should be null" );
	}

	/**
	 * handles update validation for a ENTSOEConnectivityNode
	 */
	public void validate( UpdateENTSOEConnectivityNodeCommand eNTSOEConnectivityNode ) throws Exception {
		Assert.notNull( eNTSOEConnectivityNode, "UpdateENTSOEConnectivityNodeCommand should not be null" );
		Assert.notNull( eNTSOEConnectivityNode.getENTSOEConnectivityNodeId(), "UpdateENTSOEConnectivityNodeCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a ENTSOEConnectivityNode
	 */
    public void validate( DeleteENTSOEConnectivityNodeCommand eNTSOEConnectivityNode ) throws Exception {
		Assert.notNull( eNTSOEConnectivityNode, "{commandAlias} should not be null" );
		Assert.notNull( eNTSOEConnectivityNode.getENTSOEConnectivityNodeId(), "DeleteENTSOEConnectivityNodeCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a ENTSOEConnectivityNode
	 */
	public void validate( ENTSOEConnectivityNodeFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "ENTSOEConnectivityNodeFetchOneSummary should not be null" );
		Assert.notNull( summary.getENTSOEConnectivityNodeId(), "ENTSOEConnectivityNodeFetchOneSummary identifier should not be null" );
	}



}
