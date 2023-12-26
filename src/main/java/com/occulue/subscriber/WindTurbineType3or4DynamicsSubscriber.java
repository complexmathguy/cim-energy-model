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
 * Subscriber for WindTurbineType3or4Dynamics related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("windTurbineType3or4Dynamics-subscriber")
public class WindTurbineType3or4DynamicsSubscriber extends BaseSubscriber {

	public WindTurbineType3or4DynamicsSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<WindTurbineType3or4Dynamics>, WindTurbineType3or4Dynamics> windTurbineType3or4DynamicsSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllWindTurbineType3or4DynamicsQuery(), 
                		ResponseTypes.multipleInstancesOf(WindTurbineType3or4Dynamics.class),
                		ResponseTypes.instanceOf(WindTurbineType3or4Dynamics.class));
    }

    public SubscriptionQueryResult<WindTurbineType3or4Dynamics, WindTurbineType3or4Dynamics> windTurbineType3or4DynamicsSubscribe(@DestinationVariable UUID windTurbineType3or4DynamicsId) {
        return queryGateway
                .subscriptionQuery(new FindWindTurbineType3or4DynamicsQuery(new LoadWindTurbineType3or4DynamicsFilter(windTurbineType3or4DynamicsId)), 
                		ResponseTypes.instanceOf(WindTurbineType3or4Dynamics.class),
                		ResponseTypes.instanceOf(WindTurbineType3or4Dynamics.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

