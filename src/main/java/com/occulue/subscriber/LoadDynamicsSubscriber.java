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
 * Subscriber for LoadDynamics related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("loadDynamics-subscriber")
public class LoadDynamicsSubscriber extends BaseSubscriber {

	public LoadDynamicsSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<LoadDynamics>, LoadDynamics> loadDynamicsSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllLoadDynamicsQuery(), 
                		ResponseTypes.multipleInstancesOf(LoadDynamics.class),
                		ResponseTypes.instanceOf(LoadDynamics.class));
    }

    public SubscriptionQueryResult<LoadDynamics, LoadDynamics> loadDynamicsSubscribe(@DestinationVariable UUID loadDynamicsId) {
        return queryGateway
                .subscriptionQuery(new FindLoadDynamicsQuery(new LoadLoadDynamicsFilter(loadDynamicsId)), 
                		ResponseTypes.instanceOf(LoadDynamics.class),
                		ResponseTypes.instanceOf(LoadDynamics.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

