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
 * Subscriber for WindTurbineType3or4IEC related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("windTurbineType3or4IEC-subscriber")
public class WindTurbineType3or4IECSubscriber extends BaseSubscriber {

	public WindTurbineType3or4IECSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<WindTurbineType3or4IEC>, WindTurbineType3or4IEC> windTurbineType3or4IECSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllWindTurbineType3or4IECQuery(), 
                		ResponseTypes.multipleInstancesOf(WindTurbineType3or4IEC.class),
                		ResponseTypes.instanceOf(WindTurbineType3or4IEC.class));
    }

    public SubscriptionQueryResult<WindTurbineType3or4IEC, WindTurbineType3or4IEC> windTurbineType3or4IECSubscribe(@DestinationVariable UUID windTurbineType3or4IECId) {
        return queryGateway
                .subscriptionQuery(new FindWindTurbineType3or4IECQuery(new LoadWindTurbineType3or4IECFilter(windTurbineType3or4IECId)), 
                		ResponseTypes.instanceOf(WindTurbineType3or4IEC.class),
                		ResponseTypes.instanceOf(WindTurbineType3or4IEC.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

