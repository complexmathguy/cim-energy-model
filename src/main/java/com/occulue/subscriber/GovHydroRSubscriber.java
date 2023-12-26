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
 * Subscriber for GovHydroR related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("govHydroR-subscriber")
public class GovHydroRSubscriber extends BaseSubscriber {

	public GovHydroRSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<GovHydroR>, GovHydroR> govHydroRSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllGovHydroRQuery(), 
                		ResponseTypes.multipleInstancesOf(GovHydroR.class),
                		ResponseTypes.instanceOf(GovHydroR.class));
    }

    public SubscriptionQueryResult<GovHydroR, GovHydroR> govHydroRSubscribe(@DestinationVariable UUID govHydroRId) {
        return queryGateway
                .subscriptionQuery(new FindGovHydroRQuery(new LoadGovHydroRFilter(govHydroRId)), 
                		ResponseTypes.instanceOf(GovHydroR.class),
                		ResponseTypes.instanceOf(GovHydroR.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

