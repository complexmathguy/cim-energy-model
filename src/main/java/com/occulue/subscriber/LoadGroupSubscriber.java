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
 * Subscriber for LoadGroup related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("loadGroup-subscriber")
public class LoadGroupSubscriber extends BaseSubscriber {

	public LoadGroupSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<LoadGroup>, LoadGroup> loadGroupSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllLoadGroupQuery(), 
                		ResponseTypes.multipleInstancesOf(LoadGroup.class),
                		ResponseTypes.instanceOf(LoadGroup.class));
    }

    public SubscriptionQueryResult<LoadGroup, LoadGroup> loadGroupSubscribe(@DestinationVariable UUID loadGroupId) {
        return queryGateway
                .subscriptionQuery(new FindLoadGroupQuery(new LoadLoadGroupFilter(loadGroupId)), 
                		ResponseTypes.instanceOf(LoadGroup.class),
                		ResponseTypes.instanceOf(LoadGroup.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

