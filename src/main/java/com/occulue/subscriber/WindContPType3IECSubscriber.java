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
 * Subscriber for WindContPType3IEC related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("windContPType3IEC-subscriber")
public class WindContPType3IECSubscriber extends BaseSubscriber {

	public WindContPType3IECSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<WindContPType3IEC>, WindContPType3IEC> windContPType3IECSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllWindContPType3IECQuery(), 
                		ResponseTypes.multipleInstancesOf(WindContPType3IEC.class),
                		ResponseTypes.instanceOf(WindContPType3IEC.class));
    }

    public SubscriptionQueryResult<WindContPType3IEC, WindContPType3IEC> windContPType3IECSubscribe(@DestinationVariable UUID windContPType3IECId) {
        return queryGateway
                .subscriptionQuery(new FindWindContPType3IECQuery(new LoadWindContPType3IECFilter(windContPType3IECId)), 
                		ResponseTypes.instanceOf(WindContPType3IEC.class),
                		ResponseTypes.instanceOf(WindContPType3IEC.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

