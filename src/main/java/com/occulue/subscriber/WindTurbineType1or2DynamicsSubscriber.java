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
 * Subscriber for WindTurbineType1or2Dynamics related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("windTurbineType1or2Dynamics-subscriber")
public class WindTurbineType1or2DynamicsSubscriber extends BaseSubscriber {

	public WindTurbineType1or2DynamicsSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<WindTurbineType1or2Dynamics>, WindTurbineType1or2Dynamics> windTurbineType1or2DynamicsSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllWindTurbineType1or2DynamicsQuery(), 
                		ResponseTypes.multipleInstancesOf(WindTurbineType1or2Dynamics.class),
                		ResponseTypes.instanceOf(WindTurbineType1or2Dynamics.class));
    }

    public SubscriptionQueryResult<WindTurbineType1or2Dynamics, WindTurbineType1or2Dynamics> windTurbineType1or2DynamicsSubscribe(@DestinationVariable UUID windTurbineType1or2DynamicsId) {
        return queryGateway
                .subscriptionQuery(new FindWindTurbineType1or2DynamicsQuery(new LoadWindTurbineType1or2DynamicsFilter(windTurbineType1or2DynamicsId)), 
                		ResponseTypes.instanceOf(WindTurbineType1or2Dynamics.class),
                		ResponseTypes.instanceOf(WindTurbineType1or2Dynamics.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

