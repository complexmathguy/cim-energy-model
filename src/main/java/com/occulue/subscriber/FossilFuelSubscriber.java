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
 * Subscriber for FossilFuel related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("fossilFuel-subscriber")
public class FossilFuelSubscriber extends BaseSubscriber {

	public FossilFuelSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<FossilFuel>, FossilFuel> fossilFuelSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllFossilFuelQuery(), 
                		ResponseTypes.multipleInstancesOf(FossilFuel.class),
                		ResponseTypes.instanceOf(FossilFuel.class));
    }

    public SubscriptionQueryResult<FossilFuel, FossilFuel> fossilFuelSubscribe(@DestinationVariable UUID fossilFuelId) {
        return queryGateway
                .subscriptionQuery(new FindFossilFuelQuery(new LoadFossilFuelFilter(fossilFuelId)), 
                		ResponseTypes.instanceOf(FossilFuel.class),
                		ResponseTypes.instanceOf(FossilFuel.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

