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
 * Subscriber for EnergyArea related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("energyArea-subscriber")
public class EnergyAreaSubscriber extends BaseSubscriber {

	public EnergyAreaSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<EnergyArea>, EnergyArea> energyAreaSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllEnergyAreaQuery(), 
                		ResponseTypes.multipleInstancesOf(EnergyArea.class),
                		ResponseTypes.instanceOf(EnergyArea.class));
    }

    public SubscriptionQueryResult<EnergyArea, EnergyArea> energyAreaSubscribe(@DestinationVariable UUID energyAreaId) {
        return queryGateway
                .subscriptionQuery(new FindEnergyAreaQuery(new LoadEnergyAreaFilter(energyAreaId)), 
                		ResponseTypes.instanceOf(EnergyArea.class),
                		ResponseTypes.instanceOf(EnergyArea.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

