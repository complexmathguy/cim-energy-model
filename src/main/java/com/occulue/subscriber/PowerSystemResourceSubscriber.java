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
 * Subscriber for PowerSystemResource related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("powerSystemResource-subscriber")
public class PowerSystemResourceSubscriber extends BaseSubscriber {

	public PowerSystemResourceSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<PowerSystemResource>, PowerSystemResource> powerSystemResourceSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllPowerSystemResourceQuery(), 
                		ResponseTypes.multipleInstancesOf(PowerSystemResource.class),
                		ResponseTypes.instanceOf(PowerSystemResource.class));
    }

    public SubscriptionQueryResult<PowerSystemResource, PowerSystemResource> powerSystemResourceSubscribe(@DestinationVariable UUID powerSystemResourceId) {
        return queryGateway
                .subscriptionQuery(new FindPowerSystemResourceQuery(new LoadPowerSystemResourceFilter(powerSystemResourceId)), 
                		ResponseTypes.instanceOf(PowerSystemResource.class),
                		ResponseTypes.instanceOf(PowerSystemResource.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

