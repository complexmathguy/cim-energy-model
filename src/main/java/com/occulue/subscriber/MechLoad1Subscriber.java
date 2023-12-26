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
 * Subscriber for MechLoad1 related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("mechLoad1-subscriber")
public class MechLoad1Subscriber extends BaseSubscriber {

	public MechLoad1Subscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<MechLoad1>, MechLoad1> mechLoad1Subscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllMechLoad1Query(), 
                		ResponseTypes.multipleInstancesOf(MechLoad1.class),
                		ResponseTypes.instanceOf(MechLoad1.class));
    }

    public SubscriptionQueryResult<MechLoad1, MechLoad1> mechLoad1Subscribe(@DestinationVariable UUID mechLoad1Id) {
        return queryGateway
                .subscriptionQuery(new FindMechLoad1Query(new LoadMechLoad1Filter(mechLoad1Id)), 
                		ResponseTypes.instanceOf(MechLoad1.class),
                		ResponseTypes.instanceOf(MechLoad1.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

