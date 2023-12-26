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
 * Subscriber for WindContPType4aIEC related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("windContPType4aIEC-subscriber")
public class WindContPType4aIECSubscriber extends BaseSubscriber {

	public WindContPType4aIECSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<WindContPType4aIEC>, WindContPType4aIEC> windContPType4aIECSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllWindContPType4aIECQuery(), 
                		ResponseTypes.multipleInstancesOf(WindContPType4aIEC.class),
                		ResponseTypes.instanceOf(WindContPType4aIEC.class));
    }

    public SubscriptionQueryResult<WindContPType4aIEC, WindContPType4aIEC> windContPType4aIECSubscribe(@DestinationVariable UUID windContPType4aIECId) {
        return queryGateway
                .subscriptionQuery(new FindWindContPType4aIECQuery(new LoadWindContPType4aIECFilter(windContPType4aIECId)), 
                		ResponseTypes.instanceOf(WindContPType4aIEC.class),
                		ResponseTypes.instanceOf(WindContPType4aIEC.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

