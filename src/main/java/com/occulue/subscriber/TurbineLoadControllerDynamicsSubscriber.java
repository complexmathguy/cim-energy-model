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
 * Subscriber for TurbineLoadControllerDynamics related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("turbineLoadControllerDynamics-subscriber")
public class TurbineLoadControllerDynamicsSubscriber extends BaseSubscriber {

	public TurbineLoadControllerDynamicsSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<TurbineLoadControllerDynamics>, TurbineLoadControllerDynamics> turbineLoadControllerDynamicsSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllTurbineLoadControllerDynamicsQuery(), 
                		ResponseTypes.multipleInstancesOf(TurbineLoadControllerDynamics.class),
                		ResponseTypes.instanceOf(TurbineLoadControllerDynamics.class));
    }

    public SubscriptionQueryResult<TurbineLoadControllerDynamics, TurbineLoadControllerDynamics> turbineLoadControllerDynamicsSubscribe(@DestinationVariable UUID turbineLoadControllerDynamicsId) {
        return queryGateway
                .subscriptionQuery(new FindTurbineLoadControllerDynamicsQuery(new LoadTurbineLoadControllerDynamicsFilter(turbineLoadControllerDynamicsId)), 
                		ResponseTypes.instanceOf(TurbineLoadControllerDynamics.class),
                		ResponseTypes.instanceOf(TurbineLoadControllerDynamics.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

