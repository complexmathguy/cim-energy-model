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
 * Subscriber for LoadComposite related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("loadComposite-subscriber")
public class LoadCompositeSubscriber extends BaseSubscriber {

	public LoadCompositeSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<LoadComposite>, LoadComposite> loadCompositeSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllLoadCompositeQuery(), 
                		ResponseTypes.multipleInstancesOf(LoadComposite.class),
                		ResponseTypes.instanceOf(LoadComposite.class));
    }

    public SubscriptionQueryResult<LoadComposite, LoadComposite> loadCompositeSubscribe(@DestinationVariable UUID loadCompositeId) {
        return queryGateway
                .subscriptionQuery(new FindLoadCompositeQuery(new LoadLoadCompositeFilter(loadCompositeId)), 
                		ResponseTypes.instanceOf(LoadComposite.class),
                		ResponseTypes.instanceOf(LoadComposite.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

