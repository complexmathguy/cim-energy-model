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
 * Subscriber for WindGenTurbineType1IEC related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("windGenTurbineType1IEC-subscriber")
public class WindGenTurbineType1IECSubscriber extends BaseSubscriber {

	public WindGenTurbineType1IECSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<WindGenTurbineType1IEC>, WindGenTurbineType1IEC> windGenTurbineType1IECSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllWindGenTurbineType1IECQuery(), 
                		ResponseTypes.multipleInstancesOf(WindGenTurbineType1IEC.class),
                		ResponseTypes.instanceOf(WindGenTurbineType1IEC.class));
    }

    public SubscriptionQueryResult<WindGenTurbineType1IEC, WindGenTurbineType1IEC> windGenTurbineType1IECSubscribe(@DestinationVariable UUID windGenTurbineType1IECId) {
        return queryGateway
                .subscriptionQuery(new FindWindGenTurbineType1IECQuery(new LoadWindGenTurbineType1IECFilter(windGenTurbineType1IECId)), 
                		ResponseTypes.instanceOf(WindGenTurbineType1IEC.class),
                		ResponseTypes.instanceOf(WindGenTurbineType1IEC.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

