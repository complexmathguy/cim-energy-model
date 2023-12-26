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
 * Subscriber for SteadyStateHypothesisVersion related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("steadyStateHypothesisVersion-subscriber")
public class SteadyStateHypothesisVersionSubscriber extends BaseSubscriber {

	public SteadyStateHypothesisVersionSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<SteadyStateHypothesisVersion>, SteadyStateHypothesisVersion> steadyStateHypothesisVersionSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllSteadyStateHypothesisVersionQuery(), 
                		ResponseTypes.multipleInstancesOf(SteadyStateHypothesisVersion.class),
                		ResponseTypes.instanceOf(SteadyStateHypothesisVersion.class));
    }

    public SubscriptionQueryResult<SteadyStateHypothesisVersion, SteadyStateHypothesisVersion> steadyStateHypothesisVersionSubscribe(@DestinationVariable UUID steadyStateHypothesisVersionId) {
        return queryGateway
                .subscriptionQuery(new FindSteadyStateHypothesisVersionQuery(new LoadSteadyStateHypothesisVersionFilter(steadyStateHypothesisVersionId)), 
                		ResponseTypes.instanceOf(SteadyStateHypothesisVersion.class),
                		ResponseTypes.instanceOf(SteadyStateHypothesisVersion.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

