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
 * Subscriber for PowerSystemStabilizerDynamics related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("powerSystemStabilizerDynamics-subscriber")
public class PowerSystemStabilizerDynamicsSubscriber extends BaseSubscriber {

	public PowerSystemStabilizerDynamicsSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<PowerSystemStabilizerDynamics>, PowerSystemStabilizerDynamics> powerSystemStabilizerDynamicsSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllPowerSystemStabilizerDynamicsQuery(), 
                		ResponseTypes.multipleInstancesOf(PowerSystemStabilizerDynamics.class),
                		ResponseTypes.instanceOf(PowerSystemStabilizerDynamics.class));
    }

    public SubscriptionQueryResult<PowerSystemStabilizerDynamics, PowerSystemStabilizerDynamics> powerSystemStabilizerDynamicsSubscribe(@DestinationVariable UUID powerSystemStabilizerDynamicsId) {
        return queryGateway
                .subscriptionQuery(new FindPowerSystemStabilizerDynamicsQuery(new LoadPowerSystemStabilizerDynamicsFilter(powerSystemStabilizerDynamicsId)), 
                		ResponseTypes.instanceOf(PowerSystemStabilizerDynamics.class),
                		ResponseTypes.instanceOf(PowerSystemStabilizerDynamics.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

