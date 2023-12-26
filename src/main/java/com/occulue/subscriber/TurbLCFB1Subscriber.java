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
 * Subscriber for TurbLCFB1 related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("turbLCFB1-subscriber")
public class TurbLCFB1Subscriber extends BaseSubscriber {

	public TurbLCFB1Subscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<TurbLCFB1>, TurbLCFB1> turbLCFB1Subscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllTurbLCFB1Query(), 
                		ResponseTypes.multipleInstancesOf(TurbLCFB1.class),
                		ResponseTypes.instanceOf(TurbLCFB1.class));
    }

    public SubscriptionQueryResult<TurbLCFB1, TurbLCFB1> turbLCFB1Subscribe(@DestinationVariable UUID turbLCFB1Id) {
        return queryGateway
                .subscriptionQuery(new FindTurbLCFB1Query(new LoadTurbLCFB1Filter(turbLCFB1Id)), 
                		ResponseTypes.instanceOf(TurbLCFB1.class),
                		ResponseTypes.instanceOf(TurbLCFB1.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

