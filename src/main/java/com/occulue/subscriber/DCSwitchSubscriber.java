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
 * Subscriber for DCSwitch related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("dCSwitch-subscriber")
public class DCSwitchSubscriber extends BaseSubscriber {

	public DCSwitchSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<DCSwitch>, DCSwitch> dCSwitchSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllDCSwitchQuery(), 
                		ResponseTypes.multipleInstancesOf(DCSwitch.class),
                		ResponseTypes.instanceOf(DCSwitch.class));
    }

    public SubscriptionQueryResult<DCSwitch, DCSwitch> dCSwitchSubscribe(@DestinationVariable UUID dCSwitchId) {
        return queryGateway
                .subscriptionQuery(new FindDCSwitchQuery(new LoadDCSwitchFilter(dCSwitchId)), 
                		ResponseTypes.instanceOf(DCSwitch.class),
                		ResponseTypes.instanceOf(DCSwitch.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

