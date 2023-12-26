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
 * Subscriber for BusNameMarker related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("busNameMarker-subscriber")
public class BusNameMarkerSubscriber extends BaseSubscriber {

	public BusNameMarkerSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<BusNameMarker>, BusNameMarker> busNameMarkerSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllBusNameMarkerQuery(), 
                		ResponseTypes.multipleInstancesOf(BusNameMarker.class),
                		ResponseTypes.instanceOf(BusNameMarker.class));
    }

    public SubscriptionQueryResult<BusNameMarker, BusNameMarker> busNameMarkerSubscribe(@DestinationVariable UUID busNameMarkerId) {
        return queryGateway
                .subscriptionQuery(new FindBusNameMarkerQuery(new LoadBusNameMarkerFilter(busNameMarkerId)), 
                		ResponseTypes.instanceOf(BusNameMarker.class),
                		ResponseTypes.instanceOf(BusNameMarker.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

