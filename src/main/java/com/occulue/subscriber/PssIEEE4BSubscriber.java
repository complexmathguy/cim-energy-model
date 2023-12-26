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
 * Subscriber for PssIEEE4B related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("pssIEEE4B-subscriber")
public class PssIEEE4BSubscriber extends BaseSubscriber {

	public PssIEEE4BSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<PssIEEE4B>, PssIEEE4B> pssIEEE4BSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllPssIEEE4BQuery(), 
                		ResponseTypes.multipleInstancesOf(PssIEEE4B.class),
                		ResponseTypes.instanceOf(PssIEEE4B.class));
    }

    public SubscriptionQueryResult<PssIEEE4B, PssIEEE4B> pssIEEE4BSubscribe(@DestinationVariable UUID pssIEEE4BId) {
        return queryGateway
                .subscriptionQuery(new FindPssIEEE4BQuery(new LoadPssIEEE4BFilter(pssIEEE4BId)), 
                		ResponseTypes.instanceOf(PssIEEE4B.class),
                		ResponseTypes.instanceOf(PssIEEE4B.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

