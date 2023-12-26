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
 * Subscriber for WindPlantUserDefined related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("windPlantUserDefined-subscriber")
public class WindPlantUserDefinedSubscriber extends BaseSubscriber {

	public WindPlantUserDefinedSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<WindPlantUserDefined>, WindPlantUserDefined> windPlantUserDefinedSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllWindPlantUserDefinedQuery(), 
                		ResponseTypes.multipleInstancesOf(WindPlantUserDefined.class),
                		ResponseTypes.instanceOf(WindPlantUserDefined.class));
    }

    public SubscriptionQueryResult<WindPlantUserDefined, WindPlantUserDefined> windPlantUserDefinedSubscribe(@DestinationVariable UUID windPlantUserDefinedId) {
        return queryGateway
                .subscriptionQuery(new FindWindPlantUserDefinedQuery(new LoadWindPlantUserDefinedFilter(windPlantUserDefinedId)), 
                		ResponseTypes.instanceOf(WindPlantUserDefined.class),
                		ResponseTypes.instanceOf(WindPlantUserDefined.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

