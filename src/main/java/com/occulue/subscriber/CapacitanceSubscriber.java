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
 * Subscriber for Capacitance related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("capacitance-subscriber")
public class CapacitanceSubscriber extends BaseSubscriber {

	public CapacitanceSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<Capacitance>, Capacitance> capacitanceSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllCapacitanceQuery(), 
                		ResponseTypes.multipleInstancesOf(Capacitance.class),
                		ResponseTypes.instanceOf(Capacitance.class));
    }

    public SubscriptionQueryResult<Capacitance, Capacitance> capacitanceSubscribe(@DestinationVariable UUID capacitanceId) {
        return queryGateway
                .subscriptionQuery(new FindCapacitanceQuery(new LoadCapacitanceFilter(capacitanceId)), 
                		ResponseTypes.instanceOf(Capacitance.class),
                		ResponseTypes.instanceOf(Capacitance.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

