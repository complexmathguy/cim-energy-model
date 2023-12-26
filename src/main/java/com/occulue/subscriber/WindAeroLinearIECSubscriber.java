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
 * Subscriber for WindAeroLinearIEC related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("windAeroLinearIEC-subscriber")
public class WindAeroLinearIECSubscriber extends BaseSubscriber {

	public WindAeroLinearIECSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<WindAeroLinearIEC>, WindAeroLinearIEC> windAeroLinearIECSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllWindAeroLinearIECQuery(), 
                		ResponseTypes.multipleInstancesOf(WindAeroLinearIEC.class),
                		ResponseTypes.instanceOf(WindAeroLinearIEC.class));
    }

    public SubscriptionQueryResult<WindAeroLinearIEC, WindAeroLinearIEC> windAeroLinearIECSubscribe(@DestinationVariable UUID windAeroLinearIECId) {
        return queryGateway
                .subscriptionQuery(new FindWindAeroLinearIECQuery(new LoadWindAeroLinearIECFilter(windAeroLinearIECId)), 
                		ResponseTypes.instanceOf(WindAeroLinearIEC.class),
                		ResponseTypes.instanceOf(WindAeroLinearIEC.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

