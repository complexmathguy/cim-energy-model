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
 * Subscriber for OperationalLimit related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("operationalLimit-subscriber")
public class OperationalLimitSubscriber extends BaseSubscriber {

	public OperationalLimitSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<OperationalLimit>, OperationalLimit> operationalLimitSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllOperationalLimitQuery(), 
                		ResponseTypes.multipleInstancesOf(OperationalLimit.class),
                		ResponseTypes.instanceOf(OperationalLimit.class));
    }

    public SubscriptionQueryResult<OperationalLimit, OperationalLimit> operationalLimitSubscribe(@DestinationVariable UUID operationalLimitId) {
        return queryGateway
                .subscriptionQuery(new FindOperationalLimitQuery(new LoadOperationalLimitFilter(operationalLimitId)), 
                		ResponseTypes.instanceOf(OperationalLimit.class),
                		ResponseTypes.instanceOf(OperationalLimit.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

