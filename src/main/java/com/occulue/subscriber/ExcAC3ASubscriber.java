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
 * Subscriber for ExcAC3A related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("excAC3A-subscriber")
public class ExcAC3ASubscriber extends BaseSubscriber {

	public ExcAC3ASubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ExcAC3A>, ExcAC3A> excAC3ASubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllExcAC3AQuery(), 
                		ResponseTypes.multipleInstancesOf(ExcAC3A.class),
                		ResponseTypes.instanceOf(ExcAC3A.class));
    }

    public SubscriptionQueryResult<ExcAC3A, ExcAC3A> excAC3ASubscribe(@DestinationVariable UUID excAC3AId) {
        return queryGateway
                .subscriptionQuery(new FindExcAC3AQuery(new LoadExcAC3AFilter(excAC3AId)), 
                		ResponseTypes.instanceOf(ExcAC3A.class),
                		ResponseTypes.instanceOf(ExcAC3A.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

