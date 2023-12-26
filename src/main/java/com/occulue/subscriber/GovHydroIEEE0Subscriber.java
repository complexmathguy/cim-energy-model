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
 * Subscriber for GovHydroIEEE0 related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("govHydroIEEE0-subscriber")
public class GovHydroIEEE0Subscriber extends BaseSubscriber {

	public GovHydroIEEE0Subscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<GovHydroIEEE0>, GovHydroIEEE0> govHydroIEEE0Subscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllGovHydroIEEE0Query(), 
                		ResponseTypes.multipleInstancesOf(GovHydroIEEE0.class),
                		ResponseTypes.instanceOf(GovHydroIEEE0.class));
    }

    public SubscriptionQueryResult<GovHydroIEEE0, GovHydroIEEE0> govHydroIEEE0Subscribe(@DestinationVariable UUID govHydroIEEE0Id) {
        return queryGateway
                .subscriptionQuery(new FindGovHydroIEEE0Query(new LoadGovHydroIEEE0Filter(govHydroIEEE0Id)), 
                		ResponseTypes.instanceOf(GovHydroIEEE0.class),
                		ResponseTypes.instanceOf(GovHydroIEEE0.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

