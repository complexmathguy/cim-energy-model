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
 * Subscriber for LoadArea related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("loadArea-subscriber")
public class LoadAreaSubscriber extends BaseSubscriber {

	public LoadAreaSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<LoadArea>, LoadArea> loadAreaSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllLoadAreaQuery(), 
                		ResponseTypes.multipleInstancesOf(LoadArea.class),
                		ResponseTypes.instanceOf(LoadArea.class));
    }

    public SubscriptionQueryResult<LoadArea, LoadArea> loadAreaSubscribe(@DestinationVariable UUID loadAreaId) {
        return queryGateway
                .subscriptionQuery(new FindLoadAreaQuery(new LoadLoadAreaFilter(loadAreaId)), 
                		ResponseTypes.instanceOf(LoadArea.class),
                		ResponseTypes.instanceOf(LoadArea.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

