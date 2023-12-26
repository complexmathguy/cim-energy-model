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
 * Subscriber for GovHydro3 related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("govHydro3-subscriber")
public class GovHydro3Subscriber extends BaseSubscriber {

	public GovHydro3Subscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<GovHydro3>, GovHydro3> govHydro3Subscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllGovHydro3Query(), 
                		ResponseTypes.multipleInstancesOf(GovHydro3.class),
                		ResponseTypes.instanceOf(GovHydro3.class));
    }

    public SubscriptionQueryResult<GovHydro3, GovHydro3> govHydro3Subscribe(@DestinationVariable UUID govHydro3Id) {
        return queryGateway
                .subscriptionQuery(new FindGovHydro3Query(new LoadGovHydro3Filter(govHydro3Id)), 
                		ResponseTypes.instanceOf(GovHydro3.class),
                		ResponseTypes.instanceOf(GovHydro3.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

