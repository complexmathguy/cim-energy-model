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
 * Subscriber for ExcDC3A related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("excDC3A-subscriber")
public class ExcDC3ASubscriber extends BaseSubscriber {

	public ExcDC3ASubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ExcDC3A>, ExcDC3A> excDC3ASubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllExcDC3AQuery(), 
                		ResponseTypes.multipleInstancesOf(ExcDC3A.class),
                		ResponseTypes.instanceOf(ExcDC3A.class));
    }

    public SubscriptionQueryResult<ExcDC3A, ExcDC3A> excDC3ASubscribe(@DestinationVariable UUID excDC3AId) {
        return queryGateway
                .subscriptionQuery(new FindExcDC3AQuery(new LoadExcDC3AFilter(excDC3AId)), 
                		ResponseTypes.instanceOf(ExcDC3A.class),
                		ResponseTypes.instanceOf(ExcDC3A.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

