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
 * Subscriber for GovHydroDD related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("govHydroDD-subscriber")
public class GovHydroDDSubscriber extends BaseSubscriber {

	public GovHydroDDSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<GovHydroDD>, GovHydroDD> govHydroDDSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllGovHydroDDQuery(), 
                		ResponseTypes.multipleInstancesOf(GovHydroDD.class),
                		ResponseTypes.instanceOf(GovHydroDD.class));
    }

    public SubscriptionQueryResult<GovHydroDD, GovHydroDD> govHydroDDSubscribe(@DestinationVariable UUID govHydroDDId) {
        return queryGateway
                .subscriptionQuery(new FindGovHydroDDQuery(new LoadGovHydroDDFilter(govHydroDDId)), 
                		ResponseTypes.instanceOf(GovHydroDD.class),
                		ResponseTypes.instanceOf(GovHydroDD.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

