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
 * Subscriber for BoundaryExtensions related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("boundaryExtensions-subscriber")
public class BoundaryExtensionsSubscriber extends BaseSubscriber {

	public BoundaryExtensionsSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<BoundaryExtensions>, BoundaryExtensions> boundaryExtensionsSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllBoundaryExtensionsQuery(), 
                		ResponseTypes.multipleInstancesOf(BoundaryExtensions.class),
                		ResponseTypes.instanceOf(BoundaryExtensions.class));
    }

    public SubscriptionQueryResult<BoundaryExtensions, BoundaryExtensions> boundaryExtensionsSubscribe(@DestinationVariable UUID boundaryExtensionsId) {
        return queryGateway
                .subscriptionQuery(new FindBoundaryExtensionsQuery(new LoadBoundaryExtensionsFilter(boundaryExtensionsId)), 
                		ResponseTypes.instanceOf(BoundaryExtensions.class),
                		ResponseTypes.instanceOf(BoundaryExtensions.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

