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
 * Subscriber for PssIEEE2B related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("pssIEEE2B-subscriber")
public class PssIEEE2BSubscriber extends BaseSubscriber {

	public PssIEEE2BSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<PssIEEE2B>, PssIEEE2B> pssIEEE2BSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllPssIEEE2BQuery(), 
                		ResponseTypes.multipleInstancesOf(PssIEEE2B.class),
                		ResponseTypes.instanceOf(PssIEEE2B.class));
    }

    public SubscriptionQueryResult<PssIEEE2B, PssIEEE2B> pssIEEE2BSubscribe(@DestinationVariable UUID pssIEEE2BId) {
        return queryGateway
                .subscriptionQuery(new FindPssIEEE2BQuery(new LoadPssIEEE2BFilter(pssIEEE2BId)), 
                		ResponseTypes.instanceOf(PssIEEE2B.class),
                		ResponseTypes.instanceOf(PssIEEE2B.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

