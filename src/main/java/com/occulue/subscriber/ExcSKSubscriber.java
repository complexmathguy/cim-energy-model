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
 * Subscriber for ExcSK related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("excSK-subscriber")
public class ExcSKSubscriber extends BaseSubscriber {

	public ExcSKSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ExcSK>, ExcSK> excSKSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllExcSKQuery(), 
                		ResponseTypes.multipleInstancesOf(ExcSK.class),
                		ResponseTypes.instanceOf(ExcSK.class));
    }

    public SubscriptionQueryResult<ExcSK, ExcSK> excSKSubscribe(@DestinationVariable UUID excSKId) {
        return queryGateway
                .subscriptionQuery(new FindExcSKQuery(new LoadExcSKFilter(excSKId)), 
                		ResponseTypes.instanceOf(ExcSK.class),
                		ResponseTypes.instanceOf(ExcSK.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

