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
 * Subscriber for ActivePower related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("activePower-subscriber")
public class ActivePowerSubscriber extends BaseSubscriber {

	public ActivePowerSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ActivePower>, ActivePower> activePowerSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllActivePowerQuery(), 
                		ResponseTypes.multipleInstancesOf(ActivePower.class),
                		ResponseTypes.instanceOf(ActivePower.class));
    }

    public SubscriptionQueryResult<ActivePower, ActivePower> activePowerSubscribe(@DestinationVariable UUID activePowerId) {
        return queryGateway
                .subscriptionQuery(new FindActivePowerQuery(new LoadActivePowerFilter(activePowerId)), 
                		ResponseTypes.instanceOf(ActivePower.class),
                		ResponseTypes.instanceOf(ActivePower.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

