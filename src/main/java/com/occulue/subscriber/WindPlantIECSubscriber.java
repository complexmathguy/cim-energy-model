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
 * Subscriber for WindPlantIEC related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("windPlantIEC-subscriber")
public class WindPlantIECSubscriber extends BaseSubscriber {

	public WindPlantIECSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<WindPlantIEC>, WindPlantIEC> windPlantIECSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllWindPlantIECQuery(), 
                		ResponseTypes.multipleInstancesOf(WindPlantIEC.class),
                		ResponseTypes.instanceOf(WindPlantIEC.class));
    }

    public SubscriptionQueryResult<WindPlantIEC, WindPlantIEC> windPlantIECSubscribe(@DestinationVariable UUID windPlantIECId) {
        return queryGateway
                .subscriptionQuery(new FindWindPlantIECQuery(new LoadWindPlantIECFilter(windPlantIECId)), 
                		ResponseTypes.instanceOf(WindPlantIEC.class),
                		ResponseTypes.instanceOf(WindPlantIEC.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

