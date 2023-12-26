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
 * Subscriber for RotatingMachineDynamics related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("rotatingMachineDynamics-subscriber")
public class RotatingMachineDynamicsSubscriber extends BaseSubscriber {

	public RotatingMachineDynamicsSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<RotatingMachineDynamics>, RotatingMachineDynamics> rotatingMachineDynamicsSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllRotatingMachineDynamicsQuery(), 
                		ResponseTypes.multipleInstancesOf(RotatingMachineDynamics.class),
                		ResponseTypes.instanceOf(RotatingMachineDynamics.class));
    }

    public SubscriptionQueryResult<RotatingMachineDynamics, RotatingMachineDynamics> rotatingMachineDynamicsSubscribe(@DestinationVariable UUID rotatingMachineDynamicsId) {
        return queryGateway
                .subscriptionQuery(new FindRotatingMachineDynamicsQuery(new LoadRotatingMachineDynamicsFilter(rotatingMachineDynamicsId)), 
                		ResponseTypes.instanceOf(RotatingMachineDynamics.class),
                		ResponseTypes.instanceOf(RotatingMachineDynamics.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

