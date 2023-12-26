/*******************************************************************************
  Turnstone Biologics Confidential
  
  2018 Turnstone Biologics
  All Rights Reserved.
  
  This file is subject to the terms and conditions defined in
  file 'license.txt', which is part of this source code package.
   
  Contributors :
        Turnstone Biologics - General Release
 ******************************************************************************/
package com.occulue.subscriber;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.SubscriptionQueryResult;
import org.axonframework.messaging.responsetypes.ResponseTypes;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.stereotype.Component;


import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;

/**
 * Subscriber for StateVariablesVersion related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("stateVariablesVersion-subscriber")
public class StateVariablesVersionSubscriber extends BaseSubscriber {

	public StateVariablesVersionSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<StateVariablesVersion>, StateVariablesVersion> stateVariablesVersionSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllStateVariablesVersionQuery(), 
                		ResponseTypes.multipleInstancesOf(StateVariablesVersion.class),
                		ResponseTypes.instanceOf(StateVariablesVersion.class));
    }

    public SubscriptionQueryResult<StateVariablesVersion, StateVariablesVersion> stateVariablesVersionSubscribe(@DestinationVariable UUID stateVariablesVersionId) {
        return queryGateway
                .subscriptionQuery(new FindStateVariablesVersionQuery(new LoadStateVariablesVersionFilter(stateVariablesVersionId)), 
                		ResponseTypes.instanceOf(StateVariablesVersion.class),
                		ResponseTypes.instanceOf(StateVariablesVersion.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

