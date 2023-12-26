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
 * Subscriber for Seconds related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("seconds-subscriber")
public class SecondsSubscriber extends BaseSubscriber {

	public SecondsSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<Seconds>, Seconds> secondsSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllSecondsQuery(), 
                		ResponseTypes.multipleInstancesOf(Seconds.class),
                		ResponseTypes.instanceOf(Seconds.class));
    }

    public SubscriptionQueryResult<Seconds, Seconds> secondsSubscribe(@DestinationVariable UUID secondsId) {
        return queryGateway
                .subscriptionQuery(new FindSecondsQuery(new LoadSecondsFilter(secondsId)), 
                		ResponseTypes.instanceOf(Seconds.class),
                		ResponseTypes.instanceOf(Seconds.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

