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
 * Subscriber for GroundDisconnector related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("groundDisconnector-subscriber")
public class GroundDisconnectorSubscriber extends BaseSubscriber {

	public GroundDisconnectorSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<GroundDisconnector>, GroundDisconnector> groundDisconnectorSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllGroundDisconnectorQuery(), 
                		ResponseTypes.multipleInstancesOf(GroundDisconnector.class),
                		ResponseTypes.instanceOf(GroundDisconnector.class));
    }

    public SubscriptionQueryResult<GroundDisconnector, GroundDisconnector> groundDisconnectorSubscribe(@DestinationVariable UUID groundDisconnectorId) {
        return queryGateway
                .subscriptionQuery(new FindGroundDisconnectorQuery(new LoadGroundDisconnectorFilter(groundDisconnectorId)), 
                		ResponseTypes.instanceOf(GroundDisconnector.class),
                		ResponseTypes.instanceOf(GroundDisconnector.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

