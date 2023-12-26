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
 * Subscriber for DCChopper related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("dCChopper-subscriber")
public class DCChopperSubscriber extends BaseSubscriber {

	public DCChopperSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<DCChopper>, DCChopper> dCChopperSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllDCChopperQuery(), 
                		ResponseTypes.multipleInstancesOf(DCChopper.class),
                		ResponseTypes.instanceOf(DCChopper.class));
    }

    public SubscriptionQueryResult<DCChopper, DCChopper> dCChopperSubscribe(@DestinationVariable UUID dCChopperId) {
        return queryGateway
                .subscriptionQuery(new FindDCChopperQuery(new LoadDCChopperFilter(dCChopperId)), 
                		ResponseTypes.instanceOf(DCChopper.class),
                		ResponseTypes.instanceOf(DCChopper.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

