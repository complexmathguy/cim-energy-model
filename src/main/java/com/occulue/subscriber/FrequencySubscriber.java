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
 * Subscriber for Frequency related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("frequency-subscriber")
public class FrequencySubscriber extends BaseSubscriber {

	public FrequencySubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<Frequency>, Frequency> frequencySubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllFrequencyQuery(), 
                		ResponseTypes.multipleInstancesOf(Frequency.class),
                		ResponseTypes.instanceOf(Frequency.class));
    }

    public SubscriptionQueryResult<Frequency, Frequency> frequencySubscribe(@DestinationVariable UUID frequencyId) {
        return queryGateway
                .subscriptionQuery(new FindFrequencyQuery(new LoadFrequencyFilter(frequencyId)), 
                		ResponseTypes.instanceOf(Frequency.class),
                		ResponseTypes.instanceOf(Frequency.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

