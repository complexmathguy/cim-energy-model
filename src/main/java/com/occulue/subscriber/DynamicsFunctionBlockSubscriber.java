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
 * Subscriber for DynamicsFunctionBlock related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("dynamicsFunctionBlock-subscriber")
public class DynamicsFunctionBlockSubscriber extends BaseSubscriber {

	public DynamicsFunctionBlockSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<DynamicsFunctionBlock>, DynamicsFunctionBlock> dynamicsFunctionBlockSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllDynamicsFunctionBlockQuery(), 
                		ResponseTypes.multipleInstancesOf(DynamicsFunctionBlock.class),
                		ResponseTypes.instanceOf(DynamicsFunctionBlock.class));
    }

    public SubscriptionQueryResult<DynamicsFunctionBlock, DynamicsFunctionBlock> dynamicsFunctionBlockSubscribe(@DestinationVariable UUID dynamicsFunctionBlockId) {
        return queryGateway
                .subscriptionQuery(new FindDynamicsFunctionBlockQuery(new LoadDynamicsFunctionBlockFilter(dynamicsFunctionBlockId)), 
                		ResponseTypes.instanceOf(DynamicsFunctionBlock.class),
                		ResponseTypes.instanceOf(DynamicsFunctionBlock.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

