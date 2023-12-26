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
 * Subscriber for WindAeroConstIEC related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("windAeroConstIEC-subscriber")
public class WindAeroConstIECSubscriber extends BaseSubscriber {

	public WindAeroConstIECSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<WindAeroConstIEC>, WindAeroConstIEC> windAeroConstIECSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllWindAeroConstIECQuery(), 
                		ResponseTypes.multipleInstancesOf(WindAeroConstIEC.class),
                		ResponseTypes.instanceOf(WindAeroConstIEC.class));
    }

    public SubscriptionQueryResult<WindAeroConstIEC, WindAeroConstIEC> windAeroConstIECSubscribe(@DestinationVariable UUID windAeroConstIECId) {
        return queryGateway
                .subscriptionQuery(new FindWindAeroConstIECQuery(new LoadWindAeroConstIECFilter(windAeroConstIECId)), 
                		ResponseTypes.instanceOf(WindAeroConstIEC.class),
                		ResponseTypes.instanceOf(WindAeroConstIEC.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

