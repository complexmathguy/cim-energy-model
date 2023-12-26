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
 * Subscriber for ExcCZ related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("excCZ-subscriber")
public class ExcCZSubscriber extends BaseSubscriber {

	public ExcCZSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ExcCZ>, ExcCZ> excCZSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllExcCZQuery(), 
                		ResponseTypes.multipleInstancesOf(ExcCZ.class),
                		ResponseTypes.instanceOf(ExcCZ.class));
    }

    public SubscriptionQueryResult<ExcCZ, ExcCZ> excCZSubscribe(@DestinationVariable UUID excCZId) {
        return queryGateway
                .subscriptionQuery(new FindExcCZQuery(new LoadExcCZFilter(excCZId)), 
                		ResponseTypes.instanceOf(ExcCZ.class),
                		ResponseTypes.instanceOf(ExcCZ.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

