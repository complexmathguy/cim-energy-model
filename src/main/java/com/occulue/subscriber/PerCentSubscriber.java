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
 * Subscriber for PerCent related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("perCent-subscriber")
public class PerCentSubscriber extends BaseSubscriber {

	public PerCentSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<PerCent>, PerCent> perCentSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllPerCentQuery(), 
                		ResponseTypes.multipleInstancesOf(PerCent.class),
                		ResponseTypes.instanceOf(PerCent.class));
    }

    public SubscriptionQueryResult<PerCent, PerCent> perCentSubscribe(@DestinationVariable UUID perCentId) {
        return queryGateway
                .subscriptionQuery(new FindPerCentQuery(new LoadPerCentFilter(perCentId)), 
                		ResponseTypes.instanceOf(PerCent.class),
                		ResponseTypes.instanceOf(PerCent.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

