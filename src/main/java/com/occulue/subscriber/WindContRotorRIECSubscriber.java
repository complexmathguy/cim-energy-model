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
 * Subscriber for WindContRotorRIEC related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("windContRotorRIEC-subscriber")
public class WindContRotorRIECSubscriber extends BaseSubscriber {

	public WindContRotorRIECSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<WindContRotorRIEC>, WindContRotorRIEC> windContRotorRIECSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllWindContRotorRIECQuery(), 
                		ResponseTypes.multipleInstancesOf(WindContRotorRIEC.class),
                		ResponseTypes.instanceOf(WindContRotorRIEC.class));
    }

    public SubscriptionQueryResult<WindContRotorRIEC, WindContRotorRIEC> windContRotorRIECSubscribe(@DestinationVariable UUID windContRotorRIECId) {
        return queryGateway
                .subscriptionQuery(new FindWindContRotorRIECQuery(new LoadWindContRotorRIECFilter(windContRotorRIECId)), 
                		ResponseTypes.instanceOf(WindContRotorRIEC.class),
                		ResponseTypes.instanceOf(WindContRotorRIEC.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

