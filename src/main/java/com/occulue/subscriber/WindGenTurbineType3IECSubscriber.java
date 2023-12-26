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
 * Subscriber for WindGenTurbineType3IEC related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("windGenTurbineType3IEC-subscriber")
public class WindGenTurbineType3IECSubscriber extends BaseSubscriber {

	public WindGenTurbineType3IECSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<WindGenTurbineType3IEC>, WindGenTurbineType3IEC> windGenTurbineType3IECSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllWindGenTurbineType3IECQuery(), 
                		ResponseTypes.multipleInstancesOf(WindGenTurbineType3IEC.class),
                		ResponseTypes.instanceOf(WindGenTurbineType3IEC.class));
    }

    public SubscriptionQueryResult<WindGenTurbineType3IEC, WindGenTurbineType3IEC> windGenTurbineType3IECSubscribe(@DestinationVariable UUID windGenTurbineType3IECId) {
        return queryGateway
                .subscriptionQuery(new FindWindGenTurbineType3IECQuery(new LoadWindGenTurbineType3IECFilter(windGenTurbineType3IECId)), 
                		ResponseTypes.instanceOf(WindGenTurbineType3IEC.class),
                		ResponseTypes.instanceOf(WindGenTurbineType3IEC.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

