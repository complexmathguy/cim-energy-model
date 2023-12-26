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
 * Subscriber for Location related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("location-subscriber")
public class LocationSubscriber extends BaseSubscriber {

	public LocationSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<Location>, Location> locationSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllLocationQuery(), 
                		ResponseTypes.multipleInstancesOf(Location.class),
                		ResponseTypes.instanceOf(Location.class));
    }

    public SubscriptionQueryResult<Location, Location> locationSubscribe(@DestinationVariable UUID locationId) {
        return queryGateway
                .subscriptionQuery(new FindLocationQuery(new LoadLocationFilter(locationId)), 
                		ResponseTypes.instanceOf(Location.class),
                		ResponseTypes.instanceOf(Location.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

