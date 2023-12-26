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
 * Subscriber for WindGenTurbineType2IEC related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("windGenTurbineType2IEC-subscriber")
public class WindGenTurbineType2IECSubscriber extends BaseSubscriber {

	public WindGenTurbineType2IECSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<WindGenTurbineType2IEC>, WindGenTurbineType2IEC> windGenTurbineType2IECSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllWindGenTurbineType2IECQuery(), 
                		ResponseTypes.multipleInstancesOf(WindGenTurbineType2IEC.class),
                		ResponseTypes.instanceOf(WindGenTurbineType2IEC.class));
    }

    public SubscriptionQueryResult<WindGenTurbineType2IEC, WindGenTurbineType2IEC> windGenTurbineType2IECSubscribe(@DestinationVariable UUID windGenTurbineType2IECId) {
        return queryGateway
                .subscriptionQuery(new FindWindGenTurbineType2IECQuery(new LoadWindGenTurbineType2IECFilter(windGenTurbineType2IECId)), 
                		ResponseTypes.instanceOf(WindGenTurbineType2IEC.class),
                		ResponseTypes.instanceOf(WindGenTurbineType2IEC.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

