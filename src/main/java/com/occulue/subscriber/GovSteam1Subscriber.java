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
 * Subscriber for GovSteam1 related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("govSteam1-subscriber")
public class GovSteam1Subscriber extends BaseSubscriber {

	public GovSteam1Subscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<GovSteam1>, GovSteam1> govSteam1Subscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllGovSteam1Query(), 
                		ResponseTypes.multipleInstancesOf(GovSteam1.class),
                		ResponseTypes.instanceOf(GovSteam1.class));
    }

    public SubscriptionQueryResult<GovSteam1, GovSteam1> govSteam1Subscribe(@DestinationVariable UUID govSteam1Id) {
        return queryGateway
                .subscriptionQuery(new FindGovSteam1Query(new LoadGovSteam1Filter(govSteam1Id)), 
                		ResponseTypes.instanceOf(GovSteam1.class),
                		ResponseTypes.instanceOf(GovSteam1.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

