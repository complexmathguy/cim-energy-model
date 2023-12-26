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
 * Subscriber for PositionPoint related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("positionPoint-subscriber")
public class PositionPointSubscriber extends BaseSubscriber {

	public PositionPointSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<PositionPoint>, PositionPoint> positionPointSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllPositionPointQuery(), 
                		ResponseTypes.multipleInstancesOf(PositionPoint.class),
                		ResponseTypes.instanceOf(PositionPoint.class));
    }

    public SubscriptionQueryResult<PositionPoint, PositionPoint> positionPointSubscribe(@DestinationVariable UUID positionPointId) {
        return queryGateway
                .subscriptionQuery(new FindPositionPointQuery(new LoadPositionPointFilter(positionPointId)), 
                		ResponseTypes.instanceOf(PositionPoint.class),
                		ResponseTypes.instanceOf(PositionPoint.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

