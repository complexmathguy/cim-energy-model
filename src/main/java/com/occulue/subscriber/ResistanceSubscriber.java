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
 * Subscriber for Resistance related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("resistance-subscriber")
public class ResistanceSubscriber extends BaseSubscriber {

	public ResistanceSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<Resistance>, Resistance> resistanceSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllResistanceQuery(), 
                		ResponseTypes.multipleInstancesOf(Resistance.class),
                		ResponseTypes.instanceOf(Resistance.class));
    }

    public SubscriptionQueryResult<Resistance, Resistance> resistanceSubscribe(@DestinationVariable UUID resistanceId) {
        return queryGateway
                .subscriptionQuery(new FindResistanceQuery(new LoadResistanceFilter(resistanceId)), 
                		ResponseTypes.instanceOf(Resistance.class),
                		ResponseTypes.instanceOf(Resistance.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

