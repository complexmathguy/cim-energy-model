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
 * Subscriber for Pss5 related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("pss5-subscriber")
public class Pss5Subscriber extends BaseSubscriber {

	public Pss5Subscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<Pss5>, Pss5> pss5Subscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllPss5Query(), 
                		ResponseTypes.multipleInstancesOf(Pss5.class),
                		ResponseTypes.instanceOf(Pss5.class));
    }

    public SubscriptionQueryResult<Pss5, Pss5> pss5Subscribe(@DestinationVariable UUID pss5Id) {
        return queryGateway
                .subscriptionQuery(new FindPss5Query(new LoadPss5Filter(pss5Id)), 
                		ResponseTypes.instanceOf(Pss5.class),
                		ResponseTypes.instanceOf(Pss5.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

