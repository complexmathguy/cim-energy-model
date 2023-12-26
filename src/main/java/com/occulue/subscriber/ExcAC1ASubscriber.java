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
 * Subscriber for ExcAC1A related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("excAC1A-subscriber")
public class ExcAC1ASubscriber extends BaseSubscriber {

	public ExcAC1ASubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ExcAC1A>, ExcAC1A> excAC1ASubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllExcAC1AQuery(), 
                		ResponseTypes.multipleInstancesOf(ExcAC1A.class),
                		ResponseTypes.instanceOf(ExcAC1A.class));
    }

    public SubscriptionQueryResult<ExcAC1A, ExcAC1A> excAC1ASubscribe(@DestinationVariable UUID excAC1AId) {
        return queryGateway
                .subscriptionQuery(new FindExcAC1AQuery(new LoadExcAC1AFilter(excAC1AId)), 
                		ResponseTypes.instanceOf(ExcAC1A.class),
                		ResponseTypes.instanceOf(ExcAC1A.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

