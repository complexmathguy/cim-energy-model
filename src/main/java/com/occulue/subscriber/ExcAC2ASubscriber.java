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
 * Subscriber for ExcAC2A related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("excAC2A-subscriber")
public class ExcAC2ASubscriber extends BaseSubscriber {

	public ExcAC2ASubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ExcAC2A>, ExcAC2A> excAC2ASubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllExcAC2AQuery(), 
                		ResponseTypes.multipleInstancesOf(ExcAC2A.class),
                		ResponseTypes.instanceOf(ExcAC2A.class));
    }

    public SubscriptionQueryResult<ExcAC2A, ExcAC2A> excAC2ASubscribe(@DestinationVariable UUID excAC2AId) {
        return queryGateway
                .subscriptionQuery(new FindExcAC2AQuery(new LoadExcAC2AFilter(excAC2AId)), 
                		ResponseTypes.instanceOf(ExcAC2A.class),
                		ResponseTypes.instanceOf(ExcAC2A.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

