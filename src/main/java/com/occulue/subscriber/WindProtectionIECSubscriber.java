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
 * Subscriber for WindProtectionIEC related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("windProtectionIEC-subscriber")
public class WindProtectionIECSubscriber extends BaseSubscriber {

	public WindProtectionIECSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<WindProtectionIEC>, WindProtectionIEC> windProtectionIECSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllWindProtectionIECQuery(), 
                		ResponseTypes.multipleInstancesOf(WindProtectionIEC.class),
                		ResponseTypes.instanceOf(WindProtectionIEC.class));
    }

    public SubscriptionQueryResult<WindProtectionIEC, WindProtectionIEC> windProtectionIECSubscribe(@DestinationVariable UUID windProtectionIECId) {
        return queryGateway
                .subscriptionQuery(new FindWindProtectionIECQuery(new LoadWindProtectionIECFilter(windProtectionIECId)), 
                		ResponseTypes.instanceOf(WindProtectionIEC.class),
                		ResponseTypes.instanceOf(WindProtectionIEC.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

