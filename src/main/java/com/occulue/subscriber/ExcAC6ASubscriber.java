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
 * Subscriber for ExcAC6A related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("excAC6A-subscriber")
public class ExcAC6ASubscriber extends BaseSubscriber {

	public ExcAC6ASubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ExcAC6A>, ExcAC6A> excAC6ASubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllExcAC6AQuery(), 
                		ResponseTypes.multipleInstancesOf(ExcAC6A.class),
                		ResponseTypes.instanceOf(ExcAC6A.class));
    }

    public SubscriptionQueryResult<ExcAC6A, ExcAC6A> excAC6ASubscribe(@DestinationVariable UUID excAC6AId) {
        return queryGateway
                .subscriptionQuery(new FindExcAC6AQuery(new LoadExcAC6AFilter(excAC6AId)), 
                		ResponseTypes.instanceOf(ExcAC6A.class),
                		ResponseTypes.instanceOf(ExcAC6A.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

