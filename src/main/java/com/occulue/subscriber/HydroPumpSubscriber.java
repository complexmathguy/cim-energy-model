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
 * Subscriber for HydroPump related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("hydroPump-subscriber")
public class HydroPumpSubscriber extends BaseSubscriber {

	public HydroPumpSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<HydroPump>, HydroPump> hydroPumpSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllHydroPumpQuery(), 
                		ResponseTypes.multipleInstancesOf(HydroPump.class),
                		ResponseTypes.instanceOf(HydroPump.class));
    }

    public SubscriptionQueryResult<HydroPump, HydroPump> hydroPumpSubscribe(@DestinationVariable UUID hydroPumpId) {
        return queryGateway
                .subscriptionQuery(new FindHydroPumpQuery(new LoadHydroPumpFilter(hydroPumpId)), 
                		ResponseTypes.instanceOf(HydroPump.class),
                		ResponseTypes.instanceOf(HydroPump.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

