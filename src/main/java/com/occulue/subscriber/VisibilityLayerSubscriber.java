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
 * Subscriber for VisibilityLayer related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("visibilityLayer-subscriber")
public class VisibilityLayerSubscriber extends BaseSubscriber {

	public VisibilityLayerSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<VisibilityLayer>, VisibilityLayer> visibilityLayerSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllVisibilityLayerQuery(), 
                		ResponseTypes.multipleInstancesOf(VisibilityLayer.class),
                		ResponseTypes.instanceOf(VisibilityLayer.class));
    }

    public SubscriptionQueryResult<VisibilityLayer, VisibilityLayer> visibilityLayerSubscribe(@DestinationVariable UUID visibilityLayerId) {
        return queryGateway
                .subscriptionQuery(new FindVisibilityLayerQuery(new LoadVisibilityLayerFilter(visibilityLayerId)), 
                		ResponseTypes.instanceOf(VisibilityLayer.class),
                		ResponseTypes.instanceOf(VisibilityLayer.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

