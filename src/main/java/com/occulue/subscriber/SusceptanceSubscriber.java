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
 * Subscriber for Susceptance related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("susceptance-subscriber")
public class SusceptanceSubscriber extends BaseSubscriber {

	public SusceptanceSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<Susceptance>, Susceptance> susceptanceSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllSusceptanceQuery(), 
                		ResponseTypes.multipleInstancesOf(Susceptance.class),
                		ResponseTypes.instanceOf(Susceptance.class));
    }

    public SubscriptionQueryResult<Susceptance, Susceptance> susceptanceSubscribe(@DestinationVariable UUID susceptanceId) {
        return queryGateway
                .subscriptionQuery(new FindSusceptanceQuery(new LoadSusceptanceFilter(susceptanceId)), 
                		ResponseTypes.instanceOf(Susceptance.class),
                		ResponseTypes.instanceOf(Susceptance.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

