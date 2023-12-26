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
 * Subscriber for VoltageAdjusterDynamics related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("voltageAdjusterDynamics-subscriber")
public class VoltageAdjusterDynamicsSubscriber extends BaseSubscriber {

	public VoltageAdjusterDynamicsSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<VoltageAdjusterDynamics>, VoltageAdjusterDynamics> voltageAdjusterDynamicsSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllVoltageAdjusterDynamicsQuery(), 
                		ResponseTypes.multipleInstancesOf(VoltageAdjusterDynamics.class),
                		ResponseTypes.instanceOf(VoltageAdjusterDynamics.class));
    }

    public SubscriptionQueryResult<VoltageAdjusterDynamics, VoltageAdjusterDynamics> voltageAdjusterDynamicsSubscribe(@DestinationVariable UUID voltageAdjusterDynamicsId) {
        return queryGateway
                .subscriptionQuery(new FindVoltageAdjusterDynamicsQuery(new LoadVoltageAdjusterDynamicsFilter(voltageAdjusterDynamicsId)), 
                		ResponseTypes.instanceOf(VoltageAdjusterDynamics.class),
                		ResponseTypes.instanceOf(VoltageAdjusterDynamics.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

