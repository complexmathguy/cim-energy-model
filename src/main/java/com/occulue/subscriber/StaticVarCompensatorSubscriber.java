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
 * Subscriber for StaticVarCompensator related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("staticVarCompensator-subscriber")
public class StaticVarCompensatorSubscriber extends BaseSubscriber {

	public StaticVarCompensatorSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<StaticVarCompensator>, StaticVarCompensator> staticVarCompensatorSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllStaticVarCompensatorQuery(), 
                		ResponseTypes.multipleInstancesOf(StaticVarCompensator.class),
                		ResponseTypes.instanceOf(StaticVarCompensator.class));
    }

    public SubscriptionQueryResult<StaticVarCompensator, StaticVarCompensator> staticVarCompensatorSubscribe(@DestinationVariable UUID staticVarCompensatorId) {
        return queryGateway
                .subscriptionQuery(new FindStaticVarCompensatorQuery(new LoadStaticVarCompensatorFilter(staticVarCompensatorId)), 
                		ResponseTypes.instanceOf(StaticVarCompensator.class),
                		ResponseTypes.instanceOf(StaticVarCompensator.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

