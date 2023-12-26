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
 * Subscriber for GovHydroFrancis related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("govHydroFrancis-subscriber")
public class GovHydroFrancisSubscriber extends BaseSubscriber {

	public GovHydroFrancisSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<GovHydroFrancis>, GovHydroFrancis> govHydroFrancisSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllGovHydroFrancisQuery(), 
                		ResponseTypes.multipleInstancesOf(GovHydroFrancis.class),
                		ResponseTypes.instanceOf(GovHydroFrancis.class));
    }

    public SubscriptionQueryResult<GovHydroFrancis, GovHydroFrancis> govHydroFrancisSubscribe(@DestinationVariable UUID govHydroFrancisId) {
        return queryGateway
                .subscriptionQuery(new FindGovHydroFrancisQuery(new LoadGovHydroFrancisFilter(govHydroFrancisId)), 
                		ResponseTypes.instanceOf(GovHydroFrancis.class),
                		ResponseTypes.instanceOf(GovHydroFrancis.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

