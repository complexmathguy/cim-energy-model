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
 * Subscriber for DiscontinuousExcitationControlDynamics related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("discontinuousExcitationControlDynamics-subscriber")
public class DiscontinuousExcitationControlDynamicsSubscriber extends BaseSubscriber {

	public DiscontinuousExcitationControlDynamicsSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<DiscontinuousExcitationControlDynamics>, DiscontinuousExcitationControlDynamics> discontinuousExcitationControlDynamicsSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllDiscontinuousExcitationControlDynamicsQuery(), 
                		ResponseTypes.multipleInstancesOf(DiscontinuousExcitationControlDynamics.class),
                		ResponseTypes.instanceOf(DiscontinuousExcitationControlDynamics.class));
    }

    public SubscriptionQueryResult<DiscontinuousExcitationControlDynamics, DiscontinuousExcitationControlDynamics> discontinuousExcitationControlDynamicsSubscribe(@DestinationVariable UUID discontinuousExcitationControlDynamicsId) {
        return queryGateway
                .subscriptionQuery(new FindDiscontinuousExcitationControlDynamicsQuery(new LoadDiscontinuousExcitationControlDynamicsFilter(discontinuousExcitationControlDynamicsId)), 
                		ResponseTypes.instanceOf(DiscontinuousExcitationControlDynamics.class),
                		ResponseTypes.instanceOf(DiscontinuousExcitationControlDynamics.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

