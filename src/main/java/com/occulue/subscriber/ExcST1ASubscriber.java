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
 * Subscriber for ExcST1A related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("excST1A-subscriber")
public class ExcST1ASubscriber extends BaseSubscriber {

	public ExcST1ASubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ExcST1A>, ExcST1A> excST1ASubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllExcST1AQuery(), 
                		ResponseTypes.multipleInstancesOf(ExcST1A.class),
                		ResponseTypes.instanceOf(ExcST1A.class));
    }

    public SubscriptionQueryResult<ExcST1A, ExcST1A> excST1ASubscribe(@DestinationVariable UUID excST1AId) {
        return queryGateway
                .subscriptionQuery(new FindExcST1AQuery(new LoadExcST1AFilter(excST1AId)), 
                		ResponseTypes.instanceOf(ExcST1A.class),
                		ResponseTypes.instanceOf(ExcST1A.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

