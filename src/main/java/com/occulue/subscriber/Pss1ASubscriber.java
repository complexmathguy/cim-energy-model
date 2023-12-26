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
 * Subscriber for Pss1A related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("pss1A-subscriber")
public class Pss1ASubscriber extends BaseSubscriber {

	public Pss1ASubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<Pss1A>, Pss1A> pss1ASubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllPss1AQuery(), 
                		ResponseTypes.multipleInstancesOf(Pss1A.class),
                		ResponseTypes.instanceOf(Pss1A.class));
    }

    public SubscriptionQueryResult<Pss1A, Pss1A> pss1ASubscribe(@DestinationVariable UUID pss1AId) {
        return queryGateway
                .subscriptionQuery(new FindPss1AQuery(new LoadPss1AFilter(pss1AId)), 
                		ResponseTypes.instanceOf(Pss1A.class),
                		ResponseTypes.instanceOf(Pss1A.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

