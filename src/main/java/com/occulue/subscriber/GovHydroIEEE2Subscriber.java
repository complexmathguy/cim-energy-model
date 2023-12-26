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
 * Subscriber for GovHydroIEEE2 related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("govHydroIEEE2-subscriber")
public class GovHydroIEEE2Subscriber extends BaseSubscriber {

	public GovHydroIEEE2Subscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<GovHydroIEEE2>, GovHydroIEEE2> govHydroIEEE2Subscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllGovHydroIEEE2Query(), 
                		ResponseTypes.multipleInstancesOf(GovHydroIEEE2.class),
                		ResponseTypes.instanceOf(GovHydroIEEE2.class));
    }

    public SubscriptionQueryResult<GovHydroIEEE2, GovHydroIEEE2> govHydroIEEE2Subscribe(@DestinationVariable UUID govHydroIEEE2Id) {
        return queryGateway
                .subscriptionQuery(new FindGovHydroIEEE2Query(new LoadGovHydroIEEE2Filter(govHydroIEEE2Id)), 
                		ResponseTypes.instanceOf(GovHydroIEEE2.class),
                		ResponseTypes.instanceOf(GovHydroIEEE2.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

