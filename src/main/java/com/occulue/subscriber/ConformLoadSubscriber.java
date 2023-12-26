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
 * Subscriber for ConformLoad related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("conformLoad-subscriber")
public class ConformLoadSubscriber extends BaseSubscriber {

	public ConformLoadSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ConformLoad>, ConformLoad> conformLoadSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllConformLoadQuery(), 
                		ResponseTypes.multipleInstancesOf(ConformLoad.class),
                		ResponseTypes.instanceOf(ConformLoad.class));
    }

    public SubscriptionQueryResult<ConformLoad, ConformLoad> conformLoadSubscribe(@DestinationVariable UUID conformLoadId) {
        return queryGateway
                .subscriptionQuery(new FindConformLoadQuery(new LoadConformLoadFilter(conformLoadId)), 
                		ResponseTypes.instanceOf(ConformLoad.class),
                		ResponseTypes.instanceOf(ConformLoad.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

