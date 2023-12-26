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
 * Subscriber for Voltage related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("voltage-subscriber")
public class VoltageSubscriber extends BaseSubscriber {

	public VoltageSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<Voltage>, Voltage> voltageSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllVoltageQuery(), 
                		ResponseTypes.multipleInstancesOf(Voltage.class),
                		ResponseTypes.instanceOf(Voltage.class));
    }

    public SubscriptionQueryResult<Voltage, Voltage> voltageSubscribe(@DestinationVariable UUID voltageId) {
        return queryGateway
                .subscriptionQuery(new FindVoltageQuery(new LoadVoltageFilter(voltageId)), 
                		ResponseTypes.instanceOf(Voltage.class),
                		ResponseTypes.instanceOf(Voltage.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

