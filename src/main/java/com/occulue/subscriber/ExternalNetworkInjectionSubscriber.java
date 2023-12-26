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
 * Subscriber for ExternalNetworkInjection related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("externalNetworkInjection-subscriber")
public class ExternalNetworkInjectionSubscriber extends BaseSubscriber {

	public ExternalNetworkInjectionSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ExternalNetworkInjection>, ExternalNetworkInjection> externalNetworkInjectionSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllExternalNetworkInjectionQuery(), 
                		ResponseTypes.multipleInstancesOf(ExternalNetworkInjection.class),
                		ResponseTypes.instanceOf(ExternalNetworkInjection.class));
    }

    public SubscriptionQueryResult<ExternalNetworkInjection, ExternalNetworkInjection> externalNetworkInjectionSubscribe(@DestinationVariable UUID externalNetworkInjectionId) {
        return queryGateway
                .subscriptionQuery(new FindExternalNetworkInjectionQuery(new LoadExternalNetworkInjectionFilter(externalNetworkInjectionId)), 
                		ResponseTypes.instanceOf(ExternalNetworkInjection.class),
                		ResponseTypes.instanceOf(ExternalNetworkInjection.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

