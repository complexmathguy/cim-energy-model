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
 * Subscriber for GovSteam2 related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("govSteam2-subscriber")
public class GovSteam2Subscriber extends BaseSubscriber {

	public GovSteam2Subscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<GovSteam2>, GovSteam2> govSteam2Subscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllGovSteam2Query(), 
                		ResponseTypes.multipleInstancesOf(GovSteam2.class),
                		ResponseTypes.instanceOf(GovSteam2.class));
    }

    public SubscriptionQueryResult<GovSteam2, GovSteam2> govSteam2Subscribe(@DestinationVariable UUID govSteam2Id) {
        return queryGateway
                .subscriptionQuery(new FindGovSteam2Query(new LoadGovSteam2Filter(govSteam2Id)), 
                		ResponseTypes.instanceOf(GovSteam2.class),
                		ResponseTypes.instanceOf(GovSteam2.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

