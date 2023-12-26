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
 * Subscriber for ExcST3A related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("excST3A-subscriber")
public class ExcST3ASubscriber extends BaseSubscriber {

	public ExcST3ASubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ExcST3A>, ExcST3A> excST3ASubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllExcST3AQuery(), 
                		ResponseTypes.multipleInstancesOf(ExcST3A.class),
                		ResponseTypes.instanceOf(ExcST3A.class));
    }

    public SubscriptionQueryResult<ExcST3A, ExcST3A> excST3ASubscribe(@DestinationVariable UUID excST3AId) {
        return queryGateway
                .subscriptionQuery(new FindExcST3AQuery(new LoadExcST3AFilter(excST3AId)), 
                		ResponseTypes.instanceOf(ExcST3A.class),
                		ResponseTypes.instanceOf(ExcST3A.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

