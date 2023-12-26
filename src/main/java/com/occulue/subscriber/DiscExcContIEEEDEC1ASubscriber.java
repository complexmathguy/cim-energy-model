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
 * Subscriber for DiscExcContIEEEDEC1A related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("discExcContIEEEDEC1A-subscriber")
public class DiscExcContIEEEDEC1ASubscriber extends BaseSubscriber {

	public DiscExcContIEEEDEC1ASubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<DiscExcContIEEEDEC1A>, DiscExcContIEEEDEC1A> discExcContIEEEDEC1ASubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllDiscExcContIEEEDEC1AQuery(), 
                		ResponseTypes.multipleInstancesOf(DiscExcContIEEEDEC1A.class),
                		ResponseTypes.instanceOf(DiscExcContIEEEDEC1A.class));
    }

    public SubscriptionQueryResult<DiscExcContIEEEDEC1A, DiscExcContIEEEDEC1A> discExcContIEEEDEC1ASubscribe(@DestinationVariable UUID discExcContIEEEDEC1AId) {
        return queryGateway
                .subscriptionQuery(new FindDiscExcContIEEEDEC1AQuery(new LoadDiscExcContIEEEDEC1AFilter(discExcContIEEEDEC1AId)), 
                		ResponseTypes.instanceOf(DiscExcContIEEEDEC1A.class),
                		ResponseTypes.instanceOf(DiscExcContIEEEDEC1A.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

