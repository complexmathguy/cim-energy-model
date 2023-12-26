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
 * Subscriber for DCBusbar related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("dCBusbar-subscriber")
public class DCBusbarSubscriber extends BaseSubscriber {

	public DCBusbarSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<DCBusbar>, DCBusbar> dCBusbarSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllDCBusbarQuery(), 
                		ResponseTypes.multipleInstancesOf(DCBusbar.class),
                		ResponseTypes.instanceOf(DCBusbar.class));
    }

    public SubscriptionQueryResult<DCBusbar, DCBusbar> dCBusbarSubscribe(@DestinationVariable UUID dCBusbarId) {
        return queryGateway
                .subscriptionQuery(new FindDCBusbarQuery(new LoadDCBusbarFilter(dCBusbarId)), 
                		ResponseTypes.instanceOf(DCBusbar.class),
                		ResponseTypes.instanceOf(DCBusbar.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

