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
 * Subscriber for LinearShuntCompensator related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("linearShuntCompensator-subscriber")
public class LinearShuntCompensatorSubscriber extends BaseSubscriber {

	public LinearShuntCompensatorSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<LinearShuntCompensator>, LinearShuntCompensator> linearShuntCompensatorSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllLinearShuntCompensatorQuery(), 
                		ResponseTypes.multipleInstancesOf(LinearShuntCompensator.class),
                		ResponseTypes.instanceOf(LinearShuntCompensator.class));
    }

    public SubscriptionQueryResult<LinearShuntCompensator, LinearShuntCompensator> linearShuntCompensatorSubscribe(@DestinationVariable UUID linearShuntCompensatorId) {
        return queryGateway
                .subscriptionQuery(new FindLinearShuntCompensatorQuery(new LoadLinearShuntCompensatorFilter(linearShuntCompensatorId)), 
                		ResponseTypes.instanceOf(LinearShuntCompensator.class),
                		ResponseTypes.instanceOf(LinearShuntCompensator.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

