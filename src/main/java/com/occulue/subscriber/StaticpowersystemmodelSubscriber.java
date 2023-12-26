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
 * Subscriber for Staticpowersystemmodel related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("staticpowersystemmodel-subscriber")
public class StaticpowersystemmodelSubscriber extends BaseSubscriber {

	public StaticpowersystemmodelSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<Staticpowersystemmodel>, Staticpowersystemmodel> staticpowersystemmodelSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllStaticpowersystemmodelQuery(), 
                		ResponseTypes.multipleInstancesOf(Staticpowersystemmodel.class),
                		ResponseTypes.instanceOf(Staticpowersystemmodel.class));
    }

    public SubscriptionQueryResult<Staticpowersystemmodel, Staticpowersystemmodel> staticpowersystemmodelSubscribe(@DestinationVariable UUID staticpowersystemmodelId) {
        return queryGateway
                .subscriptionQuery(new FindStaticpowersystemmodelQuery(new LoadStaticpowersystemmodelFilter(staticpowersystemmodelId)), 
                		ResponseTypes.instanceOf(Staticpowersystemmodel.class),
                		ResponseTypes.instanceOf(Staticpowersystemmodel.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

