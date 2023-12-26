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
 * Subscriber for WindMechIEC related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("windMechIEC-subscriber")
public class WindMechIECSubscriber extends BaseSubscriber {

	public WindMechIECSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<WindMechIEC>, WindMechIEC> windMechIECSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllWindMechIECQuery(), 
                		ResponseTypes.multipleInstancesOf(WindMechIEC.class),
                		ResponseTypes.instanceOf(WindMechIEC.class));
    }

    public SubscriptionQueryResult<WindMechIEC, WindMechIEC> windMechIECSubscribe(@DestinationVariable UUID windMechIECId) {
        return queryGateway
                .subscriptionQuery(new FindWindMechIECQuery(new LoadWindMechIECFilter(windMechIECId)), 
                		ResponseTypes.instanceOf(WindMechIEC.class),
                		ResponseTypes.instanceOf(WindMechIEC.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

