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
 * Subscriber for WindTurbineType4aIEC related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("windTurbineType4aIEC-subscriber")
public class WindTurbineType4aIECSubscriber extends BaseSubscriber {

	public WindTurbineType4aIECSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<WindTurbineType4aIEC>, WindTurbineType4aIEC> windTurbineType4aIECSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllWindTurbineType4aIECQuery(), 
                		ResponseTypes.multipleInstancesOf(WindTurbineType4aIEC.class),
                		ResponseTypes.instanceOf(WindTurbineType4aIEC.class));
    }

    public SubscriptionQueryResult<WindTurbineType4aIEC, WindTurbineType4aIEC> windTurbineType4aIECSubscribe(@DestinationVariable UUID windTurbineType4aIECId) {
        return queryGateway
                .subscriptionQuery(new FindWindTurbineType4aIECQuery(new LoadWindTurbineType4aIECFilter(windTurbineType4aIECId)), 
                		ResponseTypes.instanceOf(WindTurbineType4aIEC.class),
                		ResponseTypes.instanceOf(WindTurbineType4aIEC.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

