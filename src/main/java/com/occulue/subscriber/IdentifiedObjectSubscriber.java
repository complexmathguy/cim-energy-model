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
 * Subscriber for IdentifiedObject related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("identifiedObject-subscriber")
public class IdentifiedObjectSubscriber extends BaseSubscriber {

	public IdentifiedObjectSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<IdentifiedObject>, IdentifiedObject> identifiedObjectSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllIdentifiedObjectQuery(), 
                		ResponseTypes.multipleInstancesOf(IdentifiedObject.class),
                		ResponseTypes.instanceOf(IdentifiedObject.class));
    }

    public SubscriptionQueryResult<IdentifiedObject, IdentifiedObject> identifiedObjectSubscribe(@DestinationVariable UUID identifiedObjectId) {
        return queryGateway
                .subscriptionQuery(new FindIdentifiedObjectQuery(new LoadIdentifiedObjectFilter(identifiedObjectId)), 
                		ResponseTypes.instanceOf(IdentifiedObject.class),
                		ResponseTypes.instanceOf(IdentifiedObject.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

