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
 * Subscriber for VoltageLevel related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("voltageLevel-subscriber")
public class VoltageLevelSubscriber extends BaseSubscriber {

	public VoltageLevelSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<VoltageLevel>, VoltageLevel> voltageLevelSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllVoltageLevelQuery(), 
                		ResponseTypes.multipleInstancesOf(VoltageLevel.class),
                		ResponseTypes.instanceOf(VoltageLevel.class));
    }

    public SubscriptionQueryResult<VoltageLevel, VoltageLevel> voltageLevelSubscribe(@DestinationVariable UUID voltageLevelId) {
        return queryGateway
                .subscriptionQuery(new FindVoltageLevelQuery(new LoadVoltageLevelFilter(voltageLevelId)), 
                		ResponseTypes.instanceOf(VoltageLevel.class),
                		ResponseTypes.instanceOf(VoltageLevel.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

