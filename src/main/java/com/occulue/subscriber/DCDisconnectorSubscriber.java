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
 * Subscriber for DCDisconnector related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("dCDisconnector-subscriber")
public class DCDisconnectorSubscriber extends BaseSubscriber {

	public DCDisconnectorSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<DCDisconnector>, DCDisconnector> dCDisconnectorSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllDCDisconnectorQuery(), 
                		ResponseTypes.multipleInstancesOf(DCDisconnector.class),
                		ResponseTypes.instanceOf(DCDisconnector.class));
    }

    public SubscriptionQueryResult<DCDisconnector, DCDisconnector> dCDisconnectorSubscribe(@DestinationVariable UUID dCDisconnectorId) {
        return queryGateway
                .subscriptionQuery(new FindDCDisconnectorQuery(new LoadDCDisconnectorFilter(dCDisconnectorId)), 
                		ResponseTypes.instanceOf(DCDisconnector.class),
                		ResponseTypes.instanceOf(DCDisconnector.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

