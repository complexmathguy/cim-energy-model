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
 * Subscriber for Dynamicsmodel related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("dynamicsmodel-subscriber")
public class DynamicsmodelSubscriber extends BaseSubscriber {

	public DynamicsmodelSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<Dynamicsmodel>, Dynamicsmodel> dynamicsmodelSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllDynamicsmodelQuery(), 
                		ResponseTypes.multipleInstancesOf(Dynamicsmodel.class),
                		ResponseTypes.instanceOf(Dynamicsmodel.class));
    }

    public SubscriptionQueryResult<Dynamicsmodel, Dynamicsmodel> dynamicsmodelSubscribe(@DestinationVariable UUID dynamicsmodelId) {
        return queryGateway
                .subscriptionQuery(new FindDynamicsmodelQuery(new LoadDynamicsmodelFilter(dynamicsmodelId)), 
                		ResponseTypes.instanceOf(Dynamicsmodel.class),
                		ResponseTypes.instanceOf(Dynamicsmodel.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

