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
 * Subscriber for SvInjection related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("svInjection-subscriber")
public class SvInjectionSubscriber extends BaseSubscriber {

	public SvInjectionSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<SvInjection>, SvInjection> svInjectionSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllSvInjectionQuery(), 
                		ResponseTypes.multipleInstancesOf(SvInjection.class),
                		ResponseTypes.instanceOf(SvInjection.class));
    }

    public SubscriptionQueryResult<SvInjection, SvInjection> svInjectionSubscribe(@DestinationVariable UUID svInjectionId) {
        return queryGateway
                .subscriptionQuery(new FindSvInjectionQuery(new LoadSvInjectionFilter(svInjectionId)), 
                		ResponseTypes.instanceOf(SvInjection.class),
                		ResponseTypes.instanceOf(SvInjection.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

