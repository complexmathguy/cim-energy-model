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
 * Subscriber for PowerTransformerEnd related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("powerTransformerEnd-subscriber")
public class PowerTransformerEndSubscriber extends BaseSubscriber {

	public PowerTransformerEndSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<PowerTransformerEnd>, PowerTransformerEnd> powerTransformerEndSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllPowerTransformerEndQuery(), 
                		ResponseTypes.multipleInstancesOf(PowerTransformerEnd.class),
                		ResponseTypes.instanceOf(PowerTransformerEnd.class));
    }

    public SubscriptionQueryResult<PowerTransformerEnd, PowerTransformerEnd> powerTransformerEndSubscribe(@DestinationVariable UUID powerTransformerEndId) {
        return queryGateway
                .subscriptionQuery(new FindPowerTransformerEndQuery(new LoadPowerTransformerEndFilter(powerTransformerEndId)), 
                		ResponseTypes.instanceOf(PowerTransformerEnd.class),
                		ResponseTypes.instanceOf(PowerTransformerEnd.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

