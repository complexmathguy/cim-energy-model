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
 * Subscriber for Pss2ST related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("pss2ST-subscriber")
public class Pss2STSubscriber extends BaseSubscriber {

	public Pss2STSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<Pss2ST>, Pss2ST> pss2STSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllPss2STQuery(), 
                		ResponseTypes.multipleInstancesOf(Pss2ST.class),
                		ResponseTypes.instanceOf(Pss2ST.class));
    }

    public SubscriptionQueryResult<Pss2ST, Pss2ST> pss2STSubscribe(@DestinationVariable UUID pss2STId) {
        return queryGateway
                .subscriptionQuery(new FindPss2STQuery(new LoadPss2STFilter(pss2STId)), 
                		ResponseTypes.instanceOf(Pss2ST.class),
                		ResponseTypes.instanceOf(Pss2ST.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

