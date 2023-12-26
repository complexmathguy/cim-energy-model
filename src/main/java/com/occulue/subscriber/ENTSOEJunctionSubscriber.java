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
 * Subscriber for ENTSOEJunction related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("eNTSOEJunction-subscriber")
public class ENTSOEJunctionSubscriber extends BaseSubscriber {

	public ENTSOEJunctionSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ENTSOEJunction>, ENTSOEJunction> eNTSOEJunctionSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllENTSOEJunctionQuery(), 
                		ResponseTypes.multipleInstancesOf(ENTSOEJunction.class),
                		ResponseTypes.instanceOf(ENTSOEJunction.class));
    }

    public SubscriptionQueryResult<ENTSOEJunction, ENTSOEJunction> eNTSOEJunctionSubscribe(@DestinationVariable UUID eNTSOEJunctionId) {
        return queryGateway
                .subscriptionQuery(new FindENTSOEJunctionQuery(new LoadENTSOEJunctionFilter(eNTSOEJunctionId)), 
                		ResponseTypes.instanceOf(ENTSOEJunction.class),
                		ResponseTypes.instanceOf(ENTSOEJunction.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

