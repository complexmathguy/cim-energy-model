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
 * Subscriber for EarthFaultCompensator related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("earthFaultCompensator-subscriber")
public class EarthFaultCompensatorSubscriber extends BaseSubscriber {

	public EarthFaultCompensatorSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<EarthFaultCompensator>, EarthFaultCompensator> earthFaultCompensatorSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllEarthFaultCompensatorQuery(), 
                		ResponseTypes.multipleInstancesOf(EarthFaultCompensator.class),
                		ResponseTypes.instanceOf(EarthFaultCompensator.class));
    }

    public SubscriptionQueryResult<EarthFaultCompensator, EarthFaultCompensator> earthFaultCompensatorSubscribe(@DestinationVariable UUID earthFaultCompensatorId) {
        return queryGateway
                .subscriptionQuery(new FindEarthFaultCompensatorQuery(new LoadEarthFaultCompensatorFilter(earthFaultCompensatorId)), 
                		ResponseTypes.instanceOf(EarthFaultCompensator.class),
                		ResponseTypes.instanceOf(EarthFaultCompensator.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

