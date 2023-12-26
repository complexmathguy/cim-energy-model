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
 * Subscriber for PssIEEE1A related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("pssIEEE1A-subscriber")
public class PssIEEE1ASubscriber extends BaseSubscriber {

	public PssIEEE1ASubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<PssIEEE1A>, PssIEEE1A> pssIEEE1ASubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllPssIEEE1AQuery(), 
                		ResponseTypes.multipleInstancesOf(PssIEEE1A.class),
                		ResponseTypes.instanceOf(PssIEEE1A.class));
    }

    public SubscriptionQueryResult<PssIEEE1A, PssIEEE1A> pssIEEE1ASubscribe(@DestinationVariable UUID pssIEEE1AId) {
        return queryGateway
                .subscriptionQuery(new FindPssIEEE1AQuery(new LoadPssIEEE1AFilter(pssIEEE1AId)), 
                		ResponseTypes.instanceOf(PssIEEE1A.class),
                		ResponseTypes.instanceOf(PssIEEE1A.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

