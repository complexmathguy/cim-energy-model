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
 * Subscriber for GovHydro1 related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("govHydro1-subscriber")
public class GovHydro1Subscriber extends BaseSubscriber {

	public GovHydro1Subscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<GovHydro1>, GovHydro1> govHydro1Subscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllGovHydro1Query(), 
                		ResponseTypes.multipleInstancesOf(GovHydro1.class),
                		ResponseTypes.instanceOf(GovHydro1.class));
    }

    public SubscriptionQueryResult<GovHydro1, GovHydro1> govHydro1Subscribe(@DestinationVariable UUID govHydro1Id) {
        return queryGateway
                .subscriptionQuery(new FindGovHydro1Query(new LoadGovHydro1Filter(govHydro1Id)), 
                		ResponseTypes.instanceOf(GovHydro1.class),
                		ResponseTypes.instanceOf(GovHydro1.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

