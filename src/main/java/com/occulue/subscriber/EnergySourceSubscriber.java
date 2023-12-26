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
 * Subscriber for EnergySource related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("energySource-subscriber")
public class EnergySourceSubscriber extends BaseSubscriber {

	public EnergySourceSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<EnergySource>, EnergySource> energySourceSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllEnergySourceQuery(), 
                		ResponseTypes.multipleInstancesOf(EnergySource.class),
                		ResponseTypes.instanceOf(EnergySource.class));
    }

    public SubscriptionQueryResult<EnergySource, EnergySource> energySourceSubscribe(@DestinationVariable UUID energySourceId) {
        return queryGateway
                .subscriptionQuery(new FindEnergySourceQuery(new LoadEnergySourceFilter(energySourceId)), 
                		ResponseTypes.instanceOf(EnergySource.class),
                		ResponseTypes.instanceOf(EnergySource.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

