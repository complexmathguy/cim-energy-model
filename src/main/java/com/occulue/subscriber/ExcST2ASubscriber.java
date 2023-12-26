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
 * Subscriber for ExcST2A related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("excST2A-subscriber")
public class ExcST2ASubscriber extends BaseSubscriber {

	public ExcST2ASubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ExcST2A>, ExcST2A> excST2ASubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllExcST2AQuery(), 
                		ResponseTypes.multipleInstancesOf(ExcST2A.class),
                		ResponseTypes.instanceOf(ExcST2A.class));
    }

    public SubscriptionQueryResult<ExcST2A, ExcST2A> excST2ASubscribe(@DestinationVariable UUID excST2AId) {
        return queryGateway
                .subscriptionQuery(new FindExcST2AQuery(new LoadExcST2AFilter(excST2AId)), 
                		ResponseTypes.instanceOf(ExcST2A.class),
                		ResponseTypes.instanceOf(ExcST2A.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

