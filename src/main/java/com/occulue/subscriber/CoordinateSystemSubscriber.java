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
 * Subscriber for CoordinateSystem related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("coordinateSystem-subscriber")
public class CoordinateSystemSubscriber extends BaseSubscriber {

	public CoordinateSystemSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<CoordinateSystem>, CoordinateSystem> coordinateSystemSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllCoordinateSystemQuery(), 
                		ResponseTypes.multipleInstancesOf(CoordinateSystem.class),
                		ResponseTypes.instanceOf(CoordinateSystem.class));
    }

    public SubscriptionQueryResult<CoordinateSystem, CoordinateSystem> coordinateSystemSubscribe(@DestinationVariable UUID coordinateSystemId) {
        return queryGateway
                .subscriptionQuery(new FindCoordinateSystemQuery(new LoadCoordinateSystemFilter(coordinateSystemId)), 
                		ResponseTypes.instanceOf(CoordinateSystem.class),
                		ResponseTypes.instanceOf(CoordinateSystem.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

