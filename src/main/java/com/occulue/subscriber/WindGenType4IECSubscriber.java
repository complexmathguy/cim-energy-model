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
 * Subscriber for WindGenType4IEC related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("windGenType4IEC-subscriber")
public class WindGenType4IECSubscriber extends BaseSubscriber {

	public WindGenType4IECSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<WindGenType4IEC>, WindGenType4IEC> windGenType4IECSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllWindGenType4IECQuery(), 
                		ResponseTypes.multipleInstancesOf(WindGenType4IEC.class),
                		ResponseTypes.instanceOf(WindGenType4IEC.class));
    }

    public SubscriptionQueryResult<WindGenType4IEC, WindGenType4IEC> windGenType4IECSubscribe(@DestinationVariable UUID windGenType4IECId) {
        return queryGateway
                .subscriptionQuery(new FindWindGenType4IECQuery(new LoadWindGenType4IECFilter(windGenType4IECId)), 
                		ResponseTypes.instanceOf(WindGenType4IEC.class),
                		ResponseTypes.instanceOf(WindGenType4IEC.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

