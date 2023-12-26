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
 * Subscriber for DiscExcContIEEEDEC2A related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("discExcContIEEEDEC2A-subscriber")
public class DiscExcContIEEEDEC2ASubscriber extends BaseSubscriber {

	public DiscExcContIEEEDEC2ASubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<DiscExcContIEEEDEC2A>, DiscExcContIEEEDEC2A> discExcContIEEEDEC2ASubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllDiscExcContIEEEDEC2AQuery(), 
                		ResponseTypes.multipleInstancesOf(DiscExcContIEEEDEC2A.class),
                		ResponseTypes.instanceOf(DiscExcContIEEEDEC2A.class));
    }

    public SubscriptionQueryResult<DiscExcContIEEEDEC2A, DiscExcContIEEEDEC2A> discExcContIEEEDEC2ASubscribe(@DestinationVariable UUID discExcContIEEEDEC2AId) {
        return queryGateway
                .subscriptionQuery(new FindDiscExcContIEEEDEC2AQuery(new LoadDiscExcContIEEEDEC2AFilter(discExcContIEEEDEC2AId)), 
                		ResponseTypes.instanceOf(DiscExcContIEEEDEC2A.class),
                		ResponseTypes.instanceOf(DiscExcContIEEEDEC2A.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

