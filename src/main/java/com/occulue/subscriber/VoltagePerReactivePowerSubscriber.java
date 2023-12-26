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
 * Subscriber for VoltagePerReactivePower related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("voltagePerReactivePower-subscriber")
public class VoltagePerReactivePowerSubscriber extends BaseSubscriber {

	public VoltagePerReactivePowerSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<VoltagePerReactivePower>, VoltagePerReactivePower> voltagePerReactivePowerSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllVoltagePerReactivePowerQuery(), 
                		ResponseTypes.multipleInstancesOf(VoltagePerReactivePower.class),
                		ResponseTypes.instanceOf(VoltagePerReactivePower.class));
    }

    public SubscriptionQueryResult<VoltagePerReactivePower, VoltagePerReactivePower> voltagePerReactivePowerSubscribe(@DestinationVariable UUID voltagePerReactivePowerId) {
        return queryGateway
                .subscriptionQuery(new FindVoltagePerReactivePowerQuery(new LoadVoltagePerReactivePowerFilter(voltagePerReactivePowerId)), 
                		ResponseTypes.instanceOf(VoltagePerReactivePower.class),
                		ResponseTypes.instanceOf(VoltagePerReactivePower.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

