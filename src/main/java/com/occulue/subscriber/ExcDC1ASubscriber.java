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
 * Subscriber for ExcDC1A related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("excDC1A-subscriber")
public class ExcDC1ASubscriber extends BaseSubscriber {

	public ExcDC1ASubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ExcDC1A>, ExcDC1A> excDC1ASubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllExcDC1AQuery(), 
                		ResponseTypes.multipleInstancesOf(ExcDC1A.class),
                		ResponseTypes.instanceOf(ExcDC1A.class));
    }

    public SubscriptionQueryResult<ExcDC1A, ExcDC1A> excDC1ASubscribe(@DestinationVariable UUID excDC1AId) {
        return queryGateway
                .subscriptionQuery(new FindExcDC1AQuery(new LoadExcDC1AFilter(excDC1AId)), 
                		ResponseTypes.instanceOf(ExcDC1A.class),
                		ResponseTypes.instanceOf(ExcDC1A.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

