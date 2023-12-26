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
 * Subscriber for WindContPType4bIEC related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("windContPType4bIEC-subscriber")
public class WindContPType4bIECSubscriber extends BaseSubscriber {

	public WindContPType4bIECSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<WindContPType4bIEC>, WindContPType4bIEC> windContPType4bIECSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllWindContPType4bIECQuery(), 
                		ResponseTypes.multipleInstancesOf(WindContPType4bIEC.class),
                		ResponseTypes.instanceOf(WindContPType4bIEC.class));
    }

    public SubscriptionQueryResult<WindContPType4bIEC, WindContPType4bIEC> windContPType4bIECSubscribe(@DestinationVariable UUID windContPType4bIECId) {
        return queryGateway
                .subscriptionQuery(new FindWindContPType4bIECQuery(new LoadWindContPType4bIECFilter(windContPType4bIECId)), 
                		ResponseTypes.instanceOf(WindContPType4bIEC.class),
                		ResponseTypes.instanceOf(WindContPType4bIEC.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

