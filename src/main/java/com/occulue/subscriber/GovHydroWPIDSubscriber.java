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
 * Subscriber for GovHydroWPID related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("govHydroWPID-subscriber")
public class GovHydroWPIDSubscriber extends BaseSubscriber {

	public GovHydroWPIDSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<GovHydroWPID>, GovHydroWPID> govHydroWPIDSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllGovHydroWPIDQuery(), 
                		ResponseTypes.multipleInstancesOf(GovHydroWPID.class),
                		ResponseTypes.instanceOf(GovHydroWPID.class));
    }

    public SubscriptionQueryResult<GovHydroWPID, GovHydroWPID> govHydroWPIDSubscribe(@DestinationVariable UUID govHydroWPIDId) {
        return queryGateway
                .subscriptionQuery(new FindGovHydroWPIDQuery(new LoadGovHydroWPIDFilter(govHydroWPIDId)), 
                		ResponseTypes.instanceOf(GovHydroWPID.class),
                		ResponseTypes.instanceOf(GovHydroWPID.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

