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
 * Subscriber for DiscExcContIEEEDEC3A related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("discExcContIEEEDEC3A-subscriber")
public class DiscExcContIEEEDEC3ASubscriber extends BaseSubscriber {

	public DiscExcContIEEEDEC3ASubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<DiscExcContIEEEDEC3A>, DiscExcContIEEEDEC3A> discExcContIEEEDEC3ASubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllDiscExcContIEEEDEC3AQuery(), 
                		ResponseTypes.multipleInstancesOf(DiscExcContIEEEDEC3A.class),
                		ResponseTypes.instanceOf(DiscExcContIEEEDEC3A.class));
    }

    public SubscriptionQueryResult<DiscExcContIEEEDEC3A, DiscExcContIEEEDEC3A> discExcContIEEEDEC3ASubscribe(@DestinationVariable UUID discExcContIEEEDEC3AId) {
        return queryGateway
                .subscriptionQuery(new FindDiscExcContIEEEDEC3AQuery(new LoadDiscExcContIEEEDEC3AFilter(discExcContIEEEDEC3AId)), 
                		ResponseTypes.instanceOf(DiscExcContIEEEDEC3A.class),
                		ResponseTypes.instanceOf(DiscExcContIEEEDEC3A.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

