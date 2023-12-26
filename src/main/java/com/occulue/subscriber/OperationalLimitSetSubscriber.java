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
 * Subscriber for OperationalLimitSet related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("operationalLimitSet-subscriber")
public class OperationalLimitSetSubscriber extends BaseSubscriber {

	public OperationalLimitSetSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<OperationalLimitSet>, OperationalLimitSet> operationalLimitSetSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllOperationalLimitSetQuery(), 
                		ResponseTypes.multipleInstancesOf(OperationalLimitSet.class),
                		ResponseTypes.instanceOf(OperationalLimitSet.class));
    }

    public SubscriptionQueryResult<OperationalLimitSet, OperationalLimitSet> operationalLimitSetSubscribe(@DestinationVariable UUID operationalLimitSetId) {
        return queryGateway
                .subscriptionQuery(new FindOperationalLimitSetQuery(new LoadOperationalLimitSetFilter(operationalLimitSetId)), 
                		ResponseTypes.instanceOf(OperationalLimitSet.class),
                		ResponseTypes.instanceOf(OperationalLimitSet.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

