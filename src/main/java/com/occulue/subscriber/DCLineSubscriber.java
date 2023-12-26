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
 * Subscriber for DCLine related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("dCLine-subscriber")
public class DCLineSubscriber extends BaseSubscriber {

	public DCLineSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<DCLine>, DCLine> dCLineSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllDCLineQuery(), 
                		ResponseTypes.multipleInstancesOf(DCLine.class),
                		ResponseTypes.instanceOf(DCLine.class));
    }

    public SubscriptionQueryResult<DCLine, DCLine> dCLineSubscribe(@DestinationVariable UUID dCLineId) {
        return queryGateway
                .subscriptionQuery(new FindDCLineQuery(new LoadDCLineFilter(dCLineId)), 
                		ResponseTypes.instanceOf(DCLine.class),
                		ResponseTypes.instanceOf(DCLine.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

