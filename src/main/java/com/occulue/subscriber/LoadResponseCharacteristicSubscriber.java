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
 * Subscriber for LoadResponseCharacteristic related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("loadResponseCharacteristic-subscriber")
public class LoadResponseCharacteristicSubscriber extends BaseSubscriber {

	public LoadResponseCharacteristicSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<LoadResponseCharacteristic>, LoadResponseCharacteristic> loadResponseCharacteristicSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllLoadResponseCharacteristicQuery(), 
                		ResponseTypes.multipleInstancesOf(LoadResponseCharacteristic.class),
                		ResponseTypes.instanceOf(LoadResponseCharacteristic.class));
    }

    public SubscriptionQueryResult<LoadResponseCharacteristic, LoadResponseCharacteristic> loadResponseCharacteristicSubscribe(@DestinationVariable UUID loadResponseCharacteristicId) {
        return queryGateway
                .subscriptionQuery(new FindLoadResponseCharacteristicQuery(new LoadLoadResponseCharacteristicFilter(loadResponseCharacteristicId)), 
                		ResponseTypes.instanceOf(LoadResponseCharacteristic.class),
                		ResponseTypes.instanceOf(LoadResponseCharacteristic.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

