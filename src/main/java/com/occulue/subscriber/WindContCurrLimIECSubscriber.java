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
 * Subscriber for WindContCurrLimIEC related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("windContCurrLimIEC-subscriber")
public class WindContCurrLimIECSubscriber extends BaseSubscriber {

	public WindContCurrLimIECSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<WindContCurrLimIEC>, WindContCurrLimIEC> windContCurrLimIECSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllWindContCurrLimIECQuery(), 
                		ResponseTypes.multipleInstancesOf(WindContCurrLimIEC.class),
                		ResponseTypes.instanceOf(WindContCurrLimIEC.class));
    }

    public SubscriptionQueryResult<WindContCurrLimIEC, WindContCurrLimIEC> windContCurrLimIECSubscribe(@DestinationVariable UUID windContCurrLimIECId) {
        return queryGateway
                .subscriptionQuery(new FindWindContCurrLimIECQuery(new LoadWindContCurrLimIECFilter(windContCurrLimIECId)), 
                		ResponseTypes.instanceOf(WindContCurrLimIEC.class),
                		ResponseTypes.instanceOf(WindContCurrLimIEC.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

